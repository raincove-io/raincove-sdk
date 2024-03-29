package io.github.erfangc.raincove.sdk.apis;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import static io.github.erfangc.raincove.sdk.apis.CredentialFile.isExpired;
import static io.github.erfangc.raincove.sdk.apis.CredentialFile.readCredentialFile;

/**
 * Intercepts {@link feign.Feign} requests and append a Authorization header to be validated by the API server the SDK calls
 * <p>
 * Builds in many mechanisms for authenticating a principal, whether it be a machine user or a desktop user. Primarily relies on
 * OAuth 2.0 grant types to exchange user or machine credentials for access token. If the interceptor is created with an access token
 * provided, that access token will be used instead of the default credential provider chain
 */
public class AccessTokenInterceptor implements RequestInterceptor {

    private Credentials credentials;
    private String accessToken;
    public static String audience = "https://api.raincove.io";

    AccessTokenInterceptor(String accessToken) {
        this.accessToken = accessToken;
    }

    AccessTokenInterceptor() {
    }

    @Override
    public void apply(RequestTemplate template) {
        String token;
        if (accessToken != null) {
            token = accessToken;
        } else {
            token = resolveToken();
        }
        template.header("Authorization", credentials.getTokenType() + " " + token);
    }

    private String resolveToken() {
        if (credentials == null || isExpired(credentials)) {
            credentials = fromProviderChain();
        }
        return credentials.getAccessToken();
    }

    /**
     * The provider chain uses the hierarchy
     * - If CLIENT_ID/CLIENT_SECRET environment variable exists, they will be used to redeem an access token representing the machine user
     * - If a credentials file already exist it will be used instead
     * - Otherwise a Authorization Code with PKCE mechanism will be used to log a user in (their browser window will open)
     *
     * @return a {@link Credentials} instance with a valid and none expired access token / id_token
     */
    private Credentials fromProviderChain() {
        Credentials newCredentials = null;
        if (System.getenv("CLIENT_ID") != null && System.getenv("CLIENT_SECRET") != null) {
            newCredentials = clientCredentialExchange();
        }
        if (newCredentials == null) {
            newCredentials = readCredentialFile();
        }
        if (newCredentials == null) {
            newCredentials = authorizationCodeExchange();
        }
        if (newCredentials == null) {
            throw new IllegalStateException("Unable to provision credentials for API access");
        }
        return newCredentials;
    }

    private Credentials authorizationCodeExchange() {
        return new PKCEService().runPKCE();
    }

    private Credentials clientCredentialExchange() {
        String clientId = System.getenv("CLIENT_ID");
        String clientSecret = System.getenv("CLIENT_SECRET");
        Auth0.ClientCredentialsGrantRequest request = new Auth0
                .ClientCredentialsGrantRequest()
                .setAudience(audience)
                .setClientId(clientId)
                .setClientSecret(clientSecret);
        return Auth0.getInstance().clientCredentialsGrant(request);
    }

}
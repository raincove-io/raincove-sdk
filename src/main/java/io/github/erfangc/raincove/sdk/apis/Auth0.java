package io.github.erfangc.raincove.sdk.apis;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

class Auth0 {

    static Auth0Client getInstance() {
        return Feign
                .builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(Auth0Client.class, "https://raincove.auth0.com");
    }

    interface Auth0Client {
        @RequestLine("POST /oauth/token")
        @Headers({"Content-Type: application/x-www-form-urlencoded"})
        @Body("grant_type={grant_type}&client_id={client_id}&code_verifier={code_verifier}&code={code}&redirect_uri={redirect_uri}")
        Credentials exchangeCode(
                @Param("grant_type") String grantType,
                @Param("client_id") String clientId,
                @Param("code_verifier") String codeVerifier,
                @Param("code") String code,
                @Param("redirect_uri") String redirectUri
        );

        @RequestLine("POST /oauth/token")
        @Headers({"Content-Type: application/json"})
        Credentials clientCredentialsGrant(ClientCredentialsGrantRequest request);
    }

    static class ClientCredentialsGrantRequest {

        @JsonProperty("client_id")
        private String clientId;
        @JsonProperty("client_secret")
        private String clientSecret;
        @JsonProperty("audience")
        private String audience;
        @JsonProperty("grant_type")
        private String grantType = "client_credentials";

        public String getClientId() {
            return clientId;
        }

        public ClientCredentialsGrantRequest setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public ClientCredentialsGrantRequest setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public String getAudience() {
            return audience;
        }

        public ClientCredentialsGrantRequest setAudience(String audience) {
            this.audience = audience;
            return this;
        }

        public String getGrantType() {
            return grantType;
        }

        public ClientCredentialsGrantRequest setGrantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

    }

}
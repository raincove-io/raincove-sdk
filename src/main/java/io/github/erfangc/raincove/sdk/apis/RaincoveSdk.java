package io.github.erfangc.raincove.sdk.apis;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.github.erfangc.raincove.sdk.operations.Finser;

public class RaincoveSdk {

    private static String baseUrl;

    public static void setBaseUrl(String baseUrl) {
        RaincoveSdk.baseUrl = baseUrl;
    }

    public static Finser finser(String accessToken) {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor(accessToken))
                .target(Finser.class, RaincoveSdk.baseUrl != null ? RaincoveSdk.baseUrl : "https://api.raincove.io/finser/api/v1");
    }

    public static Finser finser() {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor())
                .target(Finser.class, RaincoveSdk.baseUrl != null ? RaincoveSdk.baseUrl : "https://api.raincove.io/finser/api/v1");

    }

}
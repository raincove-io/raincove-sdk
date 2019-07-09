package io.github.erfangc.raincove.sdk.apis;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.github.erfangc.raincove.sdk.operations.Finser;
import io.github.erfangc.raincove.sdk.operations.IAM;

public class RaincoveSdk {

    private static String endpoint = "https://api.raincove.io";

    public static void setEndpoint(String endpoint) {
        RaincoveSdk.endpoint = endpoint;
    }

    public static Finser finser(String accessToken) {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor(accessToken))
                .target(Finser.class, RaincoveSdk.endpoint + "/finser/api/v1");
    }

    public static Finser finser() {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor())
                .target(Finser.class, RaincoveSdk.endpoint + "/finser/api/v1");
    }

    public static IAM iam(String accessToken) {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor(accessToken))
                .target(IAM.class, RaincoveSdk.endpoint + "/iam/api/v1");
    }

    public static IAM iam() {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor())
                .target(IAM.class, RaincoveSdk.endpoint + "/iam/api/v1");
    }

}
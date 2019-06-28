package io.github.erfangc.raincove.sdk.apis;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.github.erfangc.raincove.sdk.operations.Companies;
import io.github.erfangc.raincove.sdk.operations.FinancialStatements;

public class RaincoveSdk {

    private static String baseUrl;

    public static void setBaseUrl(String baseUrl) {
        RaincoveSdk.baseUrl = baseUrl;
    }

    public static Companies companies(String accessToken) {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor(accessToken))
                .target(Companies.class, RaincoveSdk.baseUrl != null ? RaincoveSdk.baseUrl : "https://api.raincove.io/");
    }

    public static Companies companies() {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor())
                .target(Companies.class, RaincoveSdk.baseUrl != null ? RaincoveSdk.baseUrl : "https://api.raincove.io/");

    }

    public static FinancialStatements financialStatements(String accessToken) {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor(accessToken))
                .target(FinancialStatements.class, RaincoveSdk.baseUrl != null ? RaincoveSdk.baseUrl : "https://api.raincove.io/");
    }

    public static FinancialStatements financialStatements() {
        return Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AccessTokenInterceptor())
                .target(FinancialStatements.class, RaincoveSdk.baseUrl != null ? RaincoveSdk.baseUrl : "https://api.raincove.io/");

    }

}
package io.github.erfangc.raincove.sdk.operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.erfangc.raincove.sdk.models.Company;

public interface Companies {

    @RequestLine("POST /companies")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void createCompany(Company body);

    @RequestLine("GET /companies/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Company getCompany(@Param("id") String id);

    @RequestLine("DELETE /companies/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void deleteCompany(@Param("id") String id);

    @RequestLine("PUT /companies/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void updateCompany(Company body, @Param("id") String id);

}
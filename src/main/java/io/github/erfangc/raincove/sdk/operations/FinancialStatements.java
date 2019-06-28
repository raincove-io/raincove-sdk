package io.github.erfangc.raincove.sdk.operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.erfangc.raincove.sdk.models.SearchFinancialStatementsRequest;
import io.github.erfangc.raincove.sdk.models.GetFinancialStatementsResponse;
import io.github.erfangc.raincove.sdk.models.CreateFinancialStatementsRequest;
import io.github.erfangc.raincove.sdk.models.SearchFinancialStatementsResponse;
import io.github.erfangc.raincove.sdk.models.GaapFinancialStatement;

public interface FinancialStatements {

    @RequestLine("GET /companies/{companyId}/financial-statements")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetFinancialStatementsResponse getFinancialStatements(@Param("companyId") String companyId);

    @RequestLine("DELETE /companies/{companyId}/financial-statements")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void deleteFinancialStatements(@Param("companyId") String companyId);

    @RequestLine("POST /companies/{companyId}/financial-statements")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void createFinancialStatements(CreateFinancialStatementsRequest body, @Param("companyId") String companyId);

    @RequestLine("GET /companies/{companyId}/financial-statements/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GaapFinancialStatement getFinancialStatement(@Param("companyId") String companyId,@Param("id") String id);

    @RequestLine("DELETE /companies/{companyId}/financial-statements/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void deleteFinancialStatement(@Param("companyId") String companyId,@Param("id") String id);

    @RequestLine("PUT /companies/{companyId}/financial-statements/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    void updateFinancialStatement(GaapFinancialStatement body, @Param("companyId") String companyId, @Param("id") String id);

    @RequestLine("POST /companies/financial-statements/_search")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    SearchFinancialStatementsResponse searchFinancialStatements(SearchFinancialStatementsRequest body);

}
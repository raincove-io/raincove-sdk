package io.github.erfangc.raincove.sdk.operations;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateCompanyRequest;
import io.github.erfangc.raincove.sdk.models.SearchFinancialStatementsRequest;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateCompanyResponse;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateFinancialStatementsRequest;
import io.github.erfangc.raincove.sdk.models.CreateOrUpdateFinancialStatementsResponse;
import io.github.erfangc.raincove.sdk.models.DeleteFinancialStatementResponse;
import io.github.erfangc.raincove.sdk.models.GetCompanyResponse;
import io.github.erfangc.raincove.sdk.models.GetFinancialStatementResponse;
import io.github.erfangc.raincove.sdk.models.GetFinancialStatementsResponse;
import io.github.erfangc.raincove.sdk.models.SearchFinancialStatementsResponse;
import io.github.erfangc.raincove.sdk.models.DeleteCompanyResponse;
import io.github.erfangc.raincove.sdk.models.DeleteFinancialStatementsResponse;

public interface Finser {

    @RequestLine("POST /companies")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    CreateOrUpdateCompanyResponse createOrUpdateCompany(CreateOrUpdateCompanyRequest body);

    @RequestLine("GET /companies/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetCompanyResponse getCompany(@Param("id") String id);

    @RequestLine("DELETE /companies/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    DeleteCompanyResponse deleteCompany(@Param("id") String id);

    @RequestLine("GET /companies/{companyId}/financial-statements")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetFinancialStatementsResponse getFinancialStatements(@Param("companyId") String companyId);

    @RequestLine("DELETE /companies/{companyId}/financial-statements")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    DeleteFinancialStatementsResponse deleteFinancialStatements(@Param("companyId") String companyId);

    @RequestLine("POST /companies/{companyId}/financial-statements")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    CreateOrUpdateFinancialStatementsResponse createOrUpdateFinancialStatements(CreateOrUpdateFinancialStatementsRequest body, @Param("companyId") String companyId);

    @RequestLine("GET /companies/{companyId}/financial-statements/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    GetFinancialStatementResponse getFinancialStatement(@Param("companyId") String companyId,@Param("id") String id);

    @RequestLine("DELETE /companies/{companyId}/financial-statements/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    DeleteFinancialStatementResponse deleteFinancialStatement(@Param("companyId") String companyId,@Param("id") String id);

    @RequestLine("POST /companies/financial-statements/_search")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    SearchFinancialStatementsResponse searchFinancialStatements(SearchFinancialStatementsRequest body);

}
package io.github.erfangc.raincove.sdk.models;

import java.util.List;

public class SearchFinancialStatementsResponse {

    private List<GaapFinancialStatement> financialStatements;

    public List<GaapFinancialStatement> getFinancialStatements() {
        return this.financialStatements;
    }

    public SearchFinancialStatementsResponse setFinancialStatements(List<GaapFinancialStatement> financialStatements) {
        this.financialStatements = financialStatements;
        return this;
    }

}
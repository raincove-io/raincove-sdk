package io.github.erfangc.raincove.sdk.models;

import java.util.List;

public class CreateFinancialStatementsRequest {

    private List<GaapFinancialStatement> financialStatements;

    public List<GaapFinancialStatement> getFinancialStatements() {
        return this.financialStatements;
    }

    public CreateFinancialStatementsRequest setFinancialStatements(List<GaapFinancialStatement> financialStatements) {
        this.financialStatements = financialStatements;
        return this;
    }

}
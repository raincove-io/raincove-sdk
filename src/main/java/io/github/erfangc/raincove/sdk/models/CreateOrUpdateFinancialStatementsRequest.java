package io.github.erfangc.raincove.sdk.models;

import java.util.List;

public class CreateOrUpdateFinancialStatementsRequest {

    private List<FinancialStatement> financialStatements;

    public List<FinancialStatement> getFinancialStatements() {
        return this.financialStatements;
    }

    public CreateOrUpdateFinancialStatementsRequest setFinancialStatements(List<FinancialStatement> financialStatements) {
        this.financialStatements = financialStatements;
        return this;
    }

}
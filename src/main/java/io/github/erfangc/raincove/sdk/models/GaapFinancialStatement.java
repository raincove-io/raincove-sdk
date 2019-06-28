package io.github.erfangc.raincove.sdk.models;


public class GaapFinancialStatement {

    private String companyId;
    private String id;
    private String filingType;
    private String url;
    private String date;
    private String createdOn;
    private String createdBy;
    private String updatedOn;
    private String updatedBy;
    private IncomeStatement incomeStatement;
    private BalanceSheet balanaceSheet;
    private CashflowStatement cashflowStatement;

    public String getCompanyId() {
        return this.companyId;
    }

    public GaapFinancialStatement setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public GaapFinancialStatement setId(String id) {
        this.id = id;
        return this;
    }

    public String getFilingType() {
        return this.filingType;
    }

    public GaapFinancialStatement setFilingType(String filingType) {
        this.filingType = filingType;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public GaapFinancialStatement setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDate() {
        return this.date;
    }

    public GaapFinancialStatement setDate(String date) {
        this.date = date;
        return this;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public GaapFinancialStatement setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public GaapFinancialStatement setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedOn() {
        return this.updatedOn;
    }

    public GaapFinancialStatement setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public GaapFinancialStatement setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public IncomeStatement getIncomeStatement() {
        return this.incomeStatement;
    }

    public GaapFinancialStatement setIncomeStatement(IncomeStatement incomeStatement) {
        this.incomeStatement = incomeStatement;
        return this;
    }

    public BalanceSheet getBalanaceSheet() {
        return this.balanaceSheet;
    }

    public GaapFinancialStatement setBalanaceSheet(BalanceSheet balanaceSheet) {
        this.balanaceSheet = balanaceSheet;
        return this;
    }

    public CashflowStatement getCashflowStatement() {
        return this.cashflowStatement;
    }

    public GaapFinancialStatement setCashflowStatement(CashflowStatement cashflowStatement) {
        this.cashflowStatement = cashflowStatement;
        return this;
    }

}
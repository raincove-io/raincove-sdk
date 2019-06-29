package io.github.erfangc.raincove.sdk.models;


public class CreateOrUpdateCompanyRequest {

    private Company company;

    public Company getCompany() {
        return this.company;
    }

    public CreateOrUpdateCompanyRequest setCompany(Company company) {
        this.company = company;
        return this;
    }

}
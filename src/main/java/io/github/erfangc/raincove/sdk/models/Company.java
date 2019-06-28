package io.github.erfangc.raincove.sdk.models;


public class Company {

    private String id;
    private String idType;
    private String description;
    private String sector;
    private String industry;
    private String country;
    private String ticker;
    private String name;
    private String createdOn;
    private String createdBy;
    private String updatedOn;
    private String updatedBy;

    public String getId() {
        return this.id;
    }

    public Company setId(String id) {
        this.id = id;
        return this;
    }

    public String getIdType() {
        return this.idType;
    }

    public Company setIdType(String idType) {
        this.idType = idType;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getSector() {
        return this.sector;
    }

    public Company setSector(String sector) {
        this.sector = sector;
        return this;
    }

    public String getIndustry() {
        return this.industry;
    }

    public Company setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getCountry() {
        return this.country;
    }

    public Company setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getTicker() {
        return this.ticker;
    }

    public Company setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public Company setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Company setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedOn() {
        return this.updatedOn;
    }

    public Company setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public Company setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

}
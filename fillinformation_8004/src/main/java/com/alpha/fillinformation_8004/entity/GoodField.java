package com.alpha.fillinformation_8004.entity;

public class GoodField {

    String workroom_username;

    Integer website_build;

    Integer mobile_development;

    Integer software_development;

    Integer product_UI_IT_solutions;

    Integer saasServeice;

    Integer domain_name_cloud_services;

    Integer data_services;

    Integer testing_services;

    public String getWorkroom_username() {
        return workroom_username;
    }

    public void setWorkroom_username(String workroom_username) {
        this.workroom_username = workroom_username;
    }

    public Integer getWebsite_build() {
        return website_build;
    }

    public void setWebsite_build(Integer website_build) {
        this.website_build = website_build;
    }

    public Integer getMobile_development() {
        return mobile_development;
    }

    public void setMobile_development(Integer mobile_development) {
        this.mobile_development = mobile_development;
    }

    public Integer getSoftware_development() {
        return software_development;
    }

    public void setSoftware_development(Integer software_development) {
        this.software_development = software_development;
    }

    public Integer getProduct_UI_IT_solutions() {
        return product_UI_IT_solutions;
    }

    public void setProduct_UI_IT_solutions(Integer product_UI_IT_solutions) {
        this.product_UI_IT_solutions = product_UI_IT_solutions;
    }

    public Integer getSaasServeice() {
        return saasServeice;
    }

    public void setSaasServeice(Integer saasServeice) {
        this.saasServeice = saasServeice;
    }

    public Integer getDomain_name_cloud_services() {
        return domain_name_cloud_services;
    }

    public void setDomain_name_cloud_services(Integer domain_name_cloud_services) {
        this.domain_name_cloud_services = domain_name_cloud_services;
    }

    public Integer getData_services() {
        return data_services;
    }

    public void setData_services(Integer data_services) {
        this.data_services = data_services;
    }

    public Integer getTesting_services() {
        return testing_services;
    }

    public void setTesting_services(Integer testing_services) {
        this.testing_services = testing_services;
    }

    @Override
    public String toString() {
        return "{" +
                "workroom_username='" + workroom_username + '\'' +
                ", website_build=" + website_build +
                ", mobile_development=" + mobile_development +
                ", software_development=" + software_development +
                ", product_UI_IT_solutions=" + product_UI_IT_solutions +
                ", saasServeice=" + saasServeice +
                ", domain_name_cloud_services=" + domain_name_cloud_services +
                ", data_services=" + data_services +
                ", testing_services=" + testing_services +
                '}';
    }
}

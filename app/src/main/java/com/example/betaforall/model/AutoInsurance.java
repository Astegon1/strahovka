package com.example.betaforall.model;
public class AutoInsurance {
    private String lastName; // Фамилия
    private String firstName; // Имя
    private String middleName; // Отчество
    private String regionDistrict; // Регион/Район
    private String city; // Город
    private String stspts; // СТСПТС
    private String vin; // VIN
    private String vehicleCategory; // Категория транспорта
    private String brandModel; // Марка/Модель
    private String manufactureYear; // Год выпуска
    private String vehicleUse; // Эксплуатация автомобиля
    private String service; // Услуга
    private String bank; // Банк

    // Конструктор
    public AutoInsurance() {}

    public AutoInsurance(String lastName, String firstName, String middleName, String regionDistrict, String city, String stspts, String vin, String vehicleCategory, String brandModel, String manufactureYear, String vehicleUse, String service, String bank) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.regionDistrict = regionDistrict;
        this.city = city;
        this.stspts = stspts;
        this.vin = vin;
        this.vehicleCategory = vehicleCategory;
        this.brandModel = brandModel;
        this.manufactureYear = manufactureYear;
        this.vehicleUse = vehicleUse;
        this.service = service;
        this.bank = bank;
    }

    // Геттеры и сеттеры
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getRegionDistrict() {
        return regionDistrict;
    }

    public void setRegionDistrict(String regionDistrict) {
        this.regionDistrict = regionDistrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStspts() {
        return stspts;
    }

    public void setStspts(String stspts) {
        this.stspts = stspts;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getVehicleUse() {
        return vehicleUse;
    }

    public void setVehicleUse(String vehicleUse) {
        this.vehicleUse = vehicleUse;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}

package com.example.betaforall.model;

public class Client {
    private String userId;        // Уникальный идентификатор клиента
    private String firstName;     // Имя
    private String lastName;      // Фамилия
    private String middleName;    // Отчество
    private String dateOfBirth;   // Дата рождения
    private String email;         // Электронная почта

    // Конструктор по умолчанию (нужен для Firebase)
    public Client() {
    }

    // Конструктор с параметрами
    public Client(String userId, String firstName, String lastName, String middleName, String dateOfBirth, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    // Геттеры и сеттеры
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

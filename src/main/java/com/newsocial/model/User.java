package com.newsocial.model;

public class User {

    private String  id;
    private String  username;
    private String  password;
    private String  encryptedPassword;
    private String  email;
    private String  name;
    private String  surname;
    private String  birthday;
    private String  birthmonth;
    private String  birthyear;
    private Long    birthdate;
    private Integer age;
    private String  nationality;
    private String  idCountry;

    private String  notes;
    private String  bio;
    private String  country;
    private String  city;
    private Picture picture;

    private Long    signUpDate;
    private String  signUpDateFormat;
    private Long    lastUpdateDate;
    private String  lastUpdateFormat;
    private Long    lastLoginDate;
    private String  lastLoginDateFormat;
    private Boolean active;
    private Boolean isPrivate;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getBirthmonth() {
        return birthmonth;
    }
    public void setBirthmonth(String birthmonth) {
        this.birthmonth = birthmonth;
    }
    public String getBirthyear() {
        return birthyear;
    }
    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }
    public Long getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Long birthdate) {
        this.birthdate = birthdate;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Long getSignUpDate() {
        return signUpDate;
    }
    public void setSignUpDate(Long signUpDate) {
        this.signUpDate = signUpDate;
    }
    public Long getLastLoginDate() {
        return lastLoginDate;
    }
    public void setLastLoginDate(Long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Picture getPicture() {
        return picture;
    }
    public void setPicture(Picture picture) {
        this.picture = picture;
    }
    public Boolean getIsPrivate() {
        return isPrivate;
    }
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    public String getSignUpDateFormat() {
        return signUpDateFormat;
    }
    public void setSignUpDateFormat(String signUpDateFormat) {
        this.signUpDateFormat = signUpDateFormat;
    }
    public Long getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Long lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public String getLastUpdateFormat() {
        return lastUpdateFormat;
    }
    public void setLastUpdateFormat(String lastUpdateFormat) {
        this.lastUpdateFormat = lastUpdateFormat;
    }
    public String getLastLoginDateFormat() {
        return lastLoginDateFormat;
    }
    public void setLastLoginDateFormat(String lastLoginDateFormat) {
        this.lastLoginDateFormat = lastLoginDateFormat;
    }
    public String getIdCountry() {
        return idCountry;
    }
    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", encryptedPassword=" + encryptedPassword
                + ", email=" + email + ", name=" + name + ", surname="
                + surname + ", birthday=" + birthday + ", birthmonth="
                + birthmonth + ", birthyear=" + birthyear + ", birthdate="
                + birthdate + ", age=" + age + ", nationality=" + nationality
                + ", idCountry=" + idCountry + ", notes=" + notes + ", bio="
                + bio + ", country=" + country + ", city=" + city
                + ", picture=" + picture + ", signUpDate=" + signUpDate
                + ", signUpDateFormat=" + signUpDateFormat
                + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateFormat="
                + lastUpdateFormat + ", lastLoginDate=" + lastLoginDate
                + ", lastLoginDateFormat=" + lastLoginDateFormat + ", active="
                + active + ", isPrivate=" + isPrivate + "]";
    }

}

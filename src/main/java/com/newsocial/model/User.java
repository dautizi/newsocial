package com.newsocial.model;

public class User {

    private String  id;
    private String  username;
    private String  password;
    private String  email;
    private String  name;
    private String  surname;
    private String  birthday;
    private String  birthmonth;
    private String  birthyear;
    private Integer birthdate;
    private String  nationality;

    private String  notes;
    private String  bio;
    private String  country;
    private String  city;
    private Picture picture;

    private Integer signUpDate;
    private Integer lastLoginDate;
    private Boolean active;
    private Boolean isPrivate;

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
    public Integer getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Integer birthdate) {
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
    public Integer getSignUpDate() {
        return signUpDate;
    }
    public void setSignUpDate(Integer signUpDate) {
        this.signUpDate = signUpDate;
    }
    public Integer getLastLoginDate() {
        return lastLoginDate;
    }
    public void setLastLoginDate(Integer lastLoginDate) {
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

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", email=" + email + ", name=" + name
                + ", surname=" + surname + ", birthday=" + birthday
                + ", birthmonth=" + birthmonth + ", birthyear=" + birthyear
                + ", birthdate=" + birthdate + ", nationality=" + nationality
                + ", notes=" + notes + ", bio=" + bio + ", country=" + country
                + ", city=" + city + ", picture=" + picture + ", signUpDate="
                + signUpDate + ", lastLoginDate=" + lastLoginDate + ", active="
                + active + ", isPrivate=" + isPrivate + "]";
    }

}

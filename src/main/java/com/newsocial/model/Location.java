package com.newsocial.model;

public class Location {

    private String  id;
    private String  location;
    private Long    longitude;
    private Long    latitude;

    private String  address;
    private String  postalCode;
    private String  city;
    private String  province;
    private String  country;
    private String  custom;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Long getLongitude() {
        return longitude;
    }
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
    public Long getLatitude() {
        return latitude;
    }
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCustom() {
        return custom;
    }
    public void setCustom(String custom) {
        this.custom = custom;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", location=" + location + ", longitude="
                + longitude + ", latitude=" + latitude + ", address=" + address
                + ", postalCode=" + postalCode + ", city=" + city
                + ", province=" + province + ", country=" + country
                + ", custom=" + custom + "]";
    }

}

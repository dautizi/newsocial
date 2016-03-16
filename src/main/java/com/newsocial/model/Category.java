package com.newsocial.model;

public class Category {

    private String  id;
    private String  name;
    private String  label;
    private Boolean active;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", label=" + label
                + ", active=" + active + "]";
    }

}

package com.newsocial.model;

public class Video {

    private String  id;
    private String  label;
    private Integer creationDate;
    private Boolean original;
    private Boolean active;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Integer getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }
    public Boolean getOriginal() {
        return original;
    }
    public void setOriginal(Boolean original) {
        this.original = original;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Video [id=" + id + ", label=" + label + ", creationDate="
                + creationDate + ", original=" + original + ", active="
                + active + "]";
    }

}

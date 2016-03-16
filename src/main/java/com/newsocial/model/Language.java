package com.newsocial.model;

public class Language {

    private String  id;
    private String  name;
    private String  label;
    private String  flagUrl;
    private String  encoding;
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
    public String getFlagUrl() {
        return flagUrl;
    }
    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
    public String getEncoding() {
        return encoding;
    }
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Language [id=" + id + ", name=" + name + ", label=" + label
                + ", flagUrl=" + flagUrl + ", encoding=" + encoding
                + ", active=" + active + "]";
    }

}

package com.newsocial.model;

public class Like {

    private String  id;
    private String  contentId;
    private String  userId;
    private String  username;
    private String  contentOwner;
    private Integer date;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContentId() {
        return contentId;
    }
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getContentOwner() {
        return contentOwner;
    }
    public void setContentOwner(String contentOwner) {
        this.contentOwner = contentOwner;
    }
    public Integer getDate() {
        return date;
    }
    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Like [id=" + id + ", contentId=" + contentId + ", userId="
                + userId + ", username=" + username + ", contentOwner="
                + contentOwner + ", date=" + date + "]";
    }

}

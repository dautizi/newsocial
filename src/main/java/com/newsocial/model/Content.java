package com.newsocial.model;

import java.util.Arrays;

public class Content {

    private String      id;
    private String      ownerUsername;
    private String      ownerId;
    private Location    location;

    private String      language;
    private Language    languageId;
    private String      title;
    private String      object;
    private String      subject;
    private String      body;
    private String      author;

    private Category    category;
    private Picture     picture;
    private Video       video;
    private Tag[]       tags;
    private Like[]      likes;

    private Integer creationDate;
    private Integer updateDate;
    private Boolean active;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOwnerUsername() {
        return ownerUsername;
    }
    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Language getLanguageId() {
        return languageId;
    }
    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Picture getPicture() {
        return picture;
    }
    public void setPicture(Picture picture) {
        this.picture = picture;
    }
    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }
    public Tag[] getTags() {
        return tags;
    }
    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
    public Like[] getLikes() {
        return likes;
    }
    public void setLikes(Like[] likes) {
        this.likes = likes;
    }
    public Integer getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }
    public Integer getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Content [id=" + id + ", ownerUsername=" + ownerUsername
                + ", ownerId=" + ownerId + ", location=" + location
                + ", language=" + language + ", languageId=" + languageId
                + ", title=" + title + ", object=" + object + ", subject="
                + subject + ", body=" + body + ", author=" + author
                + ", category=" + category + ", picture=" + picture
                + ", video=" + video + ", tags=" + Arrays.toString(tags)
                + ", likes=" + Arrays.toString(likes) + ", creationDate="
                + creationDate + ", updateDate=" + updateDate + ", active="
                + active + "]";
    }

}

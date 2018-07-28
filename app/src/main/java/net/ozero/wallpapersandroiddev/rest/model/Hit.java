package net.ozero.wallpapersandroiddev.rest.model;

import com.google.gson.annotations.SerializedName;

public class Hit {

    @SerializedName("id")
    private long id;

    @SerializedName("pageURL")
    private String pageUrl;

    @SerializedName("tags")
    private String tags;

    @SerializedName("previewURL")
    private String previewURL;

    @SerializedName("previewWidth")
    private int previewWidth;

    @SerializedName("previewHeight")
    private int previewHeight;

    @SerializedName("webformatURL")
    private String webformatURL;

    @SerializedName("webformatWidth")
    private int webformatWidth;

    @SerializedName("webformatHeight")
    private int webformatHeight;

    @SerializedName("largeImageURL")
    private String largeImageURL;

    @SerializedName("fullHDURL")
    private String fullHDURL;

    @SerializedName("imageURL")
    private String imageURL;

    @SerializedName("imageWidth")
    private int imageWidth;

    @SerializedName("imageHeight")
    private int imageHeight;

    @SerializedName("imageSize")
    private long imageSize;

    @SerializedName("views")
    private long views;

    @SerializedName("downloads")
    private long downloads;

    @SerializedName("favorites")
    private long favorites;

    @SerializedName("likes")
    private long likes;

    @SerializedName("comments")
    private long comments;

    @SerializedName("user_id")
    private long user_id;

    @SerializedName("user")
    private String user;

    @SerializedName("userImageURL")
    private String userImageURL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(int webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public int getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(int webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getFullHDURL() {
        return fullHDURL;
    }

    public void setFullHDURL(String fullHDURL) {
        this.fullHDURL = fullHDURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public long getImageSize() {
        return imageSize;
    }

    public void setImageSize(long imageSize) {
        this.imageSize = imageSize;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getDownloads() {
        return downloads;
    }

    public void setDownloads(long downloads) {
        this.downloads = downloads;
    }

    public long getFavorites() {
        return favorites;
    }

    public void setFavorites(long favorites) {
        this.favorites = favorites;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getComments() {
        return comments;
    }

    public void setComments(long comments) {
        this.comments = comments;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}

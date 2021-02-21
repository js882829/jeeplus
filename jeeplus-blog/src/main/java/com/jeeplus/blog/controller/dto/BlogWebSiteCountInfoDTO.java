package com.jeeplus.blog.controller.dto;

/**
 * 博客网站统计信息
 * @author:yuzp17311
 * @version:v1.0
 * @date: 2017-02-23 19:32.
 */
public class BlogWebSiteCountInfoDTO {

    private String userName;
    private String createDateTime;
    private String lastLoginDateTime;
    private Integer articleTotal;
    private Integer categoryTotal;
    private Integer lableTotal;
    private Integer commentTotal;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(String lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public Integer getArticleTotal() {
        return articleTotal;
    }

    public void setArticleTotal(Integer articleTotal) {
        this.articleTotal = articleTotal;
    }

    public Integer getCategoryTotal() {
        return categoryTotal;
    }

    public void setCategoryTotal(Integer categoryTotal) {
        this.categoryTotal = categoryTotal;
    }

    public Integer getLableTotal() {
        return lableTotal;
    }

    public void setLableTotal(Integer lableTotal) {
        this.lableTotal = lableTotal;
    }

    public Integer getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    @Override
    public String toString() {
        return "BlogWebSiteCountInfoDTO{" +
                "userName='" + userName + '\'' +
                ", createDateTime='" + createDateTime + '\'' +
                ", lastLoginDateTime='" + lastLoginDateTime + '\'' +
                ", articleTotal=" + articleTotal +
                ", categoryTotal=" + categoryTotal +
                ", lableTotal=" + lableTotal +
                ", commentTotal=" + commentTotal +
                '}';
    }
}

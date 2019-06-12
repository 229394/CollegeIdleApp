package com.leaf.collegeidleapp.bean;

/**
 * 评论实体类
 * @author autumn_leaf
 */
public class Review {

    private String stuId;//用户账号
    private String currentTime;//当前时间
    private String content;//评论内容
    private Integer position;//商品项编号

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}



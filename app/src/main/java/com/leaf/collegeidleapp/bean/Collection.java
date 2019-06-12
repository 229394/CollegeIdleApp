package com.leaf.collegeidleapp.bean;


/**
 * 我的收藏实体类
 * @author autumn_leaf
 */
public class Collection {

    //学生学号
    private String StuId;
    //商品图片
    private byte[] picture;
    //商品标题
    private String title;
    //商品描述
    private String description;
    //商品价格
    private float price;
    //联系方式
    private String phone;

    public String getStuId() {
        return StuId;
    }

    public void setStuId(String stuId) {
        StuId = stuId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

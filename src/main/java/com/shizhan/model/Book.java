package com.shizhan.model;

public class Book {
    private Integer bid;
    private String title;
    private String desc;
    private double price;

    private Integer status;

    public Book() {
    }

    public Book(Integer bid, String title, String desc, double price) {
        this.bid = bid;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    /**
     * 获取
     * @return bid
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置
     * @param bid
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "Book{bid = " + bid + ", title = " + title + ", desc = " + desc + ", price = " + price + "}";
    }
}

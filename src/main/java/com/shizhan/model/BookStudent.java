package com.shizhan.model;

import java.time.LocalDateTime;
import java.util.Date;

public class BookStudent {

    private Integer id;


    //    private Integer bid;
    private String title;
    //private Date Time;
    private LocalDateTime time;
    private String name;
    private Integer sid;


    public BookStudent() {
    }

    public BookStudent(Integer id, String title, LocalDateTime Time, String name, Integer sid) {
        this.id = id;
        this.title = title;
        this.time = Time;
        this.name = name;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取
     * @return bid
     */
    /*public Integer getBid() {
        return bid;
    }

    *//**
     * 设置
     * @param bid
     *//*
    public void setBid(Integer bid) {
        this.bid = bid;
    }*/

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return sid
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * 设置
     * @param sid
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

}

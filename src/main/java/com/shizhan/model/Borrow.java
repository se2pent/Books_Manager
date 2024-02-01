package com.shizhan.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Borrow  {



    private Integer Book_id;
    private Integer Student_id;
    private Timestamp Time;

    public Borrow() {
    }

    public Borrow(Integer Book_id, Integer Student_id, Timestamp Time) {
        this.Book_id = Book_id;
        this.Student_id = Student_id;
        this.Time = Time;
    }

    /**
     * 获取
     * @return Book_id
     */
    public Integer getBook_id() {
        return Book_id;
    }

    /**
     * 设置
     * @param Book_id
     */
    public void setBook_id(Integer Book_id) {
        this.Book_id = Book_id;
    }

    /**
     * 获取
     * @return Student_id
     */
    public Integer getStudent_id() {
        return Student_id;
    }

    /**
     * 设置
     * @param Student_id
     */
    public void setStudent_id(Integer Student_id) {
        this.Student_id = Student_id;
    }

    /**
     * 获取
     * @return Time
     */
    public Timestamp getTime() {
        return Time;
    }

    /**
     * 设置
     * @param Time
     */
    public void setTime(Timestamp Time) {
        this.Time = Time;
    }

    public String getBook_name(){
        return null;
    }



    public String toString() {
        return "Borrow{Book_id = " + Book_id + ", Student_id = " + Student_id + ", Time = " + Time + "}";
    }
}

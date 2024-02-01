package com.shizhan.model;

public class Student {
    private Integer sid;
    private String name;
    private String sex;
    private String grade;


    public Student() {
    }

    public Student(Integer sid, String name, String sex, String grade) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
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

    /**
     * 获取
     * @return name
     */
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
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Student{sid = " + sid + ", name = " + name + ", sex = " + sex + ", grade = " + grade + "}";
    }
}

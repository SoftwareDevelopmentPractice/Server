package com.fhlxc.backend;

/**
* @author Heping Zhang
* @date 2019/15/15 22:15:27
* @ClassName Student.java
* @Description 类描述
*/

public class Student {
    private String st_id;
    private String st_mail;
    public Student(String st_mail) {
        super();
        this.setSt_mail(st_mail);
    }
    public Student(String st_id, String st_mail) {
        super();
        this.setSt_id(st_id);
        this.setSt_mail(st_mail);
    }
    public Student() {
        // TODO Auto-generated constructor stub
    }
    public String getSt_id() {
        return st_id;
    }
    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }
    public String getSt_mail() {
        return st_mail;
    }
    public void setSt_mail(String st_mail) {
        this.st_mail = st_mail;
    }

    
}

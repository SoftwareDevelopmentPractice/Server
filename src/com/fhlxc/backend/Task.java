package com.fhlxc.backend;

import java.sql.Date;

/**
* @author Heping Zhang
* @date 2019/12/15 18:12:37
* @ClassName Task.java
* @Description 类描述
*/

public class Task {
    private String st_id;
    private String pa_id;
    private String t_title;
    private String t_content;
    private String t_time;
    private int st_config;
    private int pa_config;
    private int t_issend;
    
    public Task(String st_id, String pa_id, String t_title, String t_content, String t_time,int st_config,int pa_config) {
        super();
        this.setSt_id(st_id);
        this.setPa_id(pa_id);
        this.setT_title(t_title);
        this.setT_content(t_content);
        this.setT_time(t_time);
        this.setSt_config(st_config);
        this.setPa_config(pa_config);
    }
    public Task() {
    }
    public int getT_issend() {
        return t_issend;
    }
    public void setT_issend(int t_issend) {
        this.t_issend = t_issend;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getPa_id() {
        return pa_id;
    }

    public void setPa_id(String pa_id) {
        this.pa_id = pa_id;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public int getSt_config() {
        return st_config;
    }

    public void setSt_config(int st_config) {
        this.st_config = st_config;
    }

    public int getPa_config() {
        return pa_config;
    }

    public void setPa_config(int pa_config) {
        this.pa_config = pa_config;
    }
    
}

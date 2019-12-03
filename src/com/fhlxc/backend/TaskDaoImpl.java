package com.fhlxc.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.fhlxc.backend.DB;
import com.fhlxc.backend.Task;
import com.fhlxc.backend.Student;

public class TaskDaoImpl implements ITaskDao{
    private DB db;
    public TaskDaoImpl() {
        this.db = new DB();
    }
    @Override
    public ArrayList<Task> getMail(){
        System.out.println("getMailList");
        String sql = "select st_id,pa_id,t_title,t_content,t_time,st_config,pa_config from task where t_issend=0 and st_config = 1 or pt_config=1";
        ResultSet rSet = db.query(sql);
        ArrayList<Task> mailList = new ArrayList<>();
        try {
            while(rSet.next()){
                Task mail = new Task(rSet.getString(1), rSet.getString(2),rSet.getString(3),rSet.getString(4),
                                rSet.getString(5),rSet.getInt(6),rSet.getInt(7));
                mailList.add(mail);
            }
            return mailList;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean updateStatus(Task mail) {
        String sql = "update task set t_issend = 1 where st_id='"+mail.getSt_id()+"' and pa_id ='"+mail.getPa_id()+"' ";
        if (db.update(sql) == 1) {
            return true;
        }
        return false;
    }
    @Override
    public String getMailAddr(Student student){
        System.out.println("getMailList");
        String sql = "select st_mail where st_id = '"+student.getSt_id() +"'";
        ResultSet rSet = db.query(sql);
        try {
            while(rSet.next()){
              return rSet.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

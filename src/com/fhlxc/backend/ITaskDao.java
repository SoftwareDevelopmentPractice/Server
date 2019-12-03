package com.fhlxc.backend;

import java.util.ArrayList;

import com.fhlxc.backend.Task;

public interface ITaskDao {
    public ArrayList<Task> getMail();
    public boolean updateStatus(Task mail);
    public String getMailAddr(Student student);
}

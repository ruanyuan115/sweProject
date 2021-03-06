package com.example.sweproject.dao;

import com.example.sweproject.bean.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface TaskDao
{
    int addNewTask(@Param("taskInfo")Task task);

    ArrayList<Task> getAcceptedTasksByID(@Param("releaserID")int releaserID);//获取某人发布的已接受的任务
    ArrayList<Task> getUnAcceptedTasksByID(@Param("releaserID")int releaserID);//获取某人发布的未接受的任务
    ArrayList<Task> getAllTasks(@Param("userID")int userID);//某人查看任务广场获取任务列表
    ArrayList<Task> getTasksByAccepterID(@Param("accepterID")int accepterID);//某人查看自己接受的任务（包括未完成的和已完成的）
    Task getTaskInfoByID(@Param("taskID")int taskID);

    int acceptTask(@Param("accepterID")int accepterID,@Param("taskID")int taskID);//某人接受了某个任务

    int updateTaskState(@Param("taskID")int taskID,@Param("state")String state);//更新某个任务为某个状态

}

package com.kaishengit.mapper;

import com.kaishengit.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    void saveTask(Task task);

    List<Task> findByUserIdAndDateRanger( @Param("userid") Integer userid, @Param("start") String start, @Param("end") String end);

    void del(Integer id);

    Task findById(Integer id);

    void update(Task task);

    List<Task> findByTime(@Param("userid") Integer currentUserID, @Param("today") String today);
}

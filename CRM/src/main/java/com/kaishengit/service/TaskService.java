package com.kaishengit.service;


import com.kaishengit.mapper.TaskMapper;
import com.kaishengit.pojo.Task;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TaskService {

    @Inject
    private TaskMapper taskMapper;


    public void saveTask(Task task, String hour, String min) {

        if (StringUtils.isNotEmpty(hour) && StringUtils.isNotEmpty(min)) {
            String remindTime = task.getStart() + "" + hour + ":" + min + "00";
            //TODO quartz动态任务
            task.setRemindtime(remindTime);
        }
        int str = ShiroUtil.getCurrentUserID();
        task.setUserid(ShiroUtil.getCurrentUserID());

        taskMapper.saveTask(task);
    }

    public List<Task> findTaskByUserId(String start, String end) {
        return taskMapper.findByUserIdAndDateRanger(ShiroUtil.getCurrentUserID(), start, end);
    }

    public void delTaskById(Integer id) {
        taskMapper.del(id);
    }

    public void update(Integer id) {
        Task task = taskMapper.findById(id);
        task.setDone(true);
        task.setColor("#cccccc");
        task.setUserid(ShiroUtil.getCurrentUserID());
        taskMapper.update(task);
    }

    public List<Task> findTaskByTime() {
        String today = DateTime.now().toString("yyyy-MM-dd");
        List<Task> taskList = taskMapper.findByTime(ShiroUtil.getCurrentUserID(), today);
        return taskList;
    }

    public Task findById(Integer id) {

     return  taskMapper.findById(id);
    }
}

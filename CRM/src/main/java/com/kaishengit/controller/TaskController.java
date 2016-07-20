package com.kaishengit.controller;

import com.kaishengit.dto.JsonResult;
import com.kaishengit.pojo.Task;
import com.kaishengit.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value="/task")
public class TaskController {

    @Inject
    private TaskService taskService;

    @RequestMapping(method  = RequestMethod.GET)
    public String list(Model model){

        List<Task> taskList = taskService.findTaskByTime();
        model.addAttribute("taskList",taskList);
        return "/task/list";
    }

    /**
     * 根据id查找事项
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public List<Task> load(String start, String end) {
        return taskService.findTaskByUserId(start,end);
    }

    /**
     * 保存事项
     * @param task
     * @param hour
     * @param min
     * @return
     */
    @RequestMapping(value="/new",method = RequestMethod.POST)
    @ResponseBody
    public  JsonResult save(Task task , String hour , String min){
        taskService.saveTask(task,hour,min);
        return new JsonResult(task);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String del(@PathVariable Integer id){

        taskService.delTaskById(id);
        return "success";
    }

    /**
     * 根据id该done
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}/done",method = RequestMethod.POST)
    @ResponseBody
    public String update(@PathVariable Integer id){
            taskService.update(id);
        return "success";

    }

    /**
     * 修改过期事项
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}/mark",method = RequestMethod.GET)
    @ResponseBody
    public String  mark(@PathVariable Integer id){
        taskService.update(id);
       Task task =  taskService.findById(id);
        return "success";
    }
}

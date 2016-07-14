package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTableResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Notice;
import com.kaishengit.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {


    @Inject
    private NoticeService noticeService;


    @RequestMapping(method = RequestMethod.GET)
    public String notice() {

        return "/notice/noticeList";
    }

    /**
     * 发表公告
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newNotice() {
        return "notice/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newNotice(Notice notice, RedirectAttributes redirectAttributes) {

        noticeService.saveNotice(notice);
        redirectAttributes.addFlashAttribute("message", "发表成功");

        return "redirect:/notice";
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody
    public DataTableResult noticeList(HttpServletRequest request) {

        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String draw = request.getParameter("draw");

        Map<String,Object> param = Maps.newHashMap();

        param.put("start",start);
        param.put("length",length);

        List<Notice> noticeList = noticeService.findNoticeByParam(param);
        Long count = noticeService.count();
        return new DataTableResult(draw,count,count,noticeList);
    }

    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String findContent(@PathVariable Integer id ,Model model){

        Notice notice = noticeService.findNoticeById(id);
        if(notice == null){
            throw new NotFoundException();
        }else{
            model.addAttribute("notice",notice);
            return "notice/view";
        }



    }


}

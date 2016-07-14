package com.kaishengit.service;

import com.kaishengit.mapper.NoticeMapper;
import com.kaishengit.pojo.Notice;
import com.kaishengit.util.ShiroUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class NoticeService {

    @Inject
    private NoticeMapper noticeMapper;

    public void saveNotice(Notice notice) {
        notice.setUserid(ShiroUtil.getCurrentUserID());
        notice.setRealname(ShiroUtil.getCurrentUserRealname());
        noticeMapper.saveNotice(notice);
    }

    public List<Notice> findNoticeByParam(Map<String, Object> param) {


      List<Notice>  noticeList= noticeMapper.findByParam(param);

            return noticeList;

    }


    public Long count() {
        return noticeMapper.count();
    }


    public Notice findNoticeById(Integer id) {
            return noticeMapper.findNoticeById(id);
    }
}

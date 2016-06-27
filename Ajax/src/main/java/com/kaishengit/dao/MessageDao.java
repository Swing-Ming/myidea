package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.cache.EhcacheUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


public class MessageDao {

    Logger logger = LoggerFactory.getLogger(MessageDao.class);

    public Message findById(Integer id) {
        Message message = (Message) EhcacheUtil.get("message:"+id);
        if(message == null){
            String sql = "select * from admin where id = ?";

           message = DbHelp.query(sql, new BeanHandler<>(Message.class), id);
            EhcacheUtil.set("message:"+id,message);
        }else{
            logger.debug("有缓存");
        }
        return  message;
    }

    public List<Message> findAll() {
        List<Message> messageList = (List<Message>) EhcacheUtil.get("messageList");
        if(messageList == null){
            String sql = "select * from admin order by id desc"; // 10
            messageList = DbHelp.query(sql, new BeanListHandler<>(Message.class));
            EhcacheUtil.set("messageList",messageList);
        }
        return  messageList;

    }

    public void save(Message message) {
        String sql = "insert into admin(name,password) values(?,?)";
       DbHelp.update(sql,message.getName(),message.getPassword());
    }





    public List<Message> findGtMaxId(String maxId) {
        String sql = "select * from admin where id > ? order by id desc";
        return DbHelp.query(sql,new BeanListHandler<>(Message.class),maxId);
    }
}

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MesageDaoTestCase {

    private MessageDao messageDao = new MessageDao();
    @Test
    public void testById(){
        Message message = messageDao.findById(5);
        System.out.println(message.getName());
        System.out.println(1);
         message = messageDao.findById(5);
        System.out.println(message.getName());
        System.out.println(2);
         message = messageDao.findById(5);
        System.out.println(message.getName());
        System.out.println(3);
         message = messageDao.findById(5);
        System.out.println(message.getName());
        System.out.println(4);
        Assert.assertNotNull(message);


    }
    @Test
    public  void testFindAll(){
        MessageDao messageDao = new MessageDao();
        List<Message> messageList = messageDao.findAll();
        Message  message = new Message();
        message.setName("lili");
        message.setPassword("sc");
        messageDao.save(message);
        messageList = messageDao.findAll();
        messageList = messageDao.findAll();
       Assert.assertEquals(9,messageList.size());
    }
}

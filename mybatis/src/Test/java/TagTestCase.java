import com.kaishengit.mapper.TagMapper;
import com.kaishengit.pojo.T_User;
import com.kaishengit.pojo.Tag;
import com.kaishengit.util.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TagTestCase {

    Logger logger = LoggerFactory.getLogger(StudentTestCase.class);

    @Test
    public void tagfindByIdTest() {
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        TagMapper tagMapper = sqlSession.getMapper(TagMapper.class);
        T_User t_user = tagMapper.findById(10);
        logger.debug("{}", t_user);
        List<Tag> tagList = t_user.getTagList();
        for (Tag tag : tagList) {
            logger.debug("Tag:{}",tag);


        }


    }
}

import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class StudentTestCase {

    Logger logger = LoggerFactory.getLogger(StudentTestCase.class);
    @Test
    public void findByIdTest(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        logger.debug("{}",studentMapper.findById(1));
        sqlSession.close();
    }



}

package com.kaishengit.adminDao;

import com.kaishengit.pojo.Login;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LoginImpl implements LoginDao {


    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Login login) {

        String sql="insert into login (ip,userid) value (?,?)";
        jdbcTemplate.update(sql,login.getIp(),login.getUsrid());
    }
}

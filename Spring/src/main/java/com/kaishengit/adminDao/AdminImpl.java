package com.kaishengit.adminDao;

import com.kaishengit.pojo.Admin;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Named
public class AdminImpl implements AdminDao {

    @Inject
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(Admin admin) {
        String sql="insert into Admin(name,pwd) value (?,?)";
        jdbcTemplate.update(sql,admin.getName(),admin.getPwd());

    }

    @Override
    public void del(Integer id) {

    }

    @Override
    public void update(AdminDao admin) {

    }

    @Override
    public Admin findById(Integer id) {
        String sql = "select * from Admin where id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                Admin admin  = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setPwd(rs.getString("pwd"));
                admin.setName(rs.getString("name"));

                return admin;
            }
        });
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findByName(String name) {
        String sql = "select * from Admin where name = ?";

        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Admin.class),name);
    }

    @Override
    public Long count() {
        return null;
    }
}

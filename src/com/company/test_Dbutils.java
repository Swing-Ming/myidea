package com.company;


import org.apache.commons.dbutils.QueryRunner;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test_Dbutils {

   @Test
    public void test(){
       QueryRunner queryRunner = new QueryRunner();
       String sql = "insert into admin(name,password) values (?,?)";
       try {
           queryRunner.update(Dbutil_Connection.getconnection(),sql,"jim","111");
           Assert.assertNotNull(Dbutil_Connection.getconnection());
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

}


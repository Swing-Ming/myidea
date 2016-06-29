package com.kaishengit.mapper;

import com.kaishengit.pojo.T_User;
import com.kaishengit.pojo.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;
@CacheNamespace
public interface TagMapper {

   @Select("select * from t_user where id = #{id}")
   @Results({
           @Result(column="username"  , property = "username"   ),
           @Result(column="password"  , property = "password"   ),
           @Result(column="email"     , property = "email"      ),
           @Result(column="avatar"    , property = "avatar"     ),
           @Result(column="createtime", property = "createtime" ),
           @Result(column="loginip"   , property = "loginip"    ),
           @Result(column="logintime" , property = "logintime"  ),
           @Result(column="state"     , property = "state"      ),
           @Result(property = "tagList" , javaType = List.class,column = "id" ,many = @Many(
                   select = "com.kaishengit.mapper.TagMapper.findById"
           ))




   })

   T_User findById(Integer id);
}

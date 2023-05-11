package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    //簡略化のためにアノテーションを利用しているが、実際はXMLを用いてSQLを実装すること
    @Select("SELECT * FROM users")
    List<User> getUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(Long id);

    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createUser(User user);

    @Update("UPDATE users SET name = #{name}, email = #{email} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(Long id);
}
package com.example.demoproject.dao;


import com.example.demoproject.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    private final static String sqlRead = "SELECT * FROM demo_spring_project.user;";
    private final static String sqlCreate = "";

    JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User create(User user) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sqlCreate, new String[]{"ID"});
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            return preparedStatement;
            }, keyHolder);
        return new User(keyHolder.getKey().intValue(), user.getName(), user.getAge());
    }

    @Override
    public User read(int id) {
        return jdbcTemplate.queryForObject(sqlRead, UserDaoImpl::mapRow, id);
    }
    //щоб мепити отримані записи в жаба об'єкти
    private static User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt(1), rs.getString(2) ,rs.getInt(3));
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

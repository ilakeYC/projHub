package com.hub.dao.mapper;

import com.hub.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ilakeyc
 * @since 2017/4/1
 */
public class PersonRowMapper implements RowMapper<Person> {
    private static PersonRowMapper instance;

    public static PersonRowMapper getInstance() {
        if (instance == null) {
            instance = new PersonRowMapper();
        }
        return instance;
    }

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

        Person entity = new Person();

        entity.setId(rs.getLong("id"));
        entity.setName(rs.getString("name"));
        entity.setAge(rs.getInt("age"));
        entity.setGender(rs.getInt("gender"));
        entity.setFriends(rs.getString("friends"));

        return entity;
    }
}

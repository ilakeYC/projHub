package com.hub.dao.mapper;

import com.hub.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ilakeyc
 * @since 2018/8/11 下午5:10
 */
public class StudentRowMapper implements RowMapper<Student> {
  private static StudentRowMapper instance;

  public static StudentRowMapper getInstance() {
    if (instance == null) {
      instance = new StudentRowMapper();
    }
    return instance;
  }

  @Override
  public Student mapRow(ResultSet rs, int i) throws SQLException {
    Student entity = new Student();

    entity.setId(rs.getLong("id"));
    entity.setName(rs.getString("name"));
    entity.setAge(rs.getInt("age"));
    entity.setGender(rs.getInt("gender"));
    entity.setStatus(rs.getInt("status"));
    entity.setCreateTime(rs.getLong("createTime"));
    entity.setUpdateTime(rs.getLong("updateTime"));

    return entity;
  }
}

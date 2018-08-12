package com.hub.dao;

import com.hub.dao.mapper.StudentRowMapper;
import com.hub.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ilakeyc
 * @since 2018/8/11 下午6:33
 */
@Component
public class StudentDao {

  @Resource
  private JdbcTemplate jdbcTemplate;


  public List<Student> getStudents() {
    return jdbcTemplate.query("SELECT * FROM student WHERE status = 1", StudentRowMapper.getInstance());
  }

  public Student getStudent(long id) {
    return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?",
        new Object[]{id},
        StudentRowMapper.getInstance());
  }

  public boolean create(String name, int age, int gender) {
    int update = jdbcTemplate.update("INSERT INTO student (name, age, gender, status, createTime) VALUES (?, ?, ?, ?, ?)",
        name, age, gender, 1, System.currentTimeMillis());
    return update > 0;
  }

  public boolean update(long id, int age) {
    int update = jdbcTemplate.update("UPDATE student SET age = ? WHERE id = ?", age, id);
    return update > 0;
  }

  public boolean delete(long id) {
    int update = jdbcTemplate.update("UPDATE student SET status = ? WHERE id = ?", -1, id);
    return update > 0;
  }

}

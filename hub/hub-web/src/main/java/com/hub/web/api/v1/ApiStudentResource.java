package com.hub.web.api.v1;

import com.hub.dao.StudentDao;
import com.hub.model.Student;
import com.hub.util.ResponseBuilder;
import com.hub.web.BaseResource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

/**
 * 用户界面 api
 * CRUD :
 * - create
 * - read
 * - update
 * - delete
 *
 * @author ilakeyc
 * @since 2018/8/11 下午4:46
 */
@Path("/api/v1/student")
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ApiStudentResource extends BaseResource {

  @Resource
  private StudentDao studentDao;

  /**
   * 查询所有学生信息
   */
  @GET
  @Produces(APPLICATION_JSON)
  public Map<String, Object> getStudents() {
    List<Student> students = studentDao.getStudents();
    return ResponseBuilder.ok(students);
  }

  /**
   * R
   * 获取学生简单信息
   */
  @GET
  @Path("{id}")
  @Produces(APPLICATION_JSON)
  public Map<String, Object> getStudent(@PathParam("id") long id) {

    Student student = studentDao.getStudent(id);

    return ResponseBuilder.ok(student);
  }


  /**
   * C
   * 新建一个学生信息
   *
   * @return
   */
  @GET
  @Path("create")
  @Produces(APPLICATION_JSON)
  public Map<String, Object> createStudent(@QueryParam("name") String name,
                                           @QueryParam("age") int age,
                                           @QueryParam("gender") int gender) {

    boolean b = studentDao.create(name, age, gender);

    if (b) {
      return ResponseBuilder.OK;
    } else {
      return ResponseBuilder.error(10500, "学生信息增加失败");
    }
  }


  /**
   * U
   * 更新学生信息
   *
   * @param id  被更新的学生id
   * @param age 新的学生年龄
   */
  @GET
  @Path("update")
  @Produces(APPLICATION_JSON)
  public Map<String, Object> updateStudent(@QueryParam("id") long id,
                                           @QueryParam("age") int age) {

    boolean update = studentDao.update(id, age);
    if (update) {
      return ResponseBuilder.OK;
    } else {
      return ResponseBuilder.error(10500, "学生信息更新失败");
    }
  }


  /**
   * D
   * 删除，让 status 变成 -1
   *
   * @param id
   * @return
   */
  @GET
  @Path("delete")
  @Produces(APPLICATION_JSON)
  public Map<String, Object> deleteStudent(@QueryParam("id") long id) {
    boolean delete = studentDao.delete(id);
    if (delete) {
      return ResponseBuilder.OK;
    } else {
      return ResponseBuilder.error(10000, "ERROR");
    }
  }


}

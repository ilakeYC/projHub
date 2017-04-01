package com.hub.web.api.v1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hub.dao.mapper.PersonRowMapper;
import com.hub.model.Entity;
import com.hub.model.Person;
import com.hub.util.ResponseBuilder;
import com.hub.web.BaseResource;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ilakeyc
 * @since 2017/4/1
 */

@Path("api/v1/person")
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ApiPersonResource extends BaseResource {
    private static Log LOG = LogFactory.getLog(ApiPersonResource.class);

    @GET
    @Produces(APPLICATION_JSON)
    public Map<String, Object> getAll() {
        try {
            List<Person> personList = entityDao.find("person", "status", "0", PersonRowMapper.getInstance(), 1, 100);
            for (Person person : personList) {
                person.setFriends(null);
            }
            return ResponseBuilder.ok(personList);
        } catch (Throwable t) {
            return ResponseBuilder.error(50000, t.getMessage());
        }
    }

    @GET
    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public Map<String, Object> get(@PathParam("id") long id) {

        if (id <= 0) {
            return ResponseBuilder.error(10001, "人物id不合法。");
        }

        try {
            Person person = entityDao.get("person", id, PersonRowMapper.getInstance());
            if (person == null) {
                return ResponseBuilder.error(10404, "没有找到该人物信息。");
            }
            setPersonProperties(person);
            person.setFriends(null);
            return ResponseBuilder.ok(person);
        } catch (Throwable t) {
            LOG.error("Get person failure", t);
            return ResponseBuilder.error(50000, t.getMessage());
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public Map<String, Object> create(
            @FormParam("name") String name,
            @FormParam("age") int age,
            @FormParam("gender") int gender,
            @FormParam("friends") List<String> friends) {
        if (gender < 0) {
            return ResponseBuilder.error(10002, "性别不合法");
        }
        if (age < 0) {
            return ResponseBuilder.error(10003, "年龄不合法");
        }
        if (StringUtils.isEmpty(name)) {
            return ResponseBuilder.error(10004, "请输入姓名");
        }
        if (StringUtils.length(name) > 50) {
            return ResponseBuilder.error(10004, "姓名不能超过50个字");
        }
        String friendsJson = null;
        if (!friends.isEmpty()) {
            Gson g = new Gson();
            try {
                friendsJson = g.toJson(friends);
            } catch (Throwable t) {
                LOG.error("Encoding Json Failure", t);
            }
        }

        Entity entity = new Entity("person")
                .set("name", name)
                .set("age", age)
                .set("gender", gender);
        if (StringUtils.isNotEmpty(friendsJson)) {
            entity.set("friends", friendsJson);
        }

        try {
            long id = entityDao.saveAndReturn(entity).getId();
            return ResponseBuilder.ok(id);
        } catch (Throwable t) {
            return ResponseBuilder.error(50000, t.getMessage());
        }
    }

    @POST
    @Path("{id}/update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public Map<String, Object> create(
            @PathParam("id") long id,
            @FormParam("name") String name,
            @FormParam("age") int age,
            @FormParam("gender") int gender,
            @FormParam("friends") List<String> friends) {
        if (gender < 0) {
            return ResponseBuilder.error(10002, "性别不合法");
        }
        if (age < 0) {
            return ResponseBuilder.error(10003, "年龄不合法");
        }
        if (StringUtils.isEmpty(name)) {
            return ResponseBuilder.error(10004, "请输入姓名");
        }
        if (StringUtils.length(name) > 50) {
            return ResponseBuilder.error(10004, "姓名不能超过50个字");
        }
        String friendsJson = null;
        if (!friends.isEmpty()) {
            Gson g = new Gson();
            try {
                friendsJson = g.toJson(friends);
            } catch (Throwable t) {
                LOG.error("Encoding Json Failure", t);
            }
        }
        Map<String, Object> updateValues = new HashMap<String, Object>();
        updateValues.put("name", name);
        updateValues.put("age", age);
        updateValues.put("gender", gender);
        if (StringUtils.isNotEmpty(friendsJson)) {
            updateValues.put("friends", friendsJson);
        }
        try {
            entityDao.update("person", "id", id, updateValues);
            return ResponseBuilder.OK;
        } catch (Throwable t) {
            return ResponseBuilder.error(50000, t.getMessage());
        }
    }

    private void setPersonProperties(Person person) {
        String friendsJson = person.getFriends();
        if (StringUtils.isNotEmpty(friendsJson)) {
            Gson g = new Gson();
            List<String> friendIds = null;
            try {
                friendIds = g.fromJson(friendsJson, new TypeToken<List<String>>() {
                }.getType());
            } catch (Throwable t) {
                LOG.error("Encoding friends id failure", t);
            }
            if (friendIds != null) {

                List<Person> friends = new ArrayList<Person>();

                for (String id : friendIds) {
                    try {
                        Person fr = entityDao.get("person", id, PersonRowMapper.getInstance());
                        if (fr != null) {
                            fr.setFriends(null);
                            friends.add(fr);
                        }
                    } catch (Throwable t) {
                        LOG.error("Get person failure with id: " + id);
                    }
                }

                if (!friends.isEmpty()) {
                    person.getProperties().put("friends", friends);
                }

            }
        }
    }
}













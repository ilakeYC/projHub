package com.hub.web.api.v1;

import com.hub.util.ResponseBuilder;
import com.hub.web.BaseResource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ilakeyc
 * @since 2017/3/30
 */
@Path("/api/v1")
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ApiResource extends BaseResource {

    @GET
    @Produces(APPLICATION_JSON)
    public Map<String, Object> index() {

        Map<String, Object> lixingnan = new HashMap<String, Object>();
        lixingnan.put("name", "李星楠");
        lixingnan.put("age", 18);
        lixingnan.put("gender", "男");

        List<String> friends = new ArrayList<String>();
        friends.add("张三");
        friends.add("李四");
        friends.add("王五");
        friends.add("赵六");
        lixingnan.put("friends", friends);

        return ResponseBuilder.ok(lixingnan);

    }


    @GET
    @Path("friends")
    @Produces(APPLICATION_JSON)
    public Map<String, Object> fiends(@QueryParam("name") String name) {

        Map<String, Object> people = new HashMap<String, Object>();
        people.put("name", name);

        List<String> friends = new ArrayList<String>();
        friends.add("张三");
        friends.add("李四");
        friends.add("王五");
        friends.add("赵六");
        people.put("friends", friends);

        return ResponseBuilder.ok(people);
    }

    @POST
    @Path("add")
    @Produces(APPLICATION_JSON)
    public Map<String, Object> add(@FormParam("name") String name,
                                   @FormParam("age") int age,
                                   @FormParam("gender") String gender,
                                   @FormParam("friends") List<String> friends) {
        Map<String, Object> people = new HashMap<String, Object>();
        people.put("name", name);
        people.put("age", age);
        people.put("gender", gender);
        people.put("friends", friends);
        return ResponseBuilder.ok(people);
    }
}

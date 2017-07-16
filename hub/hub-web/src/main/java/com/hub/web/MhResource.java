package com.hub.web;

import com.hub.model.Person;
import com.sun.jersey.api.view.Viewable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilakeyc
 * @since 2017/7/16
 */
@Path("mh")
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MhResource extends BaseResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response index() {

        Person p1 = new Person();
        p1.setName("马辉");
        p1.setAge(20);
        p1.setGender(1);

        Person p2 = new Person();
        p2.setName("理性南");
        p2.setAge(22);
        p2.setGender(2);

        Person p3 = new Person();
        p3.setName("郭众先");
        p3.setAge(21);
        p3.setGender(1);

        Person p4 = new Person();
        p4.setName("刘晒");
        p4.setAge(24);
        p4.setGender(1);

        Person p5 = new Person();
        p5.setName("夏一尘");
        p5.setAge(22);
        p5.setGender(1);

        List<String> p5_friends = new ArrayList<String>();
        p5_friends.add(p1.getName());
        p5_friends.add(p2.getName());
        p5_friends.add(p3.getName());
        p5_friends.add(p4.getName());
        p1.setFriends(p5_friends.toString());

        List<Person> personList = new ArrayList<Person>();

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        request.setAttribute("persons", personList);

        return Response.ok(new Viewable("index")).build();
    }

}

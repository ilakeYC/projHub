package com.hub.web;

import com.sun.jersey.api.view.Viewable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author ilakeyc
 * @since 2017/3/30
 */
@Path("lxn")
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LxnResource extends BaseResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response index() {
        return Response.ok(new Viewable("index")).build();
    }

}

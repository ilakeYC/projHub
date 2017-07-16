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
 * @since 2017/7/16
 */
@Path("mh")
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MhResource extends BaseResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response index() {
        return Response.ok(new Viewable("index")).build();
    }

}

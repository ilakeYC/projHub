package com.hub.web.api.v1;

import com.hub.web.BaseResource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
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
  public Map<String, Object> hello() {

    Map<String, Object> result = new HashMap<String, Object>();

    result.put("response", "hello world!");
    result.put("age", 18);

    return result;
  }


  @GET
  @Path("test")
  @Produces(APPLICATION_JSON)
  public Map<String, Object> test(@QueryParam("say") String say,
                                  @QueryParam("text") String string) {

    Map<String, Object> result = new HashMap<String, Object>();

    result.put("say", say);
    result.put("text", string);

    return result;
  }


}

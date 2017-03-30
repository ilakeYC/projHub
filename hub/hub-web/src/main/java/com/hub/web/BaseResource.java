package com.hub.web;

import com.hub.dao.EntityDao;
import com.hub.service.SessionService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URLEncoder;

/**
 * @author mixueqiang
 * @since Mar 7, 2014
 */
public abstract class BaseResource {
    private static final Log LOG = LogFactory.getLog(BaseResource.class);
    public final static String APPLICATION_JSON = "application/json; charset=utf-8";
    @Resource
    protected EntityDao entityDao;
    @Resource
    protected SessionService sessionService;
    @Context
    protected HttpServletRequest request;

    public Object getSessionAttribute(String name) {
        return WebUtils.getSessionAttribute(request, name);
    }

    public Response redirect(String to) {
        try {
            return Response.seeOther(new URI(to)).build();
        } catch (Throwable t) {
            return null;
        }
    }

    public void setSessionAttribute(String name, Object value) {
        WebUtils.setSessionAttribute(request, name, value);
    }

    public Response signinAndGoback() {
        return signinAndGoto(request.getRequestURI(), request.getQueryString());
    }

    public Response signinAndGoto(String to) {
        try {
            return Response.seeOther(new URI("/signin?to=" + URLEncoder.encode(to, "utf-8"))).build();
        } catch (Throwable t) {
            return null;
        }
    }

    public Response signinAndGoto(String requestUri, String queryString) {
        String to = requestUri;
        if (StringUtils.isNotEmpty(queryString)) {
            to += "?" + queryString;
        }

        return signinAndGoto(to);
    }

}

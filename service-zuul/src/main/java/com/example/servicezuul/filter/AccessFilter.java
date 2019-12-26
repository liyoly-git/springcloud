package com.example.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ly
 * @date 2019/12/26
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("{} >>> {}", request.getMethod(),request.getRequestURL().toString());

        String accessToken = request.getParameter("accessToken");
        if(StringUtils.isBlank(accessToken) || !"test".equals(accessToken)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is invalid");
            logger.info("the request {} is fail,the token is invalid", request.getRequestURL().toString());

        }else{
            logger.info("the request {} is ok",request.getRequestURL().toString());
        }
        return null;
    }
}

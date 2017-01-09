package com.hfut.zngl.filter;

/**
 * Created by 东东 on 2017/1/6.
 */
import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter{


public void destroy(){}


public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException   {
    request.setCharacterEncoding("utf-8");
    chain.doFilter(request, response);
}


public void init(FilterConfig arg0) throws ServletException{}


}

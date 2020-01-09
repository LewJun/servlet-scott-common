package com.example.lewjun.filters;

import com.example.lewjun.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/** @author huiye */
@WebFilter(urlPatterns = "/api/*")
public class GlobalFilter implements Filter {
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    LOGGER.info("=============doFilter============");
    WebUtils.setReq(servletRequest);
    WebUtils.setResp(servletResponse);

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    WebUtils.removeReq();
    WebUtils.removeResp();
  }
}

package com.example.lewjun.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 使用ThreadLocal存放ServletRequest和ServletResponse
 *
 * @author huiye
 */
public class WebUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(WebUtils.class);
  private static ThreadLocal<ServletResponse> responseThreadLocal = new ThreadLocal<>();
  private static ThreadLocal<ServletRequest> requestThreadLocal = new ThreadLocal<>();

  public static void removeResp() {
    responseThreadLocal.remove();
  }

  public static void removeReq() {
    requestThreadLocal.remove();
  }

  public static ServletRequest getReq() {
    ServletRequest request = requestThreadLocal.get();
    LOGGER.info("request {}", request);
    return request;
  }

  public static void setReq(ServletRequest req) {
    LOGGER.info("req {}", req);
    requestThreadLocal.set(req);
  }

  public static ServletResponse getResp() {
    ServletResponse resp = responseThreadLocal.get();
    LOGGER.info("resp {}", resp);
    return resp;
  }

  public static void setResp(ServletResponse resp) {
    LOGGER.info("resp {}", resp);
    responseThreadLocal.set(resp);
  }
}

package com.example.lewjun.exception;

import com.example.lewjun.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常处理类
 *
 * @author huiye
 */
@WebServlet("/exceptionHandler")
public class ExceptionHandler extends HttpServlet {
  private static final long serialVersionUID = -6332455216351291369L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error" + ".exception");
    if (throwable instanceof BuzException) {
      BuzException exception = (BuzException) throwable;
      ServletUtils.failure(exception.getEnumApiResultCode());
    } else {
      ServletUtils.failure();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }
}

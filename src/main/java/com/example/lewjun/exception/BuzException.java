package com.example.lewjun.exception;

import com.example.lewjun.base.EnumApiResultCode;

/**
 * 业务异常类
 *
 * @author huiye
 */
public class BuzException extends RuntimeException {
  private static final long serialVersionUID = 3487036605315304369L;

  private final EnumApiResultCode enumApiResultCode;

  public BuzException(EnumApiResultCode enumApiResultCode) {
    super(enumApiResultCode.toString());
    this.enumApiResultCode = enumApiResultCode;
  }

  EnumApiResultCode getEnumApiResultCode() {
    return enumApiResultCode;
  }
}

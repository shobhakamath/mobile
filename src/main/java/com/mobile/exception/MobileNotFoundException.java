package com.mobile.exception;

/**
 * This exception indicates that the entity is not found.
 *
 * @author shobha
 * @version 1.0
 */
public class MobileNotFoundException extends ApplicationBaseException {
  /**
   * The serial version UID
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor with message parameter.
   *
   * @param message the message
   */
  public MobileNotFoundException(String message) {
    super(message);
  }

  /**
   * Constructor with message and cause parameters.
   *
   * @param message the message
   * @param cause   the cause
   */
  public MobileNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}

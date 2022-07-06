package yym.svydovets.spring.exception;

public class NoSuchBeanException extends RuntimeException {

  public NoSuchBeanException() {
    super("No bean is present");
  }

  public NoSuchBeanException(String message) {
    super(message);
  }

  public NoSuchBeanException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoSuchBeanException(Throwable cause) {
    super(cause);
  }

  protected NoSuchBeanException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

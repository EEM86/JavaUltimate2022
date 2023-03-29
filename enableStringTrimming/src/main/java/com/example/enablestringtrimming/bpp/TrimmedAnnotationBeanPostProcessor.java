package com.example.enablestringtrimming.bpp;

import com.example.enablestringtrimming.annotation.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.Arrays;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (!bean.getClass().isAnnotationPresent(Trimmed.class) &&
        Arrays.stream(bean.getClass().getDeclaredMethods()).noneMatch(m -> m.isAnnotationPresent(Trimmed.class))) {
      return bean; // if no class or method annotations
    }
    MethodInterceptor methodInterceptor = (obj, method, args, proxy) -> {
      if (!bean.getClass().isAnnotationPresent(Trimmed.class) &&
          !method.isAnnotationPresent(Trimmed.class)) {
        return proxy.invokeSuper(obj, args); // skip methods that are not annotated
      }
      for (int i = 0; i < method.getParameters().length; i++) {
        var parameter = method.getParameters()[i];
        if (parameter.getType() == String.class) {
          args[i] = ((String) args[i]).trim();
        }
      }
      var result = proxy.invokeSuper(obj, args);
      if (method.getReturnType().isAssignableFrom(String.class)) {
        return ((String) result).trim();
      }
      return result;
    };
    var enhancer = new Enhancer();
    enhancer.setSuperclass(bean.getClass());
    enhancer.setCallback(methodInterceptor);
    return enhancer.create();
  }
}

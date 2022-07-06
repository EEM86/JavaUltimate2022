package yym.svydovets.spring.ioc;

import yym.svydovets.spring.exception.NoSuchBeanException;
import yym.svydovets.spring.exception.NoUniqueBeanException;

import java.util.Map;

public interface ApplicationContext {

  <T> T getBean(Class<T> beanType) throws NoSuchBeanException, NoUniqueBeanException;

  <T> T getBean(String name, Class<T> beanType) throws NoSuchBeanException;

  <T> Map<String, T> getAllBeans(Class<T> beanType);

}

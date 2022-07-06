package yym.svydovets.spring.ioc;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.springframework.util.CollectionUtils;
import yym.svydovets.spring.exception.NoSuchBeanException;
import yym.svydovets.spring.exception.NoUniqueBeanException;
import yym.svydovets.spring.ioc.annotation.Bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ApplicationContextImpl implements ApplicationContext {

  private Map<String, Object> context = new HashMap<>();

  public ApplicationContextImpl(String packageName)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    final Reflections reflections = new Reflections(packageName);
    final Set<Class<?>> beans = reflections.getTypesAnnotatedWith(Bean.class);
    if (CollectionUtils.isEmpty(beans)) {
      throw new NoSuchBeanException();
    }
    for (Class<?> bean : beans) {
      final Object instance = bean.getDeclaredConstructor().newInstance();
      final String annotatedName = bean.getAnnotation(Bean.class).name();
      final String className = bean.getSimpleName().substring(0, 1).toLowerCase() + bean.getSimpleName().substring(1);
      final String beanName = StringUtils.isEmpty(annotatedName) ? className : annotatedName;
      if (context.containsKey(beanName)) {
        throw new NoUniqueBeanException();
      }
      context.put(beanName, instance);
    }
  }

  @Override
  public <T> T getBean(Class<T> beanType) throws NoSuchBeanException, NoUniqueBeanException {
    final Object result = context.values().stream()
        .filter(bean -> bean.getClass().isAssignableFrom(beanType))
        .findAny()
        .orElseThrow(NoSuchBeanException::new);
    return beanType.cast(result);
  }

  @Override
  public <T> T getBean(String name, Class<T> beanType) throws NoSuchBeanException {
    return context.entrySet().stream()
        .filter(entry -> entry.getKey().equals(name))
        .map(entry -> beanType.cast(entry.getValue()))
        .findAny()
        .orElseThrow(NoSuchBeanException::new);
  }

  @Override
  public <T> Map<String, T> getAllBeans(Class<T> beanType) {
    return context.entrySet().stream()
        .collect(Collectors.toMap(Entry::getKey, e -> beanType.cast(e.getValue())));
  }
}

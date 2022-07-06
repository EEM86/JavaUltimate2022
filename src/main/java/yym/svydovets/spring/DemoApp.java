package yym.svydovets.spring;

import yym.svydovets.spring.ioc.ApplicationContext;
import yym.svydovets.spring.ioc.ApplicationContextImpl;
import yym.svydovets.spring.ioc.example.GreetingService;
import yym.svydovets.spring.ioc.example.MorningService;
import yym.svydovets.spring.ioc.example.TalkingService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class DemoApp {

  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    final ApplicationContext context = new ApplicationContextImpl("yym.svydovets.spring");
    final Map<String, TalkingService> allBeans = context.getAllBeans(TalkingService.class);
    allBeans.values().forEach(TalkingService::talk);

    final GreetingService greetingBean = context.getBean(GreetingService.class);
    greetingBean.talk();

    final MorningService morningBean = context.getBean("morningService", MorningService.class);
    morningBean.talk();
  }

}

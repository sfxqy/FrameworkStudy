package com.spring.beanFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author sfx
 * @Description
 */
public class BeanFactory {
  ThreadLocal<BeanFactory> threadLocal=new ThreadLocal<>();


  private static Map<String, Object> beanMap = new HashMap<>();

  public void a(){
    threadLocal.set(1);
  }
  static {
    try {
      InputStream inputStream = BeanFactory.class.getClassLoader()
          .getResourceAsStream("beans.xml");
      SAXReader saxReader = new SAXReader();
      Document read = saxReader.read(inputStream);
      Element rootElement = read.getRootElement();
      List<Element> elements = rootElement.selectNodes("//bean");
      //循环bean标签，实例化对象
      for (Element e:elements){
        String id = e.attributeValue("id");
        String aClass = e.attributeValue("class");
        Class<?> clazz = Class.forName(aClass);
        Object o = clazz.newInstance();
        beanMap.put(id,o);
      }
      List<Element> list = rootElement.selectNodes("//property");
      for (Element e:list){
        String name = e.attributeValue("name");
        String ref = e.attributeValue("ref");
        Object o = beanMap.get(ref);
        String id = e.getParent().attributeValue("id");
        Object sourceObj = beanMap.get(id);
        Class<?> sourceClass = sourceObj.getClass();
        Method[] methods = sourceClass.getMethods();
        for (int i=0;i<methods.length;i++){
          Method method = methods[i];
          if (method.getName().equals("set"+name)){
            Object invoke = method.invoke(sourceObj, o);
          }
        }

      }


    } catch (DocumentException e) {
      e.printStackTrace();
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }


  }


  public Object getBean(String id) {
    return beanMap.get(id);
  }

}

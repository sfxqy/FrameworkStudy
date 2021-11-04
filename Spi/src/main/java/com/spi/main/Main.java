package com.spi.main;

import com.spi.service.Protocol;
import java.util.ServiceLoader;

/**
 * @author sfx
 * @Description spi
 *  提供一个接口，接口中规定方法，根据接口完成具体实现类，
 *  然后需要在resources目录下新建META-INF/services目录，并且在这个目录下新建一个与上述接口的全限定名一致的文件，在这个文件中写入接口的实现类的全限定名：
 */
public class Main {

  public static void main(String[] args) {
    ServiceLoader<Protocol> protocols = ServiceLoader.load(Protocol.class);
    for (Protocol p:protocols){
      p.describe();
    }
  }
}

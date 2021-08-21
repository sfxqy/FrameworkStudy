package com.frametest.io;

import java.io.InputStream;

/**
 * @author sfx
 */
public class Resources {

  public static InputStream getReourcesAsStream(String path){
    InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
    return resourceAsStream;
  }

}

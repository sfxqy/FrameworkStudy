package com.designPatterns.flyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sfx
 * @Description
 */
public class WbeStieFactory {

  private Map<String,WebSite> webSiteMap=new HashMap<>();

  public WebSite getWbeSite(String type){
    if (!webSiteMap.containsKey(type)){
      webSiteMap.put(type,new ConWebSite(type));
    }
    return webSiteMap.get(type);
  }

}

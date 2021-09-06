package com.frametest.test;

import com.frametest.io.Resources;
import com.frametest.pojo.User;
import com.frametest.sqlSession.SqlSession;
import com.frametest.sqlSession.SqlSessionFactory;
import com.frametest.sqlSession.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

/**
 * @author sfx
 */
public class Test {

  public static void main(String[] args) throws Exception{
    InputStream reourcesAsStream = Resources.getReourcesAsStream("sqlMapperConfig.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reourcesAsStream);
    SqlSession sqlSession1 = sqlSessionFactory.openSession();

    User user = new User();
    user.setId(1);
   // List<User> users = sqlSession1.selectOne("userMapper.selectOne", user);
    List<User> users1 = sqlSession1.selectList("userMapper.selectList");
    //System.out.println(users.toString());
    System.out.println(users1.toString());

  }

}

package com.asiainfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.entity.User;
import com.asiainfo.mapper.UserMapper;

/**
 * mybatis一级缓存，一级缓存默认是开启的
 * mybatis使用Map来做缓存并提供了默认的缓存实现，也可以集成第三方缓存，比如ehcache或者redis等。
 * 一级缓存的作用域是会话级别的，同一SqlSession内有效。原理很简单：缓存对象作为SqlSession类的一个属性，当SqlSession对象销毁时，作为属性的缓存当然就没了。
 * 具体实现是：SqlSession的默认实现DefaultSqlSession里面有个属性Executor，Executor的所有实现类都继承自一个基类BaseExecutor，BaseExecutor里面持有mybatis缓存的默认实现PerpetualCache对象。
 * 
 * 通过看mybatis-*.*.*.jar的包org.apache.ibatis.cache可以得知：mybatis的默认缓存实现类是PerpetualCache，decorators包下面是各种装饰类（装饰器模式），提供了各种扩展的功能，但是最基础的实现就是PerpetualCache，当然这个基础的实现类可以换成ehcache或者redis。
 *
 * @author zhangzhiwang
 * @date 2021年1月15日 下午9:02:56
 */
public class FirstLevelCache {
	public static void main(String[] args) {
		InputStream inputStream = null;
		SqlSession sqlSession1 = null;
		SqlSession sqlSession2 = null;
		try {
			inputStream = Resources.getResourceAsStream("myBatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession1 = sqlSessionFactory.openSession();
			System.out.println("sqlSession1 = " + sqlSession1);

			UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
			System.out.println("sqlSession1第一次查询：");
			User user = userMapper.queryUserById(1);
			System.out.println("user = " + user);
			
			System.out.println("--------------------");
			System.out.println("sqlSession1第二次查询：");
			user = userMapper.queryUserById(1);
			System.out.println("user = " + user);
			
//			System.out.println("--------------------");
//			System.out.println("同一SqlSession执行更新操作：");
//			userMapper.updateById(1);
//			sqlSession1.commit();// 可见commit()方法有清空一级缓存的作用
			
			System.out.println("--------------------");
			System.out.println("sqlSession1第三次查询：");
			user = userMapper.queryUserById(1);
			System.out.println("user = " + user);
			
			sqlSession2 = sqlSessionFactory.openSession();
			System.out.println("sqlSession2 = " + sqlSession2);
			UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
			System.out.println("--------------------");
			System.out.println("	sqlSession2第1次查询：");
			user = userMapper2.queryUserById(1);
			System.out.println("user = " + user);
			
			System.out.println("--------------------");
			System.out.println("++++++++++++++SqlSession2执行更新操作：");
			userMapper2.updateById(1);
			sqlSession2.commit();
			
			System.out.println("sqlSession1第四次查询：");
			user = userMapper.queryUserById(1);
			System.out.println("user = " + user);// 此时出现了脏数据
			
			// 结论：mybatis一级缓存只存在与SqlSession内部，范围是同一个会话，在同一会话内commit操作会清空缓存，如果跨会话缓存不起作用
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(sqlSession1 != null) {
				sqlSession1.close();
			}
			if(sqlSession2 != null) {
				sqlSession2.close();
			}
		}
	}
}

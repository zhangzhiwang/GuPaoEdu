package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.entity.User;
import com.asiainfo.mapper.UserMapper;

/**
 * mybatis测试
 *
 * @author zhangzhiwang
 * @date 2021年1月14日 下午8:56:40
 */
public class MyBatisTest {
	/**
	 * Hibernate优缺点：
	 * 优点：Hibernate是真正的ORM框架，解决了表和实体类的映射，相较于jdbc手动处理映射关系来说方便了很多，简化了开发
	 * 缺点：Hibernate是全自动的ORM框架，不需要程序员写sql，所有sql全部自动生成，也正因为程序员不需要也不能干预sql的编写导致了一些问题：比如无法选择查询部分而非全部字段，不能对sql进行优化，不能使用动态sql等。
	 * 
	 * MyBatis的出现解决了hibernate的缺点，它是半自动的orm框架——由程序员自己编写sql。mysql的部分特性（非全部特性）：
	 * 1、支持数据库连接池。mybatis自带数据库连接池，也可以集成第三方连接池
	 * 2、支持动态sql
	 * 3、支持插件
	 * 
	 * 所有ORM框架底层使用的都是原生JDBC
	 */
	public static void main(String[] args) {
		// 在不集成任何框架的情况下，使用原生mybatis API进行编程
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("myBatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
//			User user = sqlSession.selectOne("com.asiainfo.mapper.UserMapper.queryUserById", 1);// 原始iBatis的使用方式，缺点是第一个参数statement由于是字符串，很可能写错，所以提供了第二种以面向对象的方式——getMapper()
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.queryUserById(1);
			System.out.println("user = " + user);
			
			userMapper.saveUser(new User(0, "lisi", 21, null));
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
			
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

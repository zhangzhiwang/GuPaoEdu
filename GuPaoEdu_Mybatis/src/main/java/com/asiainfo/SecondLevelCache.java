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
 * mybatis的二级缓存
 * 所用域是namespace，即同一个mapper。如果一级缓存和二级缓存都开启了，那么缓存命中的顺序是二级缓存->一级缓存->数据库，二级缓存的范围要比一级缓存大，可以解决一级缓存跨会话的脏数据问题
 *
 * @author zhangzhiwang
 * @date 2021年1月15日 下午10:14:12
 */
public class SecondLevelCache {
	public static void main(String[] args) {
		InputStream inputStream = null;
		SqlSession sqlSession1 = null;
		SqlSession sqlSession2 = null;
		try {
			inputStream = Resources.getResourceAsStream("myBatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession1 = sqlSessionFactory.openSession();

			System.out.println("sqlSession1第一次查询：");
			UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
			User user1 = userMapper1.queryUserById(1);
			sqlSession1.commit();// commit()方法对于开启了二级缓存的查询操作来说会把查询结果刷到缓存里面，所以不手动调用commit()方法就不会忘二级缓存里面刷数据
//			user1.setAge(35);
			System.out.println("user1 = " + user1);

			sqlSession2 = sqlSessionFactory.openSession();
//			System.out.println("--------------------------");
//			System.out.println("	sqlSession2第一次查询：");
			UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
//			User user2 = userMapper2.queryUserById(1);
//			System.out.println("user2 = " + user2);
//			System.out.println("user1 == user2 ? : " + (user1 == user2));
			
			userMapper2.updateById(1);
			sqlSession2.commit();
			System.out.println("--------------------------");
			System.out.println("sqlSession1第二次查询：");
			User user3 = userMapper1.queryUserById(1);
			sqlSession1.commit();// commit()方法对于开启了二级缓存的查询操作来说会把查询结果刷到缓存里面，所以不手动调用commit()方法就不会忘二级缓存里面刷数据
//			user1.setAge(35);
			System.out.println("user3 = " + user3);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sqlSession1 != null) {
				sqlSession1.close();
			}
			if (sqlSession2 != null) {
				sqlSession2.close();
			}
		}
	}
}

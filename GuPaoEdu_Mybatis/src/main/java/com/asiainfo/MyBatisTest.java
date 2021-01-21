package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.entity.Car;
import com.asiainfo.entity.Person;
import com.asiainfo.entity.TClass;
import com.asiainfo.entity.Teacher;
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
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//通过看源码可以知道返回的SqlSessionFactory的实现类是DefaultSqlSessionFactory
			sqlSession = sqlSessionFactory.openSession();
//			User user = sqlSession.selectOne("com.asiainfo.mapper.UserMapper.queryUserById", 1);// 原始iBatis的使用方式，缺点是第一个参数statement由于是字符串，很可能写错，所以提供了第二种以面向对象的方式——getMapper()
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			User user = userMapper.queryUserById(1);
//			System.out.println("user = " + user);
//			
//			userMapper.saveUser(new User(0, "lisi", 21, null));
//			sqlSession.commit();
			
//			userMapper.testDynamicSqlIf(1);
//			userMapper.testDynamicSqlTrim(new User(0, "wangwu", 19, null));
//			userMapper.testDynamicSqlSet("wangwu", 22);
//			userMapper.testDynamicSqlWhere(2);
//			sqlSession.commit();
			
//			userMapper.testDynamicSqlForeach(Arrays.asList(1,2,3));
//			userMapper.testDynamicSqlForeach2(Arrays.asList("a1","a2"));
//			sqlSession.commit();
			
			// 测试插入10000条数据，一个是在循环里每次发送一条insert语句，一个是一次性批量发送10000条语句，比较二者的执行效率
//			long begin1 = System.currentTimeMillis();
//			for(int i = 0; i < 10000; i++) {
//				userMapper.saveUser2(new User(0, "user_" + i, i, null));
//			}
//			sqlSession.commit();
//			long end1 = System.currentTimeMillis();
//			System.out.println("循环单条插入耗时：" + (end1 - begin1));// 2230	尽量不要在循环里一次性只保存一条，因为每循环一次就会和数据库交互一次，即使用的连接池那么每提交一次sql都会对sql进行编译和验证等，耗费时间，尽量走批量操作，这样可以大大减少和数据库的交互
//			
//			System.out.println("---------------------");
//			long begin2 = System.currentTimeMillis();
//			List<User> userList = new ArrayList<>();
//			for(int i = 0; i < 10000; i++) {
//				userList.add(new User(0, "user_" + i, i, null));
//			}
//			userMapper.testDynamicSqlForeach3(userList);
//			sqlSession.commit();
//			long end2 = System.currentTimeMillis();
//			System.out.println("批量插入耗时：" + (end2 - begin2));// 325	如果有批量操作的需要，可以在配置文件中的settings部分设置defaultExecutorType属性为BATCH
			
			// 测试联合查询
//			List<Person> personList = userMapper.testAssociation();
//			Person person = personList.get(0);
//			person.getName();
//			person.getIdCard();
//			System.out.println(person);
			
//			Person person = userMapper.testCollection();
//			System.out.println("person = " + person);
//			List<Car> list = userMapper.queryCar();
//			System.out.println(list);
			
//			List<TClass> list = userMapper.testMultiToMulti2();
//			System.out.println(list);
			
			Person person = userMapper.testAllRelation();
			System.out.println(person);
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

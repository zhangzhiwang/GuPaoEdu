package com.asiainfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.entity.Car;
import com.asiainfo.entity.Person;
import com.asiainfo.entity.User;

public interface UserMapper {
	User queryUserById(@Param("id") int id);
	
	int saveUser(@Param("u") User user);
	
	int updateById(@Param("id") int id);
	
	User testDynamicSqlIf(@Param("id") int id);
	
	User testDynamicSqlChoose(@Param("id") int id);
	
	int testDynamicSqlTrim(@Param("u") User user);
	
	int testDynamicSqlSet(@Param("name") String name, @Param("age") int age);
	
	int testDynamicSqlWhere(@Param("id") int id);
	
	List<User> testDynamicSqlForeach(@Param("idList") List<Integer> list);
	
	int testDynamicSqlForeach2(@Param("nameList") List<String> nameList);
	
	int testDynamicSqlForeach3(@Param("userList") List<User> userList);
	
	int saveUser2(@Param("u") User user);
	
	List<Person> testAssociation();
	
	Person testCollection();
	
	List<Car> queryCar();
}

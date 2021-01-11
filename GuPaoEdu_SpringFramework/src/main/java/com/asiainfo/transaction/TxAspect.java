package com.asiainfo.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.asiainfo.util.CommonUtil;

@Aspect
@Component
public class TxAspect {
	@Before("@within(com.asiainfo.transaction.MyTransactional)")
	public void before() {
		Connection connection = CommonUtil.getConnection();
		try {
			connection.setAutoCommit(false);
			System.out.println("before，打开连接");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterReturning("@within(com.asiainfo.transaction.MyTransactional)")
	public void afterReturning() {
		Connection connection = CommonUtil.getConnection();
		try {
			connection.commit();
			System.out.println("afterReturning，提交事务");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterThrowing("@within(com.asiainfo.transaction.MyTransactional)")
	public void afterThrowing() {
		Connection connection = CommonUtil.getConnection();
		try {
			connection.rollback();
			System.out.println("afterThrowing，事务回滚");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

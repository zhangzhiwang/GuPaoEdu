package com.asiainfo.transaction;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;

@Service
//@MyTransactional
@Data
@Transactional(propagation = Propagation.REQUIRED,// 传播行为（怎么解决嵌套事务的问题，外层事务的策略是不是要传播到内层事务），默认为REQUIRED：外层有事务就加入，没有就新起一个事务
				isolation = Isolation.DEFAULT// 隔离级别（两个及以上事务互相影响的程度）：DEFAULT-采用数据库隔离级别，一般使用DEFAULT和数据库保持一致，此外还有读未提交、读已提交、可重复度和序列化
		)
public class TxService {
	@Autowired
	private Dao1 dao1;
	@Autowired
	private Dao2 dao2;
	
	public void serviceMethod() {
		dao1.met1();
//		int i = 1 / 0;
		dao2.met2();
	}
}

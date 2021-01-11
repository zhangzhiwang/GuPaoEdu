package com.asiainfo.transaction;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;

@Service
//@MyTransactional
@Data
@Transactional
public class TxService {
	@Autowired
	private Dao1 dao1;
	@Autowired
	private Dao2 dao2;
	
	@Transactional
	public void serviceMethod() throws SQLException {
		dao1.met1();
//		int i = 1 / 0;
		dao2.met2();
	}
}

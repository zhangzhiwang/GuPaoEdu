package com.asiainfo.service.impl.impl_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;
import com.asiainfo.service.impl.UserServiceImpl;

import lombok.Data;

@Data
@Service("s1_ext")
public class UserServiceImplExt extends UserServiceImpl {
	public void m4() {
		System.out.println("m4");
	}
}

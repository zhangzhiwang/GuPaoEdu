package com.asiainfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asiainfo.entity.Student2;

public interface IStudentDao extends JpaRepository<Student2, Integer>{							// JpaRepository的两个泛型：第一个是实体类，第二个是主键的类型

}

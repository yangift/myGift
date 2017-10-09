package com.yml.crm.dao;

import static org.junit.Assert.*;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.yml.crm.domain.Role;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月15日
 *类说明：
 */
public class Test2 {

	SqlSession session = null;
	RoleDao mapper = null;
	@Before
	public void setUp() throws Exception {
		//读取configuration.xml配置文件
		Reader reader = Resources.getResourceAsReader("configuration.xml");
		//生成一个SqlSessionFactory的工厂类的对象
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory的工厂是生产SqlSession的实例
		 session = sessionFactory.openSession();
		 mapper = session.getMapper(RoleDao.class);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Role role= mapper.getRoleById(1);
		System.out.println(role);
	}

}

package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Consumer;


public interface ConsumerDao {
	public List<Consumer> getConsumerByWhere(String where);//查找用户，包括管理员等
	public Consumer getConsumerByName(String conName);
}

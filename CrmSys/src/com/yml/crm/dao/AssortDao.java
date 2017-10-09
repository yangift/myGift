package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Assort;
import com.yml.crm.domain.Linkman;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月13日
 *类说明：
 */
public interface AssortDao {
	public List<Assort> getAssortByWhere(String where);
	public Assort getAssortById(int assId);
	public void update(Assort ass);
	public void delById(int assId);
	public void save(Assort ass);//保存
}

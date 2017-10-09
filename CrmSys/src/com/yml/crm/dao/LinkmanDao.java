package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Linkman;
import com.yml.crm.domain.SalChance;

public interface LinkmanDao {
	public List<Linkman> getLinkmanByWhere(String where);
	public Linkman getLinkmanById(int linId);
	public void update(Linkman Linkman);
	public void delById(int id);
	public void save(Linkman lin);//保存
}

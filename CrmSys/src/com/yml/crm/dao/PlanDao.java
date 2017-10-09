package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Plan;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月8日
 *类说明：
 */
public interface PlanDao {
	public List<Plan> getPlanByWhere(String where);
	public void save(Plan plan);
	public void update(Plan plan);
	public void delById(int planid);
	public Plan getPlanById(int planid);
}

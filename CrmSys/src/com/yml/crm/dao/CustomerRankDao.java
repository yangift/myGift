package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.CustomerRank;

public interface CustomerRankDao {
	public List<CustomerRank> getCustomerRankByWhere(String where);
}

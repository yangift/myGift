package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.ServeType;

public interface ServeTypeDao {
	public List<ServeType> getServeTypeByWhere(String where);
}

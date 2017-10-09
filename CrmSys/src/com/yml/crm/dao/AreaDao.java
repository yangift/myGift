package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Area;

public interface AreaDao {
	public List<Area> getAreaByWhere(String where );
	
}

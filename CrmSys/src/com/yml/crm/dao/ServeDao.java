package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Serve;

public interface ServeDao {
	public List<Serve> getServeByWhere(String where);
	public List<Serve> getListByWhere(String where);
	public int updateServeDao(Serve serve);
	public int inputServe(Serve serve);
}

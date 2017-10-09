package com.yml.crm.dao;

import java.util.List;

import com.yml.crm.domain.Assort;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Linkman;
import com.yml.crm.domain.Orders;
import com.yml.crm.domain.Serve;


public interface CustomerDao {
	public List<Customer> getCustomerByWhere(String where);
	public void save(Customer cus);//保存
	public void update(Customer cus);//更新
	public Customer getCustomerById(int id);//根据id查找
	public void delCustomerById(int id);//根据id删除
	public List<Serve> getServesByWhere(String where);
	public List<Linkman> getLinkmansByWhere(String where);
	public List<Assort> getAssortsByWhere(String where);
	public List<Orders> getOrdersByWhere(String where); 
}

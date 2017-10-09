package com.yml.crm.count.dao;

import java.util.List;

import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Lost;
import com.yml.crm.domain.Orders;
import com.yml.crm.domain.OrdersDetail;
import com.yml.crm.domain.Serve;

public interface countDao {
	public List<Orders> getOrdersByWhere(String where);
	public List<OrdersDetail> getOrdersDetailByWhere(String where);
	public List<Customer> getCustomerByWhere(String where);
	public List<Serve> getServeByWhere(String where);
	public String Count(String where);
	public List<Lost> getWastageByWhere(String where);
	/*public String CountServe(String where);*/
}

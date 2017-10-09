package com.yml.crm.count.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.count.dao.countDao;
import com.yml.crm.domain.*;

public class countDaoImpl implements countDao {
	public List<Orders> getOrdersByWhere(String where){
		List<Orders> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select ORD_ID,ORD_CUST_ID,CUS_NAME,ORD_DATE,ORD_STATE,ORD_ADDRESS from orders o inner join customer c on c.cus_id=o.ord_cust_id  where 1=1 "
				+ where;
		System.out.println(sql);
		
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Orders order = new Orders();
				order.setOrdId(rs.getInt(1));//�������
				Customer cust = new Customer();
				cust.setCusId(rs.getInt(2));//�ͻ����
				cust.setCusName(rs.getString(3));//�ͻ���
				order.setCustomer(cust);//Customer��
				order.setOrdDate(rs.getTimestamp(4));//  ��������
				order.setOrdState(rs.getLong(5));//
				order.setOrdAddress(rs.getString(6));
				list.add(order);
				
			}
			//System.out.println(list.get(1).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		if(list!=null){
			//System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				Orders order = list.get(i);
				
				List<OrdersDetail> ordersDetails = getOrdersDetailByWhere("and OL_ORD_ID="+order.getOrdId());
				System.out.println("ordersDetails.size"+ordersDetails.size());
				order.setOrdersDetails(ordersDetails);
				Double total = 0d;
				if(ordersDetails!=null){
			    	for(int j=0;j<ordersDetails.size();j++){
			    		OrdersDetail detail = ordersDetails.get(j);
			    		total = detail.getOlCount()*detail.getOlPrice()+total;
			    		order.setTotal(total);
			    		
			    	}
			    }
			}
		}
		
		return list;
	}

	public List<OrdersDetail> getOrdersDetailByWhere(String where){
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select OL_ID,OL_ORD_ID,OL_WAR_ID,OL_PRICE,OL_COUNT,OL_UNIT from orders_detail  where 1=1 "
				+ where;
		System.out.println("getOrdersDetailByWhere"+sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				//System.out.println("nihao ");
				OrdersDetail detail = new OrdersDetail();
				detail.setOlId(rs.getInt(1));
				Orders order = new Orders();
				order.setOrdId(rs.getInt(2));

				detail.setOlPrice(rs.getDouble(4));
				detail.setOlCount(rs.getLong(5));
				detail.setOlUnit(rs.getString(6));
				list.add(detail);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		System.out.println("getOrdersDetailByWhere ok="+list.size());
		return list;
	}
	//public List<Customer> getCustomerByWhere(String where);
	public List<Customer> getCustomerByWhere(String where){
		System.out.println(where);
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql="select cus_id,ck_id,ck_name,cus_creditworthiness,cus_statisfcing from customer c inner join customer_rank cr on c.cus_id=cr.ck_id group by "+where;
		//String sql="select count(*) from customer c inner join customer_rank cr on c.cus_id=cr.ck_id group by "+where;
		System.out.println(sql);
		
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				//System.out.println("����"+rs.getInt(1));
				Customer customer = new Customer();
				customer.setCusId(rs.getInt(1));
				CustomerRank customerrank = new CustomerRank();
				customerrank.setCkId(rs.getInt(2));
				customerrank.setCkName(rs.getString(3));
				customer.setCustomerRank(customerrank);
				customer.setCusCreditworthiness(rs.getLong(4));
				customer.setCusStatisfcing(rs.getLong(5));
				list.add(customer);
				//System.out.println("list"+list.size());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return list;
		
	}
	public String Count(String where){
		String count="";
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql="select count(*) from customer c inner join customer_rank cr on c.cus_id=cr.ck_id group by "+where;
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				//System.out.println("����"+rs.getInt(1));
				count = count+rs.getInt(1)+",";
				
			}
			System.out.println("count"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		
		return count;
	}
	public List<Serve> getServeByWhere(String where){
		List<Serve> list = new ArrayList<Serve>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql="select ser_id,se_id,se_name from serve s inner join serve_type st on st.se_id=s.ser_id where "+where;
		System.out.println("getServeByWhere="+sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Serve serve = new Serve();
				serve.setSerId(rs.getInt(1));
				ServeType serveType = new ServeType();
				serveType.setSeId(rs.getInt(2));
				serveType.setSeName(rs.getString(3));
				serve.setServeType(serveType);
				list.add(serve);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		
		return list;
	}
	/*public String CountServe(String where){
		String count="";
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql="select count(*) from serve s inner join serve_type st on c.cus_id=cr.ck_id group by "+where;
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				//System.out.println("����"+rs.getInt(1));
				count = count+rs.getInt(1)+",";
				
			}
			System.out.println("count"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		
		return count;
	}*/
	public List<Lost> getWastageByWhere(String where){
		List<Lost> list = new ArrayList<Lost>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "Select los_id,los_customer,los_manager,los_respite,los_date,los_reason from lost where 1=1 "+where;
		System.out.println(sql);
		conn = UtilConnect.getConn();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Lost lost = new Lost();
				lost.setLosId(rs.getInt(1));
				lost.setLosCustomer(rs.getString(2));
				lost.setLosManager(rs.getString(3));
				lost.setLosRespite(rs.getString(4));
				lost.setLosDate(rs.getTimestamp(5));
				lost.setLosReason(rs.getString(6));
				list.add(lost);
			}
			System.out.println("Impl中="+list.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return list;
	}
}

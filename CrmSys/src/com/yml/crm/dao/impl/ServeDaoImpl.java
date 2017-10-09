package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.ServeDao;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Serve;
import com.yml.crm.domain.ServeType;

public class ServeDaoImpl implements ServeDao {
	
	public List<Serve> getServeByWhere(String where) {
		List<Serve> list = new ArrayList<Serve>();
		Connection conn =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sqlServe = "select SER_ID,SER_SE_ID,SER_CUS_ID,SER_CREATER,SER_CREATER_DATE,SER_SERVICE_REQUEST,SER_ALLOT_NAME,SER_ALLOT_DATE,SER_HANDLE,SER_HANDLER,SER_RESULT,SER_SATISFCING,SER_RESUME,SER_STATE from serve where 1=1 "+where;
		
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sqlServe);
			rs = st.executeQuery();
			while(rs.next()){
				Serve serve = new Serve();
				serve.setSerId(rs.getInt(1));
				ServeType servetype = new ServeType();
				servetype.setSeId(rs.getInt(2));
				serve.setServeType(servetype);
				Customer customer = new Customer();
				customer.setCusId(rs.getInt(3));
				serve.setCustomer(customer);
				serve.setSerCreater(rs.getString(4));
				serve.setSerCreaterDate(rs.getTimestamp(5));
				serve.setSerServiceRequest(rs.getString(6));
				serve.setSerAllotName(rs.getString(7));
				serve.setSerAllotDate(rs.getTimestamp(8));
				serve.setSerHandle(rs.getString(9));
				serve.setSerHandler(rs.getString(10));
				serve.setSerResult(rs.getString(11));
				serve.setSerSatisfcing(rs.getLong(12));
				serve.setSerResume(rs.getString(13));
				serve.setSerState(rs.getLong(14));
				
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
	
	public List<Serve> getListByWhere(String where){
		List<Serve> list = new ArrayList<Serve>();
		Connection conn =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select SER_ID,SE_name,CUS_name,SER_CREATER,SER_CREATER_DATE,SER_RESUME,ser_state from serve ser inner join customer cus on cus.cus_id = ser.SER_CUS_ID inner join serve_type se on ser.SER_SE_ID=se.se_id where 1=1 "+where;
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Serve serve = new Serve();
				serve.setSerId(rs.getInt(1));
				ServeType servetype = new ServeType();
				servetype.setSeName(rs.getString(2));
				serve.setServeType(servetype);
				Customer customer = new Customer();
				customer.setCusName(rs.getString(3));
				serve.setCustomer(customer);
				serve.setSerCreater(rs.getString(4));
				serve.setSerCreaterDate(rs.getTimestamp(5));
				serve.setSerResume(rs.getString(6));
				serve.setSerState(rs.getLong(7));
				
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
	public int updateServeDao(Serve serve){
		int serupdate = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update serve set SER_ALLOT_NAME=?,SER_ALLOT_DATE=?,SER_STATE=? where ser_id =? ";
		
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			st.setString(1, serve.getSerAllotName());
			st.setTimestamp(2, serve.getSerAllotDate());
			st.setLong(3, serve.getSerState());
			st.setInt(4, serve.getSerId());
			 serupdate = st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return serupdate;
	}


	public int inputServe(Serve serve) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into serve (SER_SE_ID,SER_CUS_ID,SER_CREATER,SER_CREATER_DATE,SER_SERVICE_REQUEST,SER_RESUME,SER_STATE) values (?,?,?,?,?,?,?)";
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			st.setInt(1, serve.getServeType().getSeId());
			st.setInt(2, serve.getCustomer().getCusId());
			st.setString(3, serve.getSerCreater());
			st.setTimestamp(4, serve.getSerCreaterDate());
			st.setString(5, serve.getSerServiceRequest());
			st.setString(6, serve.getSerResume());
			st.setLong(7, serve.getSerState());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return 0;
	}
}

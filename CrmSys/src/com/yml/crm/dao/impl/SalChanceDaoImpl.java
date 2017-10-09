package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.SalChanceDao;
import com.yml.crm.domain.SalChance;

public class SalChanceDaoImpl implements SalChanceDao {


	@Override
	public List<SalChance> getSalChancesByWhere(String where) {
		// TODO Auto-generated method stub
		List<SalChance> list = new ArrayList<SalChance>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select   chc_id,chc_source,chc_cust_name,chc_title,chc_rate,chc_linkman,chc_tel,chc_desc,chc_create_id,"+
		"chc_create_name,chc_create_date,chc_due_id,chc_due_name,chc_due_date,chc_status from sal_chance where 1=1 " + where;
				
		try {
			conn = UtilConnect.getConn();
			
			st = conn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				SalChance sal = new SalChance();
				sal.setChcId(rs.getLong(1));
				sal.setChcSource(rs.getString(2));
				sal.setChcCustName(rs.getString(3));
				sal.setChcTitle(rs.getString(4));
				sal.setChcRate(rs.getInt(5));
				sal.setChcLinkman(rs.getString(6));
				sal.setChcTel(rs.getString(7));
				sal.setChcDesc(rs.getString(8));
				sal.setChcCreateId(rs.getInt(9));
				sal.setChcCreateName(rs.getString(10));
				sal.setChcCreateDate(rs.getTimestamp(11));
				sal.setChcDueId(rs.getInt(12));
				sal.setChcDueName(rs.getString(13));
				sal.setChcDueDate(rs.getTimestamp(14));
				sal.setChcStatus(rs.getString(15));				
				list.add(sal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return list;
	}
	@Override
	public void save(SalChance sal){
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into sal_chance (chc_source,chc_cust_name,chc_title,chc_rate,chc_linkman,chc_tel,chc_desc,chc_create_id,"+
		"chc_create_name,chc_create_date,chc_due_id,chc_due_name,chc_due_date,chc_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			
			st.setString(1,sal.getChcSource());
			st.setString(2,sal.getChcCustName());
			st.setString(3,sal.getChcTitle());
			st.setInt(4,sal.getChcRate());
			st.setString(5,sal.getChcLinkman());
			st.setString(6,sal.getChcTel());
			st.setString(7,sal.getChcDesc());
			st.setInt(8,sal.getChcCreateId());
			st.setString(9,sal.getChcCreateName());
			st.setTimestamp(10,sal.getChcCreateDate());
			st.setInt(11,sal.getChcDueId()==null?0:sal.getChcDueId());
			st.setString(12,sal.getChcDueName());
			st.setTimestamp(13,sal.getChcDueDate());
			st.setString(14,sal.getChcStatus());	
			st.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
	}
	@Override
	public void update(SalChance sal) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update sal_chance set chc_source=?,chc_cust_name=?,chc_title=?,chc_rate=?,chc_linkman=?,chc_tel=?,chc_desc=?,chc_create_id=?,"+
		"chc_create_name=?,chc_create_date=?,chc_due_id=?,chc_due_name=?,chc_due_date=?,chc_status=? where chc_id=?";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setString(1,sal.getChcSource());
			st.setString(2,sal.getChcCustName());
			st.setString(3,sal.getChcTitle());
			st.setInt(4,sal.getChcRate());
			st.setString(5,sal.getChcLinkman());
			st.setString(6,sal.getChcTel());
			st.setString(7,sal.getChcDesc());
			st.setInt(8,sal.getChcCreateId());
			st.setString(9,sal.getChcCreateName());
			st.setTimestamp(10,sal.getChcCreateDate());
			st.setInt(11,sal.getChcDueId()==null?0:sal.getChcDueId());
			st.setString(12,sal.getChcDueName());
			st.setTimestamp(13,sal.getChcDueDate());
			st.setString(14,sal.getChcStatus());	
			st.setLong(15,sal.getChcId());
			st.executeUpdate();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				UtilConnect.close(st);
				UtilConnect.close(conn);
			}
		
	}
	
	public SalChance getSalChanceById(long id) {
		SalChance sal = new SalChance();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select   chc_id,chc_source,chc_cust_name,chc_title,chc_rate,chc_linkman,chc_tel,chc_desc,chc_create_id,"+
		"chc_create_name,chc_create_date,chc_due_id,chc_due_name,chc_due_date,chc_status from sal_chance where chc_id= " + id;
		System.out.println(sql);
		
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			
			rs = st.executeQuery();
			// ResultSet是个集合，里面存的是数据库的表数据，以二维表的形式呈现，
			// rs.next也是一个游标，默认情况下游标是指的第一行数据之前，当第一次调用。next()的时候游标指的是第一行数据，再次调用，指的是下一行数据
			while (rs.next()) {
				sal.setChcId(rs.getLong(1));
				sal.setChcSource(rs.getString(2));
				sal.setChcCustName(rs.getString(3));
				sal.setChcTitle(rs.getString(4));
				sal.setChcRate(rs.getInt(5));
				sal.setChcLinkman(rs.getString(6));
				sal.setChcTel(rs.getString(7));
				sal.setChcDesc(rs.getString(8));
				sal.setChcCreateId(rs.getInt(9));
				sal.setChcCreateName(rs.getString(10));
				sal.setChcCreateDate(rs.getTimestamp(11));
				sal.setChcDueId(rs.getInt(12));
				sal.setChcDueName(rs.getString(13));
				sal.setChcDueDate(rs.getTimestamp(14));
				sal.setChcStatus(rs.getString(15));				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return sal;
	}
	@Override
	public void delSalChanceById(long id) {
		//删除
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "delete from sal_chance where chc_id = "+id;
		System.out.println(sql);
		try{
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
	}
	@Override
	public void updatechcStatus(SalChance sal) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update sal_chance set chc_status=? where chc_id=?";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setString(1,sal.getChcStatus());	
			st.setLong(2,sal.getChcId());
			st.executeUpdate();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				UtilConnect.close(st);
				UtilConnect.close(conn);
			}
		
	}
}

package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.LinkmanDao;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Linkman;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月13日
 *类说明：
 */
public class LinkmanDaoImpl implements LinkmanDao {

	@Override
	public List<Linkman> getLinkmanByWhere(String where) {
		List<Linkman> list = new ArrayList<Linkman>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select  LIN_ID,CUS_ID,CUS_NAME,LIN_NAME,LIN_SEX,LIN_TELEPHONE,"
				+ "LIN_POST,LIN_MOBILE,LIN_MEMO from linkman inner join customer on linkman.LIN_CUS_ID = customer.CUS_ID where 1=1 " + where;
			System.out.println("sql="+sql);	
		try {
			conn = UtilConnect.getConn();
			
			st = conn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				Linkman lin = new Linkman();
				lin.setLinId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				cus.setCusName(rs.getString(3));
				lin.setCustomer(cus);
				lin.setLinName(rs.getString(4));
				lin.setLinSex(rs.getString(5));
				lin.setLinTelephone(rs.getString(6));
				lin.setLinPost(rs.getString(7));
				lin.setLinMobile(rs.getString(8));
				lin.setLinMemo(rs.getString(9));
				list.add(lin);
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
	public Linkman getLinkmanById(int linId) {
		Linkman lin = new Linkman();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select  LIN_ID,CUS_ID,CUS_NAME,LIN_NAME,LIN_SEX,LIN_TELEPHONE,"
				+ "LIN_POST,LIN_MOBILE,LIN_MEMO from linkman inner join customer on linkman.LIN_CUS_ID = customer.CUS_ID where LIN_ID = ? ";
				
		try {
			conn = UtilConnect.getConn();
			
			st = conn.prepareStatement(sql);
			st.setInt(1, linId);
			rs = st.executeQuery();
			while (rs.next()) {	
				lin.setLinId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				cus.setCusName(rs.getString(3));
				lin.setCustomer(cus);
				lin.setLinName(rs.getString(4));
				lin.setLinSex(rs.getString(5));
				lin.setLinTelephone(rs.getString(6));
				lin.setLinPost(rs.getString(7));
				lin.setLinMobile(rs.getString(8));
				lin.setLinMemo(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return lin;
	}

	@Override
	public void update(Linkman lin) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update linkman set LIN_NAME=?,LIN_SEX=?,LIN_TELEPHONE=?,LIN_POST=?,LIN_MOBILE=?,LIN_MEMO=? where LIN_ID=?";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setString(1, lin.getLinName());
			st.setString(2, lin.getLinSex());
			st.setString(3, lin.getLinTelephone());
			st.setString(4, lin.getLinPost());
			st.setString(5, lin.getLinMobile());
			st.setString(6, lin.getLinMemo());
			st.setInt(7, lin.getLinId());
			st.executeUpdate();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				UtilConnect.close(st);
				UtilConnect.close(conn);
			}
		
	}

	@Override
	public void delById(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "delete from linkman where lin_id = "+id;
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
	public void save(Linkman lin) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into linkman (LIN_NAME,LIN_SEX,LIN_TELEPHONE,LIN_POST,LIN_MOBILE,LIN_MEMO,LIN_CUS_ID) values(?,?,?,?,?,?,?)";
		//System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setString(1, lin.getLinName());
			st.setString(2, lin.getLinSex());
			st.setString(3, lin.getLinTelephone());
			st.setString(4, lin.getLinPost());
			st.setString(5, lin.getLinMobile());
			st.setString(6, lin.getLinMemo());
			st.setInt(7, lin.getCustomer().getCusId());
			st.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		
	}

}

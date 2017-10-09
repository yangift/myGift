package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.AssortDao;
import com.yml.crm.domain.Assort;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Linkman;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月13日
 *类说明：
 */
public class AssortDaoImpl implements AssortDao {

	@Override
	public List<Assort> getAssortByWhere(String where) {
		List<Assort> list = new ArrayList<Assort>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select  ASS_ID,CUS_ID,CUS_NAME,ASS_DATE,ASS_PALCE,ASS_RESUME,ASS_DETAIL,ASS_MEMO from assort inner join customer on assort.ASS_CUS_ID = customer.CUS_ID where 1=1 " + where;
		try {
			conn = UtilConnect.getConn();
			
			st = conn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				Assort ass = new Assort();
				ass.setAssId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				cus.setCusName(rs.getString(3));
				ass.setCustomer(cus);
				ass.setAssDate(rs.getTimestamp(4));
				ass.setAssPalce(rs.getString(5));
				ass.setAssResume(rs.getString(6));
				ass.setAssDetail(rs.getString(7));
				ass.setAssMemo(rs.getString(8));
				list.add(ass);
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
	public Assort getAssortById(int assId) {
		Assort ass = new Assort();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select  ASS_ID,CUS_ID,CUS_NAME,ASS_DATE,ASS_PALCE,ASS_RESUME,ASS_DETAIL,ASS_MEMO from assort inner join customer on assort.ASS_CUS_ID = customer.CUS_ID where ASS_ID = ? ";
				
		try {
			conn = UtilConnect.getConn();
			
			st = conn.prepareStatement(sql);
			st.setInt(1, assId);
			rs = st.executeQuery();
			while (rs.next()) {	
				ass.setAssId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				cus.setCusName(rs.getString(3));
				ass.setCustomer(cus);
				ass.setAssDate(rs.getTimestamp(4));
				ass.setAssPalce(rs.getString(5));
				ass.setAssResume(rs.getString(6));
				ass.setAssDetail(rs.getString(7));
				ass.setAssMemo(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return ass;
	}

	@Override
	public void update(Assort ass) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update assort set ASS_DATE=?,ASS_PALCE=?,ASS_RESUME=?,ASS_DETAIL=?,ASS_MEMO=? where ASS_ID=?";
		//System.out.println(sql);		
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setTimestamp(1, ass.getAssDate());
			st.setString(2, ass.getAssPalce());
			st.setString(3, ass.getAssResume());
			st.setString(4, ass.getAssDetail());
			st.setString(5, ass.getAssMemo());
			st.setInt(6, ass.getAssId());
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
	public void delById(int assId) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "delete from assort where lin_id = "+assId;
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
	public void save(Assort ass) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into assort (ASS_DATE,ASS_PALCE,ASS_RESUME,ASS_DETAIL,ASS_MEMO,ASS_CUS_ID) values(?,?,?,?,?,?)";
		//System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setTimestamp(1, ass.getAssDate());
			st.setString(2, ass.getAssPalce());
			st.setString(3, ass.getAssResume());
			st.setString(4, ass.getAssDetail());
			st.setString(5, ass.getAssMemo());
			st.setInt(6, ass.getCustomer().getCusId());
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

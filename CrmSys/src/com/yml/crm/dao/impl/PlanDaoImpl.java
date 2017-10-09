package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.PlanDao;
import com.yml.crm.domain.Consumer;
import com.yml.crm.domain.Plan;
import com.yml.crm.domain.Role;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月8日
 *类说明：
 */
public class PlanDaoImpl implements PlanDao {

	@Override
	public List<Plan> getPlanByWhere(String where) {
		List<Plan> list = new ArrayList<Plan>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select pla_id,pla_chc_id,pla_plan,pla_date,pla_result from plan where 1=1 " +where;
		System.out.println(sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Plan plan = new Plan();
				plan.setPlaId(rs.getInt(1));
				plan.setPlaChcId(rs.getInt(2));
				plan.setPlaPlan(rs.getString(3));
				plan.setPlaDate(rs.getTimestamp(4));
				plan.setPlaResult(rs.getString(5));
				list.add(plan);
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
	public void save(Plan plan) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into plan (pla_chc_id,pla_plan,pla_date,pla_result) values(?,?,?,?)";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			//st.setInt(1, plan.getPlaId());
			st.setInt(1, plan.getPlaChcId());
			st.setString(2, plan.getPlaPlan());
			st.setTimestamp(3, plan.getPlaDate());
			st.setString(4, plan.getPlaResult());
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
	public void delById(int plaid) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "delete from plan where pla_id = "+plaid;
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
	public Plan getPlanById(int planid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Plan plan) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update plan set pla_chc_id=?,pla_plan=?,pla_date=?,pla_result=?";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setInt(1, plan.getPlaChcId());
			st.setString(2, plan.getPlaPlan());
			st.setTimestamp(3, plan.getPlaDate());
			st.setString(4,plan.getPlaResult());
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

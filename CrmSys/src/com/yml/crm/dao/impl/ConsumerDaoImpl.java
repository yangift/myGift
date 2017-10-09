package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.ConsumerDao;
import com.yml.crm.domain.Consumer;
import com.yml.crm.domain.Role;

public class ConsumerDaoImpl implements ConsumerDao {

	@Override
	public List<Consumer> getConsumerByWhere(String where) {
		List<Consumer> list = new ArrayList<Consumer>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select con_id,rol_id,rol_name,con_name,con_password from consumer c inner join role r on "
				+ "c.con_rol_id = r.rol_id where 1=1  " + where;

		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Consumer cons = new Consumer();
				cons.setConId(rs.getInt(1));
				Role role = new Role();
				role.setRolId(rs.getInt(2));
				role.setRolName(rs.getString(3));
				cons.setRole(role);
				cons.setConName(rs.getString(4));
				cons.setConPassword(rs.getString(5));
				list.add(cons);
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
	public Consumer getConsumerByName(String conName) {
		Consumer cons = new Consumer();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select con_id,rol_id,rol_name,con_name,con_password from consumer c inner join role r on "
				+ "c.con_rol_id = r.rol_id where con_name = ?";
		
		try {
			conn = UtilConnect.getConn();			
			st = conn.prepareStatement(sql);
			st.setString(1,conName);
			rs = st.executeQuery();
			System.out.println("sql="+sql);
			while(rs.next()){
				cons.setConId(rs.getInt(1));
				Role role = new Role();
				role.setRolId(rs.getInt(2));
				role.setRolName(rs.getString(3));
				cons.setRole(role);
				cons.setConName(rs.getString(4));
				cons.setConPassword(rs.getString(5));
			}
				//st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return cons;
	}

}

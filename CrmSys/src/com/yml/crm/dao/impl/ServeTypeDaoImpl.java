package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.ServeTypeDao;
import com.yml.crm.domain.ServeType;

public class ServeTypeDaoImpl implements ServeTypeDao {


	public List<ServeType> getServeTypeByWhere(String where){
		
		List<ServeType> list = new ArrayList<ServeType>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT se_id,se_name FROM serve_type where 1 = 1 "+where;
		
		
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
			ServeType servetype = new ServeType();
			servetype.setSeId(rs.getInt(1));
			servetype.setSeName(rs.getString(2));
			list.add(servetype);
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


}

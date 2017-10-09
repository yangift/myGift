package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.AreaDao;
import com.yml.crm.domain.Area;

public class AreaDaoImpl implements AreaDao{

	public List<Area> getAreaByWhere(String where ) {
		List<Area> list = new ArrayList<Area>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT ARE_ID,ARE_NAME FROM area where 1=1"+where;
		
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Area area = new Area();
				area.setAreId(rs.getInt(1));
				area.setAreName(rs.getString(2));
				list.add(area);
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		
		return list;
	}

}

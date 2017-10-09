package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.CustomerRankDao;
import com.yml.crm.domain.CustomerRank;

public class CustomerRankDaoImpl implements CustomerRankDao {

	public List<CustomerRank> getCustomerRankByWhere(String where) {
		List<CustomerRank> list = new ArrayList<CustomerRank>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT CK_ID,CK_NAME FROM customer_rank where 1 = 1"
				+ where;

		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				CustomerRank customerrank = new CustomerRank();
				customerrank.setCkId(rs.getInt(1));
				customerrank.setCkName(rs.getString(2));
				list.add(customerrank);
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

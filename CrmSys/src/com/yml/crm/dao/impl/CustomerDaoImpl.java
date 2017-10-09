package com.yml.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yml.crm.conn.UtilConnect;
import com.yml.crm.dao.CustomerDao;
import com.yml.crm.domain.Area;
import com.yml.crm.domain.Assort;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.CustomerRank;
import com.yml.crm.domain.Linkman;
import com.yml.crm.domain.Orders;
import com.yml.crm.domain.Serve;
import com.yml.crm.domain.ServeType;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月11日
 *类说明：
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getCustomerByWhere(String where) {
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//allot是集合
		String sql = "select CUS_ID,CUS_ARE_ID,ARE_NAME,CUS_CK_ID,CK_NAME,CUS_NAME,CUS_NUMBER,CUS_ADDRESS,CUS_CHANGE_ORIGIN,"
				+ "CUS_CHANGE_DESCRIBE,CUS_SUCCESS_PROBABILITY,CUS_MANAGER,CUS_ALLOT_NAME,CUS_ALLOT_DATE,CUS_POSTAL_CODE,"
				+"CUS_TELEPHONE,CUS_FASIMILE,CUS_URL,CUS_REGISTER_NUMBER,CUS_LEGAL_PERSON,CUS_REGISTER_MONEY,"
				+"CUS_RMB,CUS_OPENING_BANK,CUS_BANK_ACCOUNT,CUS_CROWN_RENT,CUS_STATE_TAXES,CUS_RESUME,CUS_CREDITWORTHINESS,"
				+"CUS_STATISFCING,CUS_STATE from ((customer c inner join area a on c.cus_are_id = a.are_id) "
				+ "inner join customer_rank ck on c.cus_ck_id = ck.ck_id) where 1=1 " + where;
				
		try {
			conn = UtilConnect.getConn();
			
			st = conn.prepareStatement(sql);
			//System.out.println("sql="+sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(1));//cus编号
				Area area = new Area();
				area.setAreId(rs.getInt(2));
				area.setAreName(rs.getString(3));
				cus.setArea(area);//地区
				CustomerRank ck = new CustomerRank();
				ck.setCkId(rs.getInt(4));
				ck.setCkName(rs.getString(5));
				cus.setCustomerRank(ck);//等级
				cus.setCusName(rs.getString(6));//客户姓名
				cus.setCusNumber(rs.getString(7));//客户等级
				cus.setCusAddress(rs.getString(8));//地址
				cus.setCusChangeOrigin(rs.getString(9));//起源
				cus.setCusChangeDescribe(rs.getString(10));//描述
				cus.setCusSuccessProbability(rs.getString(11));
				cus.setCusManager(rs.getString(12));
				//CUS_ALLOT_NAME,CUS_ALLOT_DATE未确定是什么意思
				cus.setCusAllotName(rs.getString(13));
				cus.setCusAllotDate(rs.getTimestamp(14));
				cus.setCusPostalCode(rs.getString(15));
				cus.setCusTelephone(rs.getString(16));
				cus.setCusFasimile(rs.getString(17));
				cus.setCusUrl(rs.getString(18));
				cus.setCusRegisterNumber(rs.getString(19));
				cus.setCusLegalPerson(rs.getString(20));
				cus.setCusRegisterMoney(rs.getDouble(21));
				cus.setCusRmb(rs.getDouble(22));
				cus.setCusOpeningBank(rs.getString(23));
				cus.setCusBankAccount(rs.getString(24));
				cus.setCusCrownRent(rs.getString(25));
				cus.setCusStateTaxes(rs.getString(26));
				cus.setCusResume(rs.getString(27));
				cus.setCusCreditworthiness(rs.getLong(28));
				cus.setCusStatisfcing(rs.getLong(29));
				cus.setCusState(rs.getLong(30));
				list.add(cus);
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
	public void save(Customer cus) {//未写完
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into sal_chance (chc_source,chc_cust_name,chc_title,chc_rate,chc_linkman,chc_tel,chc_desc,chc_create_id,"+
		"chc_create_name,chc_create_date,chc_due_id,chc_due_name,chc_due_date,chc_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			
			
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
	public void update(Customer cus) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update customer set CUS_NUMBER=?,cus_Name=?,cus_ARE_ID=?,"
				+ "cus_ck_id=?,cus_Statisfcing=?,cus_Creditworthiness=?,cus_Address=?,"
				+ "cus_Postal_Code=?,cus_Telephone=?,cus_Fasimile=?,cus_Url=?,cus_Register_Number=?,"
				+ "cus_Rmb=?,cus_Opening_Bank=?,cus_Bank_Account=? where cus_id=?";
		System.out.println(sql);
				
		try {
			conn = UtilConnect.getConn();
			// 负责执行SQL语句
			st = conn.prepareStatement(sql);
			st.setString(1, cus.getCusName());
			st.setString(2, cus.getCusName());
			st.setInt(3, cus.getArea().getAreId());
			st.setInt(4, cus.getCustomerRank().getCkId());
			st.setLong(5, cus.getCusStatisfcing());
			st.setLong(6, cus.getCusCreditworthiness());
			st.setString(7, cus.getCusAddress());
			st.setString(8, cus.getCusPostalCode());
			st.setString(9,cus.getCusTelephone());
			st.setString(10, cus.getCusFasimile());
			st.setString(11, cus.getCusUrl());
			st.setString(12, cus.getCusRegisterNumber());
			st.setDouble(13, cus.getCusRmb());
			st.setString(14, cus.getCusOpeningBank());
			st.setString(15, cus.getCusBankAccount());
			st.setInt(16, cus.getCusId());
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
	public Customer getCustomerById(int id) {
		Customer cus = new Customer();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//allot是集合
		String sql = "select CUS_ID,CUS_ARE_ID,ARE_NAME,CUS_CK_ID,CK_NAME,CUS_NAME,CUS_NUMBER,CUS_ADDRESS,CUS_CHANGE_ORIGIN,"
				+ "CUS_CHANGE_DESCRIBE,CUS_SUCCESS_PROBABILITY,CUS_MANAGER,CUS_ALLOT_NAME,CUS_ALLOT_DATE,CUS_POSTAL_CODE,"
				+"CUS_TELEPHONE,CUS_FASIMILE,CUS_URL,CUS_REGISTER_NUMBER,CUS_LEGAL_PERSON,CUS_REGISTER_MONEY,"
				+"CUS_RMB,CUS_OPENING_BANK,CUS_BANK_ACCOUNT,CUS_CROWN_RENT,CUS_STATE_TAXES,CUS_RESUME,CUS_CREDITWORTHINESS,"
				+"CUS_STATISFCING,CUS_STATE from ((customer c inner join area a on c.cus_are_id = a.are_id) "
				+ "inner join customer_rank ck on c.cus_ck_id = ck.ck_id) where cus_id = ? " ;
				
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(id);
			System.out.println("sql="+sql);
			rs = st.executeQuery();
			while (rs.next()) {
				cus.setCusId(rs.getInt(1));//cus编号
				Area area = new Area();
				area.setAreId(rs.getInt(2));
				area.setAreName(rs.getString(3));
				cus.setArea(area);//地区
				CustomerRank ck = new CustomerRank();
				ck.setCkId(rs.getInt(4));
				ck.setCkName(rs.getString(5));
				cus.setCustomerRank(ck);//等级
				cus.setCusName(rs.getString(6));//客户姓名
				cus.setCusNumber(rs.getString(7));//客户等级
				cus.setCusAddress(rs.getString(8));//地址
				cus.setCusChangeOrigin(rs.getString(9));//起源
				cus.setCusChangeDescribe(rs.getString(10));//描述
				cus.setCusSuccessProbability(rs.getString(11));
				cus.setCusManager(rs.getString(12));
				//CUS_ALLOT_NAME,CUS_ALLOT_DATE未确定是什 么意思
				cus.setCusAllotName(rs.getString(13));
				cus.setCusAllotDate(rs.getTimestamp(14));
				cus.setCusPostalCode(rs.getString(15));
				cus.setCusTelephone(rs.getString(16));
				cus.setCusFasimile(rs.getString(17));
				cus.setCusUrl(rs.getString(18));
				cus.setCusRegisterNumber(rs.getString(19));
				cus.setCusLegalPerson(rs.getString(20));
				cus.setCusRegisterMoney(rs.getDouble(21));
				cus.setCusRmb(rs.getDouble(22));
				cus.setCusOpeningBank(rs.getString(23));
				cus.setCusBankAccount(rs.getString(24));
				cus.setCusCrownRent(rs.getString(25));
				cus.setCusStateTaxes(rs.getString(26));
				cus.setCusResume(rs.getString(27));
				cus.setCusCreditworthiness(rs.getLong(28));
				cus.setCusStatisfcing(rs.getLong(29));
				cus.setCusState(rs.getLong(30));
				List<Serve> serList = this.getServesByWhere("AND SER_CUS_ID = " +id);
				cus.setServes(serList);
				List<Linkman> linList = this.getLinkmansByWhere("AND LIN_CUS_ID = "+id);
				cus.setLinkmans(linList);
				List<Assort> assList = this.getAssortsByWhere("AND ASS_CUS_ID = "+id);
				cus.setAssorts(assList);
				List<Orders> ordList = this.getOrdersByWhere("AND ORD_CUST_ID = "+id);
				cus.setOrderses(ordList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilConnect.close(rs);
			UtilConnect.close(st);
			UtilConnect.close(conn);
		}
		return cus;
	}

	@Override
	public void delCustomerById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Serve> getServesByWhere(String where) {
		List<Serve> list = new ArrayList<Serve>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select SER_ID,SER_SE_ID,SER_CUS_ID,SER_CREATER,SER_CREATER_DATE,SER_SERVICE_REQUEST,"
				+ "SER_ALLOT_NAME,SER_ALLOT_DATE,SER_HANDLE,SER_HANDLER,SER_RESULT,SER_SATISFCING,SER_RESUME,"
				+ "SER_STATE from serve where 1=1 " +where;
		//System.out.println(sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Serve serve = new Serve();
				serve.setSerId(rs.getInt(1));
				//ser_se_id是什么？
				serve.setSerCreater(rs.getString(3));
				serve.setSerCreaterDate(rs.getTimestamp(4));
				serve.setSerServiceRequest(rs.getString(5));
				serve.setSerAllotName(rs.getString(6));
				serve.setSerAllotDate(rs.getTimestamp(7));
				serve.setSerHandle(rs.getString(8));
				serve.setSerHandler(rs.getString(9));
				serve.setSerResult(rs.getString(10));
				serve.setSerSatisfcing(rs.getLong(11));
				serve.setSerResume(rs.getString(12));
				serve.setSerState(rs.getLong(13));
				list.add(serve);
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
	public List<Linkman> getLinkmansByWhere(String where) {
		List<Linkman> list = new ArrayList<Linkman>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select LIN_ID,LIN_CUS_ID,LIN_NAME,LIN_SEX,LIN_TELEPHONE,LIN_POST,LIN_MOBILE,LIN_MEMO from linkman inner join customer on linkman.LIN_CUS_ID = customer.CUS_ID where 1=1 " +where;
		//System.out.println(sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Linkman linkman = new Linkman();
				linkman.setLinId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				linkman.setCustomer(cus);
				linkman.setLinName(rs.getString(3));
				linkman.setLinSex(rs.getString(4));
				linkman.setLinTelephone(rs.getString(5));
				linkman.setLinPost(rs.getString(6));
				linkman.setLinMobile(rs.getString(7));
				linkman.setLinMemo(rs.getString(8));
				list.add(linkman);
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
	public List<Assort> getAssortsByWhere(String where) {
		List<Assort> list = new ArrayList<Assort>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select  ASS_ID,ASS_CUS_ID,ASS_DATE,ASS_PALCE,ASS_RESUME,ASS_DETAIL,ASS_MEMO from assort  inner join customer on assort.ASS_CUS_ID = customer.CUS_ID where 1=1 " +where;
		//System.out.println(sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Assort ass = new Assort();
				ass.setAssId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				ass.setCustomer(cus);
				ass.setAssDate(rs.getTimestamp(3));
				ass.setAssPalce(rs.getString(4));
				ass.setAssDetail(rs.getString(5));
				ass.setAssMemo(rs.getString(6));
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
	public List<Orders> getOrdersByWhere(String where) {
		List<Orders> list = new ArrayList<Orders>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select ORD_ID,ORD_CUST_ID,ORD_DATE,ORD_STATE,ORD_ADDRESS from Orders  inner join customer on Orders.ORD_CUST_ID = customer.CUS_ID where 1=1 " +where;
		//System.out.println(sql);
		try {
			conn = UtilConnect.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Orders ord = new Orders();	
				ord.setOrdId(rs.getInt(1));
				Customer cus = new Customer();
				cus.setCusId(rs.getInt(2));
				ord.setOrdDate(rs.getTimestamp(3));
				ord.setOrdState(rs.getLong(4));
				ord.setOrdAddress(rs.getString(5));
				list.add(ord);
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
}

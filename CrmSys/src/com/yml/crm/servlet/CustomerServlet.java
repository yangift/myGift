package com.yml.crm.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.CustomerDao;
import com.yml.crm.dao.impl.CustomerDaoImpl;
import com.yml.crm.domain.Area;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.CustomerRank;
import com.yml.crm.domain.SalChance;
import com.yml.crm.util.Page;
import com.yml.crm.util.UtilTools;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String forward = "cst_info.jsp";
		CustomerDao dao = new CustomerDaoImpl();
		if ("query".equals(flag)) {
			String cusName = request.getParameter("cusName");
			String cusAddress = request.getParameter("cusAddress");
			String cusNumber = request.getParameter("cusNumber");
			String sql = "";
			if (cusName != null && !"".equals(cusName)) {
				sql = sql + " and cus_Name like '%" + cusName + "%' ";
			}
			if (cusAddress != null && !"".equals(cusAddress)) {
				sql = sql + " and cus_Address like '%" + cusAddress + "%' ";
			}
			if (cusNumber != null && !"".equals(cusNumber)) {
				sql = sql + " and cus_Number like '%" + cusNumber + "%' ";
			}

			List<Customer> list = dao.getCustomerByWhere(sql);
			//System.out.println("list="+list.get(0).getCusAddress());
			list = Page.paging(request, list);
			request.setAttribute("cusList", list);
		}else if("initEdit".equals(flag)){//初始化cst_infoEdit.jsp
			//System.out.println("chcid="+request.getParameter("chcId"));
			int cusId = Integer.parseInt(request.getParameter("cusId"));
			Customer cus = dao.getCustomerById(cusId);
			//System.out.println("sal="+sal.getChcCreateName());
			request.setAttribute("cus", cus);
			forward = "cst_infoEdit.jsp";			
		}else if("update".equals(flag)){
			System.out.println("ok");
		    Customer cus = packgeCus(request);
		    Customer oldCus = dao.getCustomerById(cus.getCusId());
		    oldCus.setCusNumber(cus.getCusNumber());
		    oldCus.setCusName(cus.getCusName());
			Area area = new Area();
			area.setAreId(Integer.parseInt(request.getParameter("areId")));
			oldCus.setArea(area);
			//System.out.println("****************"+oldCus.getArea().getAreId());
			oldCus.setCusManager(cus.getCusManager());
			CustomerRank customerRank = new CustomerRank();
			customerRank.setCkId(Integer.parseInt(request.getParameter("ckId")));
			oldCus.setCustomerRank(customerRank);
			oldCus.setCusStatisfcing(cus.getCusStatisfcing());
			oldCus.setCusCreditworthiness(cus.getCusCreditworthiness());
			oldCus.setCusAddress(cus.getCusAddress());
			oldCus.setCusPostalCode(cus.getCusPostalCode());
			oldCus.setCusTelephone(cus.getCusTelephone());
			oldCus.setCusFasimile(cus.getCusFasimile());
			oldCus.setCusUrl(cus.getCusUrl());
			oldCus.setCusRegisterNumber(cus.getCusRegisterNumber());
			oldCus.setCusLegalPerson(cus.getCusLegalPerson());
			oldCus.setCusRegisterMoney(cus.getCusRegisterMoney());
			oldCus.setCusRmb(cus.getCusRmb());
			oldCus.setCusOpeningBank(cus.getCusOpeningBank());
			oldCus.setCusBankAccount(cus.getCusBankAccount());
		    dao.update(oldCus);
		    List<Customer> list = dao.getCustomerByWhere("");
    		list = Page.paging(request, list);
			request.setAttribute("cus", oldCus);
			forward = "cst_infoEdit.jsp";	
	   }else if("queryLost".equals(flag)) {//未写完
			String cusName = request.getParameter("cusName");
			String cusAddress = request.getParameter("cusAddress");
			String cusNumber = request.getParameter("cusNumber");
			String sql = "";
			if (cusName != null && !"".equals(cusName)) {
				sql = sql + " and cus_Name like '%" + cusName + "%' ";
			}
			if (cusAddress != null && !"".equals(cusAddress)) {
				sql = sql + " and cus_Address like '%" + cusAddress + "%' ";
			}
			if (cusNumber != null && !"".equals(cusNumber)) {
				sql = sql + " and cus_Number like '%" + cusNumber + "%' ";
			}

			List<Customer> list = dao.getCustomerByWhere(sql);
			//System.out.println("list="+list.get(0).getCusAddress());
			list = Page.paging(request, list);
			request.setAttribute("cusList", list);
			forward = "cst_lostlist.jsp";
		}
		request.getRequestDispatcher(forward).forward(request,response);
	}
	public Customer packgeCus(HttpServletRequest request){
		Customer cus = new Customer();
		cus.setCusId(Integer.parseInt(request.getParameter("cusId")));
		cus.setCusNumber(request.getParameter("cusNumber"));
		cus.setCusName(request.getParameter("cusName"));		
		Area area = new Area();
		area.setAreId(Integer.parseInt(request.getParameter("areId")));
		cus.setArea(area);
		cus.setCusManager(request.getParameter("cusManager"));
		CustomerRank customerRank = new CustomerRank();
		customerRank.setCkId(Integer.parseInt(request.getParameter("ckId")));
		cus.setCustomerRank(customerRank);
		cus.setCusStatisfcing(UtilTools.StringToLong(request.getParameter("cusStatisfcing")));
		cus.setCusCreditworthiness(UtilTools.StringToLong(request.getParameter("cusCreditworthiness")));
		cus.setCusAddress(request.getParameter("cusAddress"));
		cus.setCusPostalCode(request.getParameter("cusPostalCode"));
		cus.setCusTelephone(request.getParameter("cusTelephone"));
		cus.setCusFasimile(request.getParameter("cusFasimile"));
		cus.setCusUrl(request.getParameter("cusUrl"));
		cus.setCusRegisterNumber(request.getParameter("cusRegisterNumber"));
		cus.setCusLegalPerson(request.getParameter("cusLegalPerson"));
		cus.setCusRegisterMoney(Double.parseDouble(request.getParameter("cusRegisterMoney")));
		cus.setCusRmb(Double.parseDouble(request.getParameter("cusRmb")));
		cus.setCusOpeningBank(request.getParameter("cusOpeningBank"));
		cus.setCusBankAccount(request.getParameter("cusBankAccount"));
		return cus;	
	}
}

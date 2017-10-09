package com.yml.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.CustomerDao;
import com.yml.crm.dao.LinkmanDao;
import com.yml.crm.dao.SalChanceDao;
import com.yml.crm.dao.impl.CustomerDaoImpl;
import com.yml.crm.dao.impl.LinkmanDaoImpl;
import com.yml.crm.dao.impl.SalChanceDaoImpl;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Linkman;
import com.yml.crm.domain.SalChance;
import com.yml.crm.util.Page;

public class LinkmanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String forward = "cst_linkmanlist.jsp";
		LinkmanDao dao = new LinkmanDaoImpl();
		String cusId = request.getParameter("cusId");
		//System.out.println("cusId="+cusId);
		if ("query".equals(flag)) {//查询还未指派的客户信息
			CustomerDao daoCus = new CustomerDaoImpl();
			Customer cus = daoCus.getCustomerById(Integer.parseInt(cusId));
			List<Linkman> list = dao.getLinkmanByWhere(" and cus_id="+cusId);
			list = Page.paging(request, list);
			request.setAttribute("linList", list);
			request.setAttribute("cus", cus);
			forward = "cst_linkmanlist.jsp";
		}else if("add".equals(flag)){
			//保存
			Linkman lin = new Linkman();
			String linName = request.getParameter("linName");
			String linSex = request.getParameter("linSex");
			String linPost = request.getParameter("linPost");
			String linTelephone = request.getParameter("linTelephone");
			String linMobile = request.getParameter("linMobile");
			String linMemo = request.getParameter("linMemo");
			//int cusId = Integer.parseInt(request.getParameter("cusId"));
			lin.setLinName(linName);
			lin.setLinSex(linSex);
			lin.setLinPost(linPost);
			lin.setLinTelephone(linTelephone);
			lin.setLinMobile(linMobile);
			lin.setLinMemo(linMemo);
			Customer cus = new Customer();
			cus.setCusId(Integer.parseInt(cusId));
			lin.setCustomer(cus);
			System.out.println("cusId="+cusId);
			dao.save(lin);
			forward = "linkman?flag=query&cusId="+cusId;
		}else if("initEdit".equals(flag)){
			//System.out.println("chcid="+request.getParameter("chcId"));
			int linId = Integer.parseInt(request.getParameter("linId"));
			Linkman lin = dao.getLinkmanById(linId);
			//System.out.println("sal="+sal.getChcCreateName());
			request.setAttribute("cusId", request.getParameter("cusId"));
			request.setAttribute("lin", lin);
			forward = "cst_linkmanEdit.jsp";			
		}else if("update".equals(flag)){
			//System.out.println("ok");
			System.out.println("***********"+cusId);
			int linId = Integer.parseInt(request.getParameter("linId"));
			String linName = request.getParameter("linName");
			String linSex = request.getParameter("linSex");
			String linPost = request.getParameter("linPost");
			String linTelephone = request.getParameter("linTelephone");
			String linMobile = request.getParameter("linMobile");
			String linMemo = request.getParameter("linMemo");
		    Linkman lin = dao.getLinkmanById(linId);
		    lin.setLinName(linName);
		    lin.setLinSex(linSex);
		    lin.setLinPost(linPost);
		    lin.setLinTelephone(linTelephone);
		    lin.setLinMobile(linMobile);
		    lin.setLinMemo(linMemo);;
		    dao.update(lin);
		    forward = "linkman?flag=query&cusId="+cusId;
	   }
		request.getRequestDispatcher(forward).forward(request, response);
	}
	
}

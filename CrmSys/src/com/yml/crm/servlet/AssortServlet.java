package com.yml.crm.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.AssortDao;
import com.yml.crm.dao.CustomerDao;
import com.yml.crm.dao.LinkmanDao;
import com.yml.crm.dao.impl.AssortDaoImpl;
import com.yml.crm.dao.impl.CustomerDaoImpl;
import com.yml.crm.dao.impl.LinkmanDaoImpl;
import com.yml.crm.domain.Assort;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Linkman;
import com.yml.crm.util.Page;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月13日
 *类说明：
 */
public class AssortServlet extends HttpServlet{
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
		String forward = "cst_assortlist.jsp";
		AssortDao dao = new AssortDaoImpl();
		String cusId = request.getParameter("cusId");
		//System.out.println("cusId="+cusId);
		if ("query".equals(flag)) {//查询还未指派的客户信息
			CustomerDao daoCus = new CustomerDaoImpl();
			Customer cus = daoCus.getCustomerById(Integer.parseInt(cusId));
			List<Assort> list = dao.getAssortByWhere(" and cus_id="+cusId);
			list = Page.paging(request, list);
			request.setAttribute("assList", list);
			request.setAttribute("cus", cus);
		}else if("add".equals(flag)){
			//保存
			Assort ass = new Assort();
			String assDate = request.getParameter("assDate");
			//System.out.println("assDate="+assDate);
			String assPalce = request.getParameter("assPalce");
			String assResume = request.getParameter("assResume");
			String assMemo = request.getParameter("assMemo");
			String assDetal = request.getParameter("assDetal");
			//int cusId = Integer.parseInt(request.getParameter("cusId"));
			ass.setAssDate(Timestamp.valueOf(assDate+" 00:00:00"));
			ass.setAssPalce(assPalce);
			ass.setAssResume(assResume);
			ass.setAssMemo(assMemo);
			ass.setAssDetail(assDetal);
			Customer cus = new Customer();
			cus.setCusId(Integer.parseInt(cusId));
			ass.setCustomer(cus);
			dao.save(ass);
			forward = "assort?flag=query&cusId="+cusId;
		}else if("initEdit".equals(flag)){
			//System.out.println("chcid="+request.getParameter("chcId"));
			int assId = Integer.parseInt(request.getParameter("assId"));
			Assort ass = dao.getAssortById(assId);
			//System.out.println("sal="+sal.getChcCreateName());
			request.setAttribute("cusId", request.getParameter("cusId"));
			request.setAttribute("ass", ass);
			forward = "cst_assortEdit.jsp";			
		}else if("update".equals(flag)){
			//System.out.println("ok");
			//System.out.println("***********"+cusId);
			int assId = Integer.parseInt(request.getParameter("assId"));
			System.out.println("assId**********="+assId);
			String assDate = request.getParameter("assDate");
			//System.out.println("assDate="+assDate);
			String assPalce = request.getParameter("assPalce");
			String assResume = request.getParameter("assResume");
			String assMemo = request.getParameter("assMemo");
			String assDetal = request.getParameter("assDetal");
		    Assort ass = dao.getAssortById(assId);
		    ass.setAssDate(Timestamp.valueOf(assDate));
			ass.setAssPalce(assPalce);
			ass.setAssResume(assResume);
			ass.setAssMemo(assMemo);
			ass.setAssDetail(assDetal);
		    dao.update(ass);
		    forward = "linkman?flag=query&cusId="+cusId;
	   }
		request.getRequestDispatcher(forward).forward(request, response);
	}
	
}

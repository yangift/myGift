package com.yml.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.count.dao.countDao;
import com.yml.crm.count.dao.impl.countDaoImpl;
import com.yml.crm.domain.*;


/**
 * Servlet implementation class CountDevote
 */
public class CountDevote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		System.out.println("flag="+flag);
		countDao dao = new countDaoImpl();
		String forward = "count_consist.jsp";
		String sql = "";
		//System.out.println("cstname="+cstname+"     year="+year);
		if("query".equals(flag)){
			String cstname = request.getParameter("cstname");
			String year = request.getParameter("year");
			//System.out.println("cstname="+cstname+"      year="+year);
			if(cstname!=null&&!"".equals(cstname)){
				sql=sql+"and chc_cust_name like '%"+cstname+"%'";	
			}
			if("全部".equals(year)){
				
				sql="";
			}else if(year!=null&&!"全部".equals(year)){
				
				sql=sql+"and ORD_DATE like '"+year+"%'";
			}
			List<Orders> list = dao.getOrdersByWhere(sql);
			System.out.println("list.get(0)"+list.get(0).getOrdId());
			//System.out.println("servlet"+list.get(0).toString());
			request.setAttribute("list", list);
		}
		if("consist".equals(flag)){
			List<Customer> list = new ArrayList<Customer>();
			//System.out.println("consist");
			String way = request.getParameter("way");
			System.out.println("consistWay="+way);
			sql="ck_name";
			if("按等级".equals(way)){
				sql="ck_name";
			}
			if("按信用".equals(way)){
				sql="cus_creditworthiness";
			}
			if("按满意度".equals(way)){
				sql="CUS_STATISFCING";
			}
			list = dao.getCustomerByWhere(sql);
			String count = dao.Count(sql);
			System.out.println("list="+list.size()+"    count="+count);
			request.setAttribute("sql", sql);
			request.setAttribute("list", list);
			request.setAttribute("count", count);
		}
		if("countserve".equals(flag)){
			String year = request.getParameter("year");
			if("全部".equals(year)||year==null){
				year = "";
			}
			//System.out.println("year="+year);
			sql = "ser_creater_date like '"+year+"%'";
			List<Serve> list = dao.getServeByWhere(sql);
			request.setAttribute("list", list);
			//System.out.println("list="+list.get(0).getServeType().getSeName());
			forward="count_serve.jsp";
		}
		if("countWastage".equals(flag)){
			//System.out.print("nihaoa najing ");
			String cstname = request.getParameter("cstname");
			String cstmanager = request.getParameter("cstmanager");
			System.out.println("客户名称="+cstname+"     客户经理="+cstmanager);
			if(cstname!=null&&!"".equals(cstname)){
				System.out.println("客户名称");
				sql = "and los_customer like '%"+cstname+"%';";
			}
			if(cstmanager!=null&&!"".equals(cstmanager)){
				System.out.println("客户经理");
				sql = "and los_manager like '%"+cstmanager+"%';";
			}
			List<Lost> list = dao.getWastageByWhere(sql);
			//System.out.println("sevlert="+list.size());
			request.setAttribute("list", list);
			forward = "count_wastage.jsp";
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

}

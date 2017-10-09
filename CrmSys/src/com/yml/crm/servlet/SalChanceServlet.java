package com.yml.crm.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.ConsumerDao;
import com.yml.crm.dao.SalChanceDao;
import com.yml.crm.dao.impl.ConsumerDaoImpl;
import com.yml.crm.dao.impl.SalChanceDaoImpl;
import com.yml.crm.domain.Consumer;
import com.yml.crm.domain.SalChance;
import com.yml.crm.util.Page;
import com.yml.crm.util.UtilTools;

public class SalChanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String forward = "sal_chance.jsp";
		SalChanceDao dao = new SalChanceDaoImpl();
		if ("query".equals(flag)) {//查询还未指派的客户信息
			String chcCustName = request.getParameter("chc_cust_name");
			String chcTitle = request.getParameter("chc_title");
			String chcLinkman = request.getParameter("chc_linkman");
			String sql = "";
			if (chcCustName != null && !"".equals(chcCustName)) {
				sql = sql + " and chc_cust_name like '%" + chcCustName + "%' ";
			}
			if (chcTitle != null && !"".equals(chcTitle)) {
				sql = sql + " and chc_title like '%" + chcTitle + "%' ";
			}
			if (chcLinkman != null && !"".equals(chcLinkman)) {
				sql = sql + " and chc_link_man like '%" + chcLinkman + "%' ";
			}

			List<SalChance> list = dao.getSalChancesByWhere(sql+" and chc_status='未分配'");
			list = Page.paging(request, list);
			request.setAttribute("salList", list);
		}else if("add".equals(flag)){
			//保存
			SalChance sal = packgeSal(request);
	        System.out.println("sal="+sal.toString());
			dao.save(sal);
			List<SalChance> list = dao.getSalChancesByWhere(" and chc_status='未分配'");	
			list = Page.paging(request, list);
			System.out.println("list="+ list);
			request.setAttribute("salList", list);
		}else if("initEdit".equals(flag)){
			//System.out.println("chcid="+request.getParameter("chcId"));
			String chcId = request.getParameter("chcId");
			SalChance sal = dao.getSalChanceById(Long.valueOf(chcId));
			//System.out.println("sal="+sal.getChcCreateName());
			request.setAttribute("sal", sal);
			forward = "sal_chanceEdit.jsp";			
		}else if("update".equals(flag)){
			System.out.println("ok");
		    SalChance sal = packgeSal(request);
		    SalChance oldSal = dao.getSalChanceById(sal.getChcId());
		    oldSal.setChcSource(sal.getChcSource());
		    oldSal.setChcCustName(sal.getChcCustName());
		    oldSal.setChcDesc(sal.getChcDesc());
		    oldSal.setChcLinkman(sal.getChcLinkman());
		    oldSal.setChcTel(sal.getChcTel());
		    oldSal.setChcTitle(sal.getChcTitle());
		    oldSal.setChcRate(sal.getChcRate());
		    dao.update(oldSal);
		    List<SalChance> list = dao.getSalChancesByWhere(" and chc_status='未分配'");	
    		list = Page.paging(request, list);
			request.setAttribute("sal", oldSal);
			forward = "sal_chanceEdit.jsp";	
	   }else if("del".equals(flag)){
		  // System.out.println("开始删除");
		   long id = UtilTools.StringToLong(request.getParameter("chcId"));
		   dao.delSalChanceById(id);
		   List<SalChance> list = dao.getSalChancesByWhere(" and chc_status='未分配'");	
   			list = Page.paging(request, list);
   			forward = "sal_index.jsp";	
	   }else if("due".equals(flag)){
			//System.out.println("chcid="+request.getParameter("chcId"));
			String chcId = request.getParameter("chcId");
			SalChance sal = dao.getSalChanceById(Long.valueOf(chcId));
			//System.out.println("sal="+sal.getChcCreateName());
			//从ConsumerDao读出销售主管，销售主管的rol_id是2
			ConsumerDao condao = new ConsumerDaoImpl();
			List<Consumer> listConsumer = condao.getConsumerByWhere(" and rol_id = 2");
			request.setAttribute("listConsumer", listConsumer);
			request.setAttribute("sal", sal);
			forward = "sal_chanceDue.jsp";			
		}else if("addDue".equals(flag)){
			ConsumerDao condao = new ConsumerDaoImpl();
			
			SalChance sal = packgeSal(request);
			String conName = request.getParameter("ChcDueName");
			Consumer consumer = condao.getConsumerByName(conName);
			sal.setChcDueName(request.getParameter("ChcDueName"));
			sal.setChcDueDate(Timestamp.valueOf(request.getParameter("chcDueDate")));
			SalChance oldSal = dao.getSalChanceById(sal.getChcId());
		    oldSal.setChcSource(sal.getChcSource());
		    oldSal.setChcCustName(sal.getChcCustName());
		    oldSal.setChcDesc(sal.getChcDesc());
		    oldSal.setChcLinkman(sal.getChcLinkman());
		    oldSal.setChcTel(sal.getChcTel());
		    oldSal.setChcTitle(sal.getChcTitle());
		    oldSal.setChcRate(sal.getChcRate());
		    oldSal.setChcDueName(sal.getChcDueName());
		    oldSal.setChcDueDate(sal.getChcDueDate());
		    oldSal.setChcStatus("已分配");
		    oldSal.setChcDueId(consumer.getConId());
		    dao.update(oldSal);
		    List<SalChance> list = dao.getSalChancesByWhere(" and chc_status='未分配'");	
    		list = Page.paging(request, list);		
			List<Consumer> listConsumer = condao.getConsumerByWhere(" and rol_id = 2");
			request.setAttribute("listConsumer", listConsumer);
			request.setAttribute("sal", oldSal);
			forward = "sal_chanceDue.jsp";	
		}else if ("queryPlan".equals(flag)) {//查询还未指派的客户信息
			String chcCustName = request.getParameter("chc_cust_name");
			String chcTitle = request.getParameter("chc_title");
			String chcLinkman = request.getParameter("chc_linkman");
			String sql = "";
			if (chcCustName != null && !"".equals(chcCustName)) {
				sql = sql + " and chc_cust_name like '%" + chcCustName + "%' ";
			}
			if (chcTitle != null && !"".equals(chcTitle)) {
				sql = sql + " and chc_title like '%" + chcTitle + "%' ";
			}
			if (chcLinkman != null && !"".equals(chcLinkman)) {
				sql = sql + " and chc_link_man like '%" + chcLinkman + "%' ";
			}

			List<SalChance> list = dao.getSalChancesByWhere(sql+" and chc_status='已分配' or chc_status = '开发成功' or chc_status = '开发失败'");
			list = Page.paging(request, list);
			request.setAttribute("salList", list);
			forward="sal_plan.jsp";
		}	
		request.getRequestDispatcher(forward).forward(request,response);
	}
	public SalChance packgeSal(HttpServletRequest request){
		SalChance sal = new SalChance();
	   
		sal.setChcId(UtilTools.StringToLong(request.getParameter("chcId")));//
		sal.setChcSource(request.getParameter("chcSource"));
		sal.setChcCreateId(UtilTools.StringToInt(request.getParameter("chcCreateId")));//
		sal.setChcCreateName(request.getParameter("chcCreateName"));
		sal.setChcCreateDate(Timestamp.valueOf(request.getParameter("chcCreateDate")));
		sal.setChcCustName(request.getParameter("chcCustName"));
		sal.setChcTitle(request.getParameter("chcTitle"));
		sal.setChcRate(UtilTools.StringToInt(request.getParameter("chcRate")));
		sal.setChcLinkman(request.getParameter("chcLinkman"));
		sal.setChcTel(request.getParameter("chcTel"));
		sal.setChcDesc(request.getParameter("chcDesc"));	
		sal.setChcStatus("未分配");			
		return sal;	
	}
}

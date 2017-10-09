package com.yml.crm.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.ConsumerDao;
import com.yml.crm.dao.PlanDao;
import com.yml.crm.dao.SalChanceDao;
import com.yml.crm.dao.impl.ConsumerDaoImpl;
import com.yml.crm.dao.impl.PlanDaoImpl;
import com.yml.crm.dao.impl.SalChanceDaoImpl;
import com.yml.crm.domain.Consumer;
import com.yml.crm.domain.Plan;
import com.yml.crm.domain.SalChance;
import com.yml.crm.util.Page;
import com.yml.crm.util.UtilTools;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月8日
 *类说明：
 */
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String forward = "sal_plan.jsp";
		PlanDao dao = new PlanDaoImpl();
		SalChanceDao daoSal = new SalChanceDaoImpl();
		if("initEdit".equals(flag)){//初始化客户
			int chcId = UtilTools.StringToInt(request.getParameter("chcId"));
			//System.out.println("chcId="+chcId);
			SalChance oldSal = daoSal.getSalChanceById(UtilTools.StringToLong(request.getParameter("chcId")));
			List<SalChance> list = daoSal.getSalChancesByWhere(" and chc_status='已分配' or chc_status = '开发成功' or chc_status = '开发失败'");
			//list = Page.paging(request, list);
			//查找plan
			List<Plan> planList = dao.getPlanByWhere(" and pla_chc_id = "+chcId);
			request.setAttribute("planList", planList);
			request.setAttribute("salList", list);
			request.setAttribute("sal", oldSal);
			forward="sal_planEdit.jsp";
		}else if("add".equals(flag)){
			Plan plan =new Plan();
			String plaDate = request.getParameter("plaDate");
			String plaPlan = request.getParameter("plaPlanAdd");
			int plaChcId = Integer.parseInt(request.getParameter("plaChcId"));
			plan.setPlaDate(Timestamp.valueOf(plaDate));
			plan.setPlaPlan(plaPlan);
			plan.setPlaChcId(plaChcId);
			dao.save(plan);
			SalChance oldSal = daoSal.getSalChanceById(plaChcId);
			List<SalChance> list = daoSal.getSalChancesByWhere(" and chc_status='已分配' or chc_status = '开发成功' or chc_status = '开发失败'");
			
			//list = Page.paging(request, list);
			//查找plan
			List<Plan> planList = dao.getPlanByWhere(" and pla_chc_id = "+plaChcId);
			request.setAttribute("planList", planList);
			request.setAttribute("salList", list);
			request.setAttribute("sal", oldSal);
			forward="sal_planEdit.jsp";
		}else if("update".equals(flag)){
			Plan plan =new Plan();
			String plaDate = request.getParameter("plaDate");
			String plaPlan = request.getParameter("plaPlan");
			String plaResult = request.getParameter("plaResult");
			//System.out.println("plaPlan="+plaPlan);
			System.out.println("plaChcId="+request.getParameter("plaChcId"));
			int plaChcId = Integer.parseInt(request.getParameter("plaChcId"));
			plan.setPlaDate(Timestamp.valueOf(plaDate));
			plan.setPlaPlan(plaPlan);
			plan.setPlaChcId(plaChcId);
			plan.setPlaResult(plaResult);
			dao.update(plan);
		}else if("del".equals(flag)){
			  // System.out.println("开始删除");
			   int planid = Integer.parseInt(request.getParameter("plaId"));
			   System.out.println(planid);
			   dao.delById(planid);			   
		   }else if("sus".equals(flag)){
			   SalChance sal = packgeSal(request);
			    SalChance oldSal = daoSal.getSalChanceById(sal.getChcId());
			    String chcStatus = "";
			    if("1".equals(sal.getChcStatus())){
			    	 chcStatus = "开发成功";
			    }else if("2".equals(sal.getChcStatus())){
			    	 chcStatus = "开发失败";
			    }
			    oldSal.setChcStatus(chcStatus);
			    daoSal.updatechcStatus(oldSal);
				request.setAttribute("sal", oldSal);
				forward = "salchance?flag=queryPlan";	
		   }
		request.getRequestDispatcher(forward).forward(request,response);
	}
	public SalChance packgeSal(HttpServletRequest request){
		SalChance sal = new SalChance();
	   
		sal.setChcId(UtilTools.StringToLong(request.getParameter("chcId")));//
		
		sal.setChcStatus(request.getParameter("chcStatus"));			
		return sal;	
	}
}

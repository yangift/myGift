package com.yml.crm.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.ConsumerDao;
import com.yml.crm.dao.CustomerDao;
import com.yml.crm.dao.ServeDao;
import com.yml.crm.dao.impl.ConsumerDaoImpl;
import com.yml.crm.dao.impl.CustomerDaoImpl;
import com.yml.crm.dao.impl.ServeDaoImpl;
import com.yml.crm.domain.Consumer;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Serve;

public class SerAllotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SerAllotServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("query")) {
			String chcCustName = request.getParameter("chcCustName");
			String datetime = request.getParameter("datetime");			
			String state = request.getParameter("state");
			String resume = request.getParameter("resume");
			String sertype = request.getParameter("sertype");
			String where = "";
			ConsumerDao consumerdao = new ConsumerDaoImpl();
			ServeDao servedao = new ServeDaoImpl();
			if(chcCustName!=null&&!chcCustName.equals("")){
				where = where + " and cus.cus_name like '%"+chcCustName+"%'";
			}else if(datetime!=null&&!datetime.equals("")){
				where = where + " and ser.SER_CREATER_DATE like '%"+datetime+"%'"; 
			}else if(resume!=null&&!resume.equals("")){
				where = where + " and ser.SER_RESUME like '%"+resume+"%'";
			}			
				where = where + " and  ser.SER_STATE = '"+state+"'" + " and se.se_name = '"+sertype+"'";
				List<Serve> list = servedao.getListByWhere(where);
				List<Consumer> conlist = consumerdao.getConsumerByWhere("");
				System.out.println(datetime);
				request.setAttribute("list", list);
				request.setAttribute("conlist", conlist);
				request.getRequestDispatcher("ser_allot.jsp").forward(request, response);
			}
		if(flag.equals("update")){
			String consumer = request.getParameter("consumer");
			String serid = request.getParameter("serid");			
			ServeDao servedao  = new ServeDaoImpl();
			String datetime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
			long l = 2;
			Serve serve = new Serve();
			serve.setSerAllotDate(Timestamp.valueOf(datetime));
			serve.setSerId(Integer.valueOf(serid));
			serve.setSerAllotName(consumer);
			serve.setSerState(l);
			servedao.updateServeDao(serve);
			
			request.getRequestDispatcher("ser_allot.jsp").forward(request, response);
		}

		}

	}



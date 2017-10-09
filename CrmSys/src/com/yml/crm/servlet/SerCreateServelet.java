package com.yml.crm.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yml.crm.dao.CustomerDao;
import com.yml.crm.dao.ServeDao;
import com.yml.crm.dao.impl.CustomerDaoImpl;
import com.yml.crm.dao.impl.ServeDaoImpl;
import com.yml.crm.domain.Customer;
import com.yml.crm.domain.Serve;
import com.yml.crm.domain.ServeType;


public class SerCreateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SerCreateServelet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if(flag.equals("customer")){
			CustomerDao cusdao = new CustomerDaoImpl();
			List<Customer> list =cusdao.getCustomerByWhere("");
			request.setAttribute("cuslist", list);
			request.getRequestDispatcher("ser_create.jsp").forward(request, response);
			
		}
		if(flag.equals("input")){
			
			String sertype = request.getParameter("sertype");
			String title = request.getParameter("title");
			String customer = request.getParameter("customer");
			long state = Long.parseLong(request.getParameter("state"));
			String serrequest = request.getParameter("serrequest");
			String crename = request.getParameter("crename");
			String credate = request.getParameter("credate");
			Serve serve = new Serve();
			ServeType servetype = new ServeType();
			servetype.setSeId(Integer.valueOf(sertype));
			serve.setServeType(servetype);
			Customer sercustomer = new Customer();
			sercustomer.setCusId(Integer.valueOf(customer));
			serve.setCustomer(sercustomer);
			serve.setSerState(state);
			serve.setSerResume(title);
			serve.setSerServiceRequest(serrequest);
			serve.setSerCreater(crename);
			serve.setSerCreaterDate(Timestamp.valueOf(credate));
			ServeDao servedao = new ServeDaoImpl();
			servedao.inputServe(serve);
			response.sendRedirect("ser_create.jsp");
		}
	}

}

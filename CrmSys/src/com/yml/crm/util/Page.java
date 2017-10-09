package com.yml.crm.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 *@author 作者： YangLin
 *@version 创建时间： 2017年9月7日
 *类说明：
 */
public class Page {
	public  static List paging(HttpServletRequest request, List list){
		 
		List subMessList=null; //这个到时候存的是用分页技术之后的要显示的记录
        int showCount =5; //每页显示的记录数。
        int showPage = 1; //当前显示页码数。
        int size =list.size(); //所取得的数据的总条数。
        int pageCount = (size-1)/showCount + 1; //需要显示的总页数
        if(size<showCount)
        {
           subMessList = list;
         }
        String page = request.getParameter("page");
        if(page != null)
        { 
           showPage = Integer.parseInt(page);
           if(showPage<=0){
        	   showPage=1;
           }
        }
        if((showPage*showCount)<size)
        {
           subMessList = list.subList((showPage-1)*showCount,showPage*showCount);
         }
        else
       {
           subMessList=list.subList((showPage-1)*showCount,size);
        }
           request.setAttribute("showPage",new Integer(showPage));
           //System.out.println("showPage = "+showPage);
           request.setAttribute("pageCount",new Integer(pageCount));
           request.setAttribute("size",new Integer(size));
           return subMessList;
	}
}

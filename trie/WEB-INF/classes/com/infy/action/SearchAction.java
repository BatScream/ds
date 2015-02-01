package com.infy.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.infy.util.SearchClient;

public class SearchAction extends DispatchAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	
		String query = request.getParameter("key");
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		SearchClient client = new SearchClient();
		List<String> fileNames = (List<String>) request.getSession().getAttribute("fileNames");
		client.createRepository(fileNames);
		String results = client.getCombinations(query);
		PrintWriter out = response.getWriter();
	    out.println(results);
	    out.flush();
		return null;
	}
}

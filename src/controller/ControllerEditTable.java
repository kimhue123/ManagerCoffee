package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Table;
import bo.TableBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TableBo tableBo = new TableBo();

		if (request.getParameter("submit") != null) {

			int tid = Integer.parseInt(request.getParameter("tid"));
			int status =0;
			String name_table = new String(request.getParameter("nameTable").getBytes("ISO-8859-1"), "UTF-8");
			if(request.getParameter("status")!=null){
				status= Integer.parseInt(request.getParameter("status"));
			}
			 

			Table objTable = new Table(tid, 1, name_table, status);
			
			int result = tableBo.editItem(objTable);
			if (result > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/indexTable?msg=1");
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/indexTable?msg=0");
			}

		} else {
			int taId = Integer.parseInt(request.getParameter("tid"));
			Table table = tableBo.getItemById(taId);
			request.setAttribute("objTable", table);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editTable.jsp");
			rd.forward(request, response);
		}
	}
}

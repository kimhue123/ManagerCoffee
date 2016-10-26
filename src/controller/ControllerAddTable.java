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

public class ControllerAddTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableBo tableBo = new TableBo();
		if(request.getParameter("submit")!= null){// dang nhan nut submit
			 
			String name_table  =new String( request.getParameter("nameTable").getBytes("ISO-8859-1"),"UTF-8");
			Table table = new Table(0,1, name_table, 0);
			
			int result = tableBo.addItem(table);
			if(result >0){
				System.out.println("1");
				response.sendRedirect(request.getContextPath()+"/admin/indexTable?msg=1");
			}else{
				System.out.println("0");
				response.sendRedirect(request.getContextPath()+"/admin/indexTable?msg=0");
			}
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addTable.jsp");
			rd.forward(request, response);
		}
	}
	
}

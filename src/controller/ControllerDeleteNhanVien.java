package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NhanVienBo;

/**
 * Servlet implementation class DeleteNhanVienController
 */
//@WebServlet("/DeleteNhanVienController")
public class ControllerDeleteNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDeleteNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idNhanVien= Integer.parseInt(request.getParameter("idNhanVien")+"");
		System.out.println(idNhanVien+"---------");
		if(NhanVienBo.getInstance().delItem(idNhanVien)){
			response.sendRedirect(request.getContextPath() + "admin/listNhanVien");
		}
		else{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/danh-sach-nhan-vien.jsp");
			dispatcher.forward(request, response);
		}
	}
}

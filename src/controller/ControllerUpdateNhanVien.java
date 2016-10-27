package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NhanVien;
import bo.NhanVienBo;

/**
 * Servlet implementation class ShowUpdateNhanVienController
 */
//@WebServlet("/ShowUpdateNhanVienController")
public class ControllerUpdateNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUpdateNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNhanVien=Integer.parseInt(""+request.getParameter("idNhanVien"));
		//System.out.println(idNhanVien);
		NhanVien nhanVien = NhanVienBo.getInstance().getItemById(idNhanVien);
		request.setAttribute("nhanVien", nhanVien);
		//System.out.println(nhanVien.getNgaySinh());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/chinh-sua-nhan-vien.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
	}

}

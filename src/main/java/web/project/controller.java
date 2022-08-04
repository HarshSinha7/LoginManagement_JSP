package web.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;


@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Resource(name="jdbc/project")
       public DataSource source;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
		PreparedStatement ps;
		try {
			Connection con=source.getConnection();
			ps=con.prepareStatement("select*from login where id=? and password=?");
			ps.setString(1,request.getParameter("id"));
			ps.setString(2,request.getParameter("password"));
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter() ;
			if(rs.isBeforeFirst()){
				while(rs.next()){
					String id=rs.getString(1);
					String password=rs.getString(2);
					request.getSession().invalidate();
					HttpSession sess=request.getSession(true);
					sess.setMaxInactiveInterval(300);
					sess.setAttribute("id",id);
					sess.setAttribute("pass",password);
					
					response.sendRedirect("controller2.jsp");
					
					
					}
				}else{
					response.sendRedirect("eroor.jsp");
			}
		}
			
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

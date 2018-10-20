

import java.io.IOException;

import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckStudent
 */
public class CheckStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system", "root", "root");
			PreparedStatement ps=conn.prepareStatement("SELECT pass FROM student_uname_pass WHERE uname=?");
			ps.setInt(1, Integer.parseInt(request.getParameter("s_uname")));
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(request.getParameter("s_pass"))) {
					HttpSession s=request.getSession();
					s.setAttribute("u_id", request.getParameter("s_uname"));
					response.sendRedirect("StudentLabEntry.html");}
				else
					response.sendRedirect("Error.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

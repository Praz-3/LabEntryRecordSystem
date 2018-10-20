

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;

/**
 * Servlet implementation class PutStudentInfo
 */
public class PutStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system", "root", "root");
			PreparedStatement ps=conn.prepareStatement("INSERT INTO student_info VALUES (?,?,?,?,?,?);");
			ps.setInt(1, Integer.parseInt(request.getParameter("u_id")));
			ps.setString(2, request.getParameter("s_name"));
			ps.setString(3, request.getParameter("s_class"));
			ps.setString(4, request.getParameter("branch"));
			ps.setInt(5, Integer.parseInt(request.getParameter("roll_no")));
			ps.setString(6, request.getParameter("batch"));
			ps.executeUpdate();
			PreparedStatement ps2=conn.prepareStatement("INSERT INTO student_uname_pass VALUES (?,?)");
			ps2.setString(1, request.getParameter("u_id"));
			ps2.setString(2, request.getParameter("pass"));
			ps2.executeUpdate();
			conn.close();
			out.println("<html>");
			out.println("<head><title>Student Entry</title>");
			out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
			out.println("<body>");
			out.println("<br><br><br><br><br>");
			out.println("<div class=\"login-page\">");
			out.println("<div class=\"form\">");
			out.println("<form class=\"login-form\" id=\"form1\" action='OptionsLabAdmin.html'>");
			out.println("Student Entry Successfully Done!<br><br><br>");
			out.println("<button type=\"submit\" form=\"form1\">Back</button>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}catch(Exception e) {
			out.println(e);
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

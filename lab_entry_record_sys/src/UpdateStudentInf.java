

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentInf
 */
public class UpdateStudentInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentInf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system", "root", "root");
			PreparedStatement ps1=conn.prepareStatement("UPDATE student_info SET name=? WHERE u_id=?;");
			ps1.setInt(2, Integer.parseInt(request.getParameter("u_id")));
			ps1.setString(1, request.getParameter("s_name"));
			PreparedStatement ps2=conn.prepareStatement("UPDATE student_info SET class=? WHERE u_id=?;");
			ps2.setInt(2, Integer.parseInt(request.getParameter("u_id")));
			ps2.setString(1, request.getParameter("s_class"));
			PreparedStatement ps3=conn.prepareStatement("UPDATE student_info SET branch=? WHERE u_id=?;");
			ps3.setInt(2, Integer.parseInt(request.getParameter("u_id")));
			ps3.setString(1, request.getParameter("branch"));
			PreparedStatement ps4=conn.prepareStatement("UPDATE student_info SET roll_no=? WHERE u_id=?;");
			ps4.setInt(2, Integer.parseInt(request.getParameter("u_id")));
			ps4.setInt(1, Integer.parseInt(request.getParameter("roll_no")));
			PreparedStatement ps5=conn.prepareStatement("UPDATE student_info SET batch=? WHERE u_id=?;");
			ps5.setInt(2, Integer.parseInt(request.getParameter("u_id")));
			ps5.setString(1, request.getParameter("batch"));
			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3.executeUpdate();
			ps4.executeUpdate();
			ps5.executeUpdate();
			PreparedStatement ps6=conn.prepareStatement("UPDATE student_uname_pass SET pass=? WHERE uname=?");
			ps6.setString(2, request.getParameter("u_id"));
			ps6.setString(1, request.getParameter("pass"));
			ps6.executeUpdate();
			conn.close();
			out.println("<html>");
			out.println("<head><title>Student Entry</title>");
			out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
			out.println("<body>");
			out.println("<br><br><br><br><br>");
			out.println("<div class=\"login-page\">");
			out.println("<div class=\"form\">");
			out.println("<form class=\"login-form\" id=\"form1\" action='OptionsLabAdmin.html'>");
			out.println("Student Entry Successfully Updated!<br><br><br>");
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

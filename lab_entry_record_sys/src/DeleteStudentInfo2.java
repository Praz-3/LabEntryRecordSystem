

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
 * Servlet implementation class DeleteStudentInfo
 */
public class DeleteStudentInfo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentInfo2() {
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
			PreparedStatement ps=conn.prepareStatement("DELETE FROM student_info WHERE u_id=?;");
			ps.setInt(1, Integer.parseInt(request.getParameter("u_id")));
			ps.executeUpdate();
			PreparedStatement ps2=conn.prepareStatement("DELETE FROM student_uname_pass WHERE uname=?");
			ps2.setString(1, request.getParameter("u_id"));
			
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
			out.println("Student Entry Successfully Deleted!<br><br><br>");
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

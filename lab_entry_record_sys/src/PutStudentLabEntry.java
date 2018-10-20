

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PutStudentLabEntry
 */
public class PutStudentLabEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutStudentLabEntry() {
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
			HttpSession s=request.getSession(false);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system", "root", "root");
			PreparedStatement ps=conn.prepareStatement("INSERT INTO lab_entry(s_u_id,s_date,in_time,out_time,subject) VALUES (?,?,?,?,?);");
			ps.setInt(1, Integer.parseInt((String)s.getAttribute("u_id")));
			ps.setString(2, request.getParameter("s_date"));
			ps.setString(3, request.getParameter("in_time"));
			ps.setString(4,request.getParameter("out_time"));
			ps.setString(5, request.getParameter("subject"));
			ps.executeUpdate();
			conn.close();
			s.invalidate();
			out.println("<html>");
			out.println("<head><title>Student Entry</title>");
			out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
			out.println("<body>");
			out.println("<br><br><br><br><br>");
			out.println("<div class=\"login-page\">");
			out.println("<div class=\"form\">");
			out.println("<form class=\"login-form\" id=\"form1\" action='index.html'>");
			out.println("Lab Entry Successfully Done!<br><br><br>");
			out.println("<button type=\"submit\" form=\"form1\">Home</button>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
		catch(Exception e) {
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

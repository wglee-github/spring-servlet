package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ResponseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Content-Type:text/html;charset=utf-8
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println(" <div>안녕?</div>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}
}

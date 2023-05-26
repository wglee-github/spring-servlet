package hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter w = response.getWriter();
		 w.println("<html>");
		 w.println("<head>");
		 w.println(" <meta charset=\"UTF-8\">");
		 w.println(" <title>Title</title>");
		 w.println("</head>");
		 w.println("<body>");
		 w.println("<a href=\"/index.html\">메인</a>");
		 w.println("<table>");
		 w.println(" <thead>");
		 w.println(" <th>id</th>");
		 w.println(" <th>username</th>");
		 w.println(" <th>age</th>");
		 w.println(" </thead>");
		 w.println(" <tbody>");
		/*
		 w.println(" <tr>");
		 w.println(" <td>1</td>");
		 w.println(" <td>userA</td>");
		 w.println(" <td>10</td>");
		 w.println(" </tr>");
		*/
		 for (Member member : members) {
		 w.println(" <tr>");
		 w.println(" <td>" + member.getId() + "</td>");
		 w.println(" <td>" + member.getUsername() + "</td>");
		 w.println(" <td>" + member.getAge() + "</td>");
		 w.println(" </tr>");
		 }
		 w.println(" </tbody>");
		 w.println("</table>");
		 w.println("</body>");
		 w.println("</html>");
	}
}

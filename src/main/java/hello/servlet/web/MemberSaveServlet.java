package hello.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MemberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		Member saveMember = memberRepository.save(member);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter w = response.getWriter();
		w.write("<html>\n" +
				 "<head>\n" +
				 " <meta charset=\"UTF-8\">\n" +
				 "</head>\n" +
				 "<body>\n" +
				 "성공\n" +
				 "<ul>\n" +
				 " <li>id="+saveMember.getId()+"</li>\n" +
				 " <li>username="+saveMember.getUsername()+"</li>\n" +
				 " <li>age="+saveMember.getAge()+"</li>\n" +
				 "</ul>\n" +
				 "<a href=\"/index.html\">메인</a>\n" +
				 "</body>\n" +
				 "</html>");

	}
}

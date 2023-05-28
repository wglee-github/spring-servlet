package hello.servlet.web.frontController.v1.controller;

import java.io.IOException;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV1 implements ControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		Member saveMember = memberRepository.save(member);
		
		// model에 담는다.
		request.setAttribute("member", saveMember);
		
		String viewPath = "/WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

}

package hello.servlet.web.frontController.v1.controller;

import java.io.IOException;
import java.util.List;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV1 implements ControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();
		
		// model에 담는다.
		request.setAttribute("members", members);
		
		// view 호출
		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);		
	}

}

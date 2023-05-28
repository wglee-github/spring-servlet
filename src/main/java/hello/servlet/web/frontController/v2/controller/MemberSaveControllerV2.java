package hello.servlet.web.frontController.v2.controller;

import java.io.IOException;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		Member saveMember = memberRepository.save(member);
		
		// model에 담는다.
		request.setAttribute("member", saveMember);
		
		return new MyView("/WEB-INF/views/save-result.jsp");
	}

}

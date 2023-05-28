package hello.servlet.web.frontController.v2.controller;

import java.io.IOException;
import java.util.List;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Member> members = memberRepository.findAll();
		
		// model에 담는다.
		request.setAttribute("members", members);
		
		// view 호출
		return new MyView("/WEB-INF/views/members.jsp");
	}

}

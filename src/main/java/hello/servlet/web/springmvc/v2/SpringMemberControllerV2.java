package hello.servlet.web.springmvc.v2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}
	

	
	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username =  request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		Member saveMember = memberRepository.save(member);
		
		mv.addObject("member", saveMember);
		mv.setViewName("save-result");
		
		return mv; 
	}
	
	@RequestMapping
	public ModelAndView members() {
		ModelAndView mv = new ModelAndView();
		List<Member> members = memberRepository.findAll();
		mv.addObject("members", members);
		mv.setViewName("members");
		return mv;
	}
}

package hello.servlet.web.springmvc.v1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

@Controller
public class SpringMemberListControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/springmvc/v1/members")
	public ModelAndView process() {
		ModelAndView mv = new ModelAndView();
		List<Member> members = memberRepository.findAll();
		mv.addObject("members", members);
		mv.setViewName("members");
		return mv;
	}
}

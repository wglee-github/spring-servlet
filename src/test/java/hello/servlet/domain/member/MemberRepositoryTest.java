package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();
	
	
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void save() {
		
		// given
		Member member = new Member("hello", 20);
		
		// when
		Member saveMember =  memberRepository.save(member);
		
		Member findMember = memberRepository.findById(saveMember.getId());
		
		// then
		assertThat(saveMember).isSameAs(findMember);
		assertThat(findMember.getUsername()).isEqualTo("hello");
		assertThat(findMember.getAge()).isEqualTo(20);
	}

	
	@Test
	void findAll() {
		
		// given
		Member member1 = new Member("member1", 20);
		Member member2 =new Member("member2", 30);
		memberRepository.save(member1);
		memberRepository.save(member2);
		
		// when
		List<Member> members = memberRepository.findAll();
		
		
		// then
		assertThat(members.size()).isEqualTo(2);
		assertThat(members).contains(member1, member2);
	}
}

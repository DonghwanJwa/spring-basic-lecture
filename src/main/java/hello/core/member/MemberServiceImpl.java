package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //관례상의 명칭으로 Impl을 붙임 (구현체)

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //2022-06-30 APPCONFIG 적용 주석처리

    //AppConfig 적용시
    private final MemberRepository memberRepository;

    //생성자를 통해서 누굴 부를지 결정 -> AppConfig에서
    @Autowired //ac.getBean(MemberRepository.class) 를 사용한것과 동일한 기능 (2022-07-13)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; 
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //2022-07-07 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}

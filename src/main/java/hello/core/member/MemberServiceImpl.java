package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //관례상의 명칭으로 Impl을 붙임 (구현체)

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //2022-06-30 APPCONFIG 적용 주석처리

    //AppConfig 적용시
    private final MemberRepository memberRepository;

    //생성자를 통해서 누굴 부를지 결정 -> AppConfig에서
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
}

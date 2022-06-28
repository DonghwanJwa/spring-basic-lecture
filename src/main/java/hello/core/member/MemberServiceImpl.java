package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //관례상의 명칭으로 Impl을 붙임 (구현체)

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

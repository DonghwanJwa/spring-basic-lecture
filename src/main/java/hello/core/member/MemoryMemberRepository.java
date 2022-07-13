package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    //아직 DB가 확정되지 않았기 때문에 임시로 사용하는 객체
    //사실 동시성 이슈때문에 concurrenthashmap을 사용해야 하지만 예제니까..실무에선 꼭 사용해보자!

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

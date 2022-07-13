package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //2022-06-30 Appconfig 적용을 위한 주석처리
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정할인
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //비율할인

    // 문제 : 할인정책을 변경하려면 OrderServiceImpl 소스코드를 수정해야함...
    // - 역할 , 구현을 충실히 분리
    // - 다형성 활용, 인터페이스 구현, 객체분리 ok
    // - OCP, DIP 객체지향 설계원칙 준수 ? -> Actually NO!!
    //   1) 추상뿐만 아니라 구체 클래스에 의존하여.. 문제가됨
    //   -> 클라이언트는 역할만 알면되는데 구현까지 인지해야하는 문제
    //   -> 예를들어 '자동차'의 역할만 알면되는데 '테슬라 전기차'의 기능에 의존해버림
    //    !!! DIP 위반
    //   2) 정책변경 시 역할(serviceimpl)의 소스를 변경해야 한다.
    //    !!! OCP 위반  
    
    // 해결법
    // DIP를 위반하지 않도록 의존관계를 변경한다.. 인터페이스에만 의존하도록 설계변경

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; //이런식으로 그냥두면 Null Exception 나옴..

    // 누군가 구현객체를 대신 생성하고 주입해야함 -> AppConfig!!!에서 생성자 주입!!

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //2022-07-07 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

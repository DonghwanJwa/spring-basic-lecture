package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //serviceImpl 외부에서 구현객체를 결정하도록 역할-특정구현 객체간 의존을 끊음 => 실행에만 집중!
    // 의존성 주입 혹은 의존관계 주입 이라 표현(DI : Dependency Injection)
    
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
        //생성자 주입!
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}

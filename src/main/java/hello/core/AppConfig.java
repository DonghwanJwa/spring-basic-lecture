package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //serviceImpl 외부에서 구현객체를 결정하도록 역할-특정구현 객체간 의존을 끊음 => 실행에만 집중!
    // 의존성 주입 혹은 의존관계 주입 이라 표현(DI : Dependency Injection)

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
        //생성자 주입!
    }

    @Bean
    //2022-07-03 Refactoring
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //2022-07-03 Refactoring
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

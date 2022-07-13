package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //뺄것 : AppConfig.class, TestConfig.class 파일의 Configuration Annotation 을 제외하기 위함
        //      (Configuration.class내에도 @Component Annotation이 존재 -> @Bean을 자동으로 등록해버림)
        //      실무에서는 Configuration 제외하지 않음!!
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 1. Configuration annotation
    // 2. ComponentScan annotation 붙여준다.
    //  -> @Bean 등록한 클래스가 없다.

    //MemoryMemberRepository.java, RateDiscountPolicy.java,
    //MemberServiceImpl.java, OrderServiceImpl.java 에 @Component Annotation 추가
    // 의존관계 주입은 ? @Autowired Annotation 을 사용해서 자동으로 연결하게 한다.

}

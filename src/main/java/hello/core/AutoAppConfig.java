package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //뺄것 : AppConfig.class, TestConfig.class 파일의 Configuration Annotation 을 제외하기 위함
        //      (Configuration.class내에도 @Component Annotation이 존재 -> @Bean을 자동으로 등록해버림)
        //      실무에서는 Configuration 제외하지 않음!!
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "hello.core.member",  //package 에서 어디서부터 찾는지 지정, spring이 모든 java 코드를 다뒤지는 불필요한 과정을 줄임
        basePackageClasses = AutoAppConfig.class    //지정한 클래스의 패키지를 탐색 시작 위로 지정, 없으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 됨
                                                    //권장방법 - > 패키지 위치 지정하지 않고, 설정정보 클래스의 위치를 프로잭트 최상단에 둠 (hello.core에 둬버림)
)
public class AutoAppConfig {
    // 1. Configuration annotation
    // 2. ComponentScan annotation 붙여준다.
    //  -> @Bean 등록한 클래스가 없다.

    //MemoryMemberRepository.java, RateDiscountPolicy.java,
    //MemberServiceImpl.java, OrderServiceImpl.java 에 @Component Annotation 추가
    // 의존관계 주입은 ? @Autowired Annotation 을 사용해서 자동으로 연결하게 한다.

}

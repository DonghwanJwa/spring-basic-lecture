package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(); //AppConfig 활용을 위한 주석

        Member member = new Member(1L, "memberA", Grade.VIP);   //신규 회원가입할 계정정보
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = "+findMember.getName());

        //매번 이렇게 class파일 만들어서 확인하는 방식은 비효율적... junit 사용하여 테스트 해볼것!!

    }
}

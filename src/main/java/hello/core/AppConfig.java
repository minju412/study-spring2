package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 역할: 멤버 서비스
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    // 역할: 오더 서비스
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 역할: 멤버 리포지토리
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 구현: 메모리 멤버 리포지토리
    }

    // 역할: 할인 정책
    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy(); // 구현: 고정 할인 정책
    }

}

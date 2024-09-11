package services.Interfaces;

import entities.Member;

public interface MemberService {
    boolean register(Member member);
    boolean login(String email, String password);
}

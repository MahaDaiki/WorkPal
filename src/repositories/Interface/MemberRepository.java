package repositories.Interface;

import entities.Member;

public interface MemberRepository {

    void register(Member member);
    int getMemberIdByUserId(int userId);
}

package services.Implementation;

import entities.Member;
import repositories.Implementation.AdminRepositoryImpl;
import repositories.Implementation.MemberRepositoryimpl;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.AdminRepository;
import repositories.Interface.MemberRepository;
import repositories.Interface.UserRepository;
import services.Interfaces.MemberService;

public class MemberServiceImpl implements MemberService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final MemberRepository memberRepository  = new MemberRepositoryimpl();


    @Override
    public int getMemberIdByUserId(int userId) {
        return memberRepository.getMemberIdByUserId(userId);
    }
}

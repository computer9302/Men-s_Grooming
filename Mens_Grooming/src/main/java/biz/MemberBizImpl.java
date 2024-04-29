package biz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dto.Member;
import dto.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz {
	
	
	private final MemberDao dao;
	
	@Autowired
	public MemberBizImpl(MemberDao dao) {
		this.dao = dao;
	}


	@Override
	public int join(MemberDto dto) {
		return dao.join(dto);
	}
	
	@Override
	public int register(Member member) {
		return dao.register(member);
	}
	
	@Override
	public Optional<Member> findByEmail(String email){
		return dao.findByEmail(email);
	}
}

package biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.MemberDao;
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
}

package dao;

import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.Member;
import dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate SqlSession;
	
	@Override
	public int join(MemberDto dto) {
		int res = 0;
		
		try {
			res = SqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int register(Member member) {
		int res = 0;
		
		try {
			res = SqlSession.insert(NAMESPACE + "insertSns",member);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public Optional<Member> findByEmail(String email){
		Optional<Member> res = null;
		
		try {
			res = SqlSession.selectOne(NAMESPACE + "select", email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
}

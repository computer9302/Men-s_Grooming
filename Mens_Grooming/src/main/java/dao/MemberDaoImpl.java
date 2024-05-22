package dao;

import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import auth.Auth;
import dto.LoginDto;
import dto.Member;
import dto.MemberDto;
import dto.SignUpDto;

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
	
	public void insertAuth(Auth auth) {
		int res=0;
		
		try {
			res = SqlSession.insert(NAMESPACE + "insertAuth", auth);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public Member findByEmail(String email){
		Member res = null;
		
		try {
			res = SqlSession.selectOne(NAMESPACE + "select", email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	public Member login(LoginDto loginDto) {
		Member res = null;
		
		try {
			res = SqlSession.selectOne(NAMESPACE + "selectLogin" + loginDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Member read(String email) {
		// TODO Auto-generated method stub
		Member res = null;
		
		try {
			res = SqlSession.selectOne(NAMESPACE + "read" + email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
}

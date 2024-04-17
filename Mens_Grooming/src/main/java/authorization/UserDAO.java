package authorization;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository("usesrDAO")
public class UserDAO {
			@Autowired
			private SqlSessionTemplate sqlSession;
			
			public User getUserById(String id) {
				return sqlSession.selectOne("user.selectUserById", id);
			}
}

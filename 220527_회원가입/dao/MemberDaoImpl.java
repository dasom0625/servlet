package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
/* 
=> SqlMapclient객체가 있어야 Sql을 수행시킬 수 있다.
=> 자신의 클래스 객체를 생성해서 리턴하는 메서드가 있어야 한다.
 */
public class MemberDaoImpl implements IMemberDao {
	
	private SqlMapClient client;
	private static MemberDaoImpl dao;
	
	
	//생성자=>private를 사용한 이유는 '자신의 클래스 객체를 생성해서 리턴하는 메서드'라서 다른곳에서 'new MemberDaoImpl()'로 선언하지 못하게 하기 때문이다.
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	//하나의 객체를 여러군데에서 공유하기 때문에 static이 붙는다.
	
	@Override	//부모로 부터 상속받은것을 재정의(부모에 있는 메서드를 그대로 써야함.=>exception도 상속만 가능하고 따로 만들면 안됨) 
	public String selectById(String id) throws SQLException {
		
		return (String)client.queryForObject("member.selectById", id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {

		return client.queryForList("zip.selectByDong", dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {

		return (String) client.insert("member.insertMember", vo);	//queryForList나 queryForObject는 select문에서만 사용	
	
	}

	@Override
	public int insertUpdate(MemberVO vo) throws SQLException {
		return client.update("member.insertUpdate",vo);
	}

}

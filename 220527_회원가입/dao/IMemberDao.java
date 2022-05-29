package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {

	//아이디 중복검사하는 메소드
	public String selectById(String id)throws SQLException; //kdr.or.ddit.ibaits.mapper.member.xml에 있는 이름과 동일하게 하는게 편하다
	
	//우편번호 찾기 메소드
	public List<ZipVO> selectByDong (String dong)throws SQLException;
	
	//저장하기-가입하기 메소드 => insert를 이용한 insert (return이 id를 return)
	public String insertMember(MemberVO vo)throws SQLException;
	
	//저장하기-가입하게 메소드 => update를 이용한 insert (return이 몇개의 등록을 수행했는지 갯수)
	public int insertUpdate(MemberVO vo)throws SQLException;
	
	
	
}

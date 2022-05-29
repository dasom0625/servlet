package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {

	
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public String selectById(String id) {
		//컨트롤러=>서비스 호출 =>서비스에서 dao호출=>dao에서 리턴해서 다시 서비스로 =>서비스에서 컨트롤러?	
		String sid = null;
		
		try {
			sid = dao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sid;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		
		List<ZipVO> list = null;
		
		try {
			list = dao.selectByDong(dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) {
		
		String id = null;
		
		try {
			id = dao.insertMember(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int insertUpdate(MemberVO vo) {

		int res = 0;
		
		try {
			res = dao.insertUpdate(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}

//java클래스

package kr.or.ddit.basic.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyMember {

	
/////////////////////////////////////////////////////////////////
	
	//아이디 찾기
	public MyMemberVO loginID(MyMemberVO vo) {
		//Connection객체 선언
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		MyMemberVO mvo = null;
/////////////////////////////////////////////////////////////////

		//try-catch사용
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc11", "java");
			
			//쿼리문 작성
			String sql = 
			"select mem_name "
			+ "from mymember "
			+ "where mem_id = ? "
			+ "and mem_pw = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getMem_id());
			ps.setString(2, vo.getMem_pw());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				mvo = new MyMemberVO();
				mvo.setMem_name(rs.getString("mem_name"));
			}
			
		} catch (SQLException e) {
			mvo = null;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (SQLException e) { }
			if(ps!=null) try {ps.close();} catch (SQLException e) { }
			if(rs!=null) try {rs.close();} catch (SQLException e) { }
		}
		return mvo;
		
	}
	
	
}

package kr.ddit.or.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {

	private static SqlMapClient smc;
	
	static {

			// 1-1. 문자 인코딩 케릭터 셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			Reader rd = null;
			try {
				
				// 1-2. Reader를 통해 환경설정 파일 읽어올 스트림 객체 구하기
				rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/SqlMapConfig.xml");
				
				// 1-3. 스트림 객체 이용하여 환경설정하고, SQL문을 실행할수 있는 iBatis객체 생성
				smc = SqlMapClientBuilder.buildSqlMapClient(rd);
				

			} catch (Exception e) {

				System.out.println("SqlMapClient객체 생성 실패");
				e.printStackTrace();
			}finally {
				if(rd!=null)try {rd.close();}catch(IOException e) {}
			}
		}

		public static SqlMapClient getSqlMapClient() {
			return smc;
		}
	
	}

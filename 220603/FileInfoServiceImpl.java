package kr.or.ddit.basic.fileupload.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.ddit.or.util.SqlMapClientFactory;
import kr.or.ddit.basic.fileupload.dao.FileInfoDaoImpl;
import kr.or.ddit.basic.fileupload.vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {

	private SqlMapClient smc;
	
	private FileInfoDaoImpl dao;
	
	private static FileInfoServiceImpl service;
	
	private FileInfoServiceImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
		dao = FileInfoDaoImpl.getInstance();
	}

	public static FileInfoServiceImpl getInstance() {
		if(service==null)service = new FileInfoServiceImpl();
		return service;
	}
	
	@Override
	public int insertFileInfo(FileInfoVO fileVo) {
		
		int count = 0;
		try {
			count = dao.insertFileInfo(smc, fileVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		List<FileInfoVO> fileList = null;
		try {
			fileList = dao.getAllFileInfo(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileList;
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		FileInfoVO fileVo = null;
		
		try {
			fileVo = dao.getFileInfo(smc, fileNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileVo;
	}

}

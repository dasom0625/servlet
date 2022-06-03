package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import kr.or.ddit.basic.fileupload.vo.FileInfoVO;

public interface IFileInfoService {


	/**
	 * fileVo에 담겨진 자료를 DB에 insert하는 메서드
	 * @param fileVo DB에 insert할 자료가 자정된 FileInfoVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertFileInfo(FileInfoVO fileVo);
	/**
	 * DB에 있는 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드
	 * @return 파일정보가 저장된 List객체
	 */
	public List<FileInfoVO> getAllFileInfo();
	
	/**
	 * fileNo을 인수값으로 받아서 해당 파일 정보를 VO에 담아서 반환하는 메서드
	 * @param fileNo 검색할 file번호
	 * @return 검색된 파일 정보가 젖아도니 FileInfoVO객체
	 */
	public FileInfoVO getFileInfo(int fileNo);

}

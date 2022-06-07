//페이지만들기

package kr.or.ddit.board.vo;

public class PageVO {

	private int start;		//현재 페이지 내에서의 첫 시작 글 번호
	private int end;		//현재 페이지 내에서의 마지막 글 번호
	
	private int startPage;	//브라우저에 출력되는 시작 페이지
	private int endPage;	//브라우저에 출력되는 끝 페이지
	private int totalPage;	//DB에 저장된 전체 페이지 수
	private int count;		//DB에 저장된 전체 글 갯수 => 검색에 따라 출력결과가 달라짐. ex)제목이 2가 들어가는 거 검색하면, 2,12,20까치 총 세개가 나옴.
		
	private static int perList = 8;	//한페이지에 출력되는 글 갯수//한번 검색할때마다 한 페이지에 4개의 글을 보여줌.=>1개의 페이지에 4개의 글, 12개글이 검색되면 총 3페이지나옴.
	private static int perPage = 3; //초기값
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int getPerList() {
		return perList;
	}
	public static void setPerList(int perList) {
		PageVO.perList = perList;
	}
	public static int getPerPage() {
		return perPage;
	}
	public static void setPerPage(int perPage) {
		PageVO.perPage = perPage;
	}
	@Override
	public String toString() {
		return "PageVO [start=" + start + ", end=" + end + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", count=" + count + "]";
	}
	
	
}

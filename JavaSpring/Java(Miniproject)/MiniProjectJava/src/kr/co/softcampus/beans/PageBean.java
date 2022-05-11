package kr.co.softcampus.beans;

public class PageBean {
	// �ּ� ������ ��ȣ
	private int min;
	//�ִ� ������ ��ȣ
	private int max; 
	//���� ��ư�� ������ ��ȣ
	private int prevPage; 
	//���� ��ư�� ������ ��ȣ
	private int nextPage; 
	//��ü ������ ����
	private int pageCnt; 
	//���� ������ ��ȣ
	private int currentPage;
	
	// contentCnt : ��ü�� ����, currentPage : ���� �� ��ȣ, contentPageCnt : �������� ���� ����, paginationCnt : ������ ��ư�� ����
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		//���� ������ ��ȣ
		this.currentPage = currentPage; 
		
		//��ü ������ ����
		pageCnt = contentCnt / contentPageCnt;
		
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		// 0 : 1
		// 1 : 11
		// 2 : 21
		min = ((currentPage -1) / contentPageCnt) * contentPageCnt + 1;
		max = min + paginationCnt -1; 
		
		
		if(max >pageCnt) {
			max = pageCnt; 
		}
		prevPage = min - 1; 
		nextPage = max + 1;
		if(nextPage > pageCnt){
			nextPage = pageCnt; 
		}
	}
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	} 
	
	
}
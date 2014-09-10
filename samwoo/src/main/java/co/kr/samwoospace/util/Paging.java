package co.kr.samwoospace.util;

import java.util.Iterator;

import java.util.Map;
import co.kr.samwoospace.bean.Param;

public class Paging {
	
	private int totalCount;        // ��ü ���ù� ����
	private int pageNum;          // ���� ��û�� ������ ��ȣ
	private int pageSize;          // �� �� �������� ����� �Խù� ����   
	private int pageCount;       //  �ѹ��� ������ ������ ����
	private String pageURL;    // ��û�� URL
	private String bbsId;         // ������ DB ���̺�
	private Param<?,?> param;   // �˻����� ����Ʈ
	
	public Paging() { }

  	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 *  ���� ��û�� ��������ȣ�� ��´�.<br/>
	 *  <br/>
	 * @return ��û�� ������ ��ȣ
	 */
	
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * ���� ��û�� ��������ȣ�� �����Ѵ�.<br/>
	 * <br/>
	 * @param pageNum - ��û�� ������ ��ȣ
	 */
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
	/**
	 * �ش� �׺���̼��� �� �������� ������<br/> 
	 * �Խù� ������ ��´�.<br/>
	 *  <br/>
	 * @return �� �������� ������ �Խù� ���� 
	 */
	
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * �ش� �׺���̼��� �� �������� ������<br/>
	 * �Խù� ������ �����Ѵ�.<br/>
	 * <br/>
	 * @param pageSize �� �������� ������ �Խù� ����
	 */
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * �ش� �׺���̼��� �ѹ��� ������ ��������<br/> 
	 * ������ ��´�. <br/>
	 * <br/>
	 * @return �ѹ��� ������ ������ ����
	 */
	
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * �ش� �׺���̼��� �ѹ��� ������ ��������<br/> 
	 * ������ �����Ѵ�. <br/>
	 * <br/>
	 * @param pageCount �ѹ��� ������ ������ ����
	 */
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * �ش� �׺���̼��� ���� pageURL �ּҸ� ��´�.<br/>
	 * <br/>
	 * @return pageURL �׺���̼� �ּ�
	 */
	
	public String getPageURL() {
		return pageURL;
	}

	/**
	 * �ش� �׺���̼��� ���� pageURL �ּҸ� �����Ѵ�.<br/>
	 * <br/>
	 * @param pageURL �׺���̼� �ּ�
	 */
	
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	/**
	 * �ش� �׺���̼ǿ��� �߰������� �ʿ��� �Ķ���� �����<br/>
	 * ���´�. Map Ÿ������ �����Ǿ� �ִ�.<br/>
	 * <br/>
	 * @return Map - �׺���̼� �ּ�
	 */
	public Param<?, ?> getParam() {
		return param;
	}

	/**
	 * �ش� �׺���̼ǿ��� �߰������� �ʿ��� �Ķ���� �����<br/>
	 * �����Ѵ�. Map Ÿ������ �����Ǿ� �ִ�.<br/>
	 * <br/>
	 * @param Param - �׺���̼� �ּ�
	 */
	public void setParam(Param<?, ?> param) {
		this.param = param;
	}
  	
	public String getBbsId() {
		return bbsId;
	}

	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}
	
	public String makePageGroup() {
	    
	 /* @param totalPage = ��ü ������ ����
	  * 
	  * ��ü �Խù� �������� �� �������� ����� �Խù��� ������ 0���� ��������
	  * ��ü �Խù� ���� / �� �������� ����� �Խù�, ��µ� ������ ������ +1�� �Ѵ�.
	  * ���� ��� 48���� �Խù��� ������ �ְ� 10���� 1�������� ������ ������ ���̶��
	  * 48�� 10���� ������ �������� �����Ƿ� + 1�Ǿ� �� 5���� �������� ���̰� �ȴ�. */
	  int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
   
	  /* @param currentGroup = ���� ��û�� �������� ���ϴ� �������� �׷� 
	   * 
	   * pageCount�� �� ���� ������ ������ ��ȣ�� ������ �ǹ��Ѵ�. ���� ��� 5�ΰ�� 
	   * �ϴ� ������ �׺���̼��� (1 2 3 4 5)�� ��µǰ� 10�ΰ�� (1 2 3 4 5 6 7 8 9 10)
	   * �� ��µǴ� ���̴�. ��ü �Խù� ������ 330���̰� pageSize�� 10, pageCount�� 10�̶�� 
	   * pageGroup�� �� 4���� �ȴ�. 1���� 10�������� ù ��° �׷�, 11���� 20�������� �� ��° �׷�, 21���� 30�������� �� ��° �׷�,
	   * 31���� 33�������� �� ��° �׷��� �Ǵ� ���̴�. currentGroup�� �̵� pageGroup���� ����
	   * ��û�� ������ ��ȣ�� ��� ���ϴ��� ����Ͽ� �˾Ƴ��� ������ �Ѵ�.
	   * 
	   * ���� ��û�� �������� 3���̰� pageCount�� 10�̶�� ������ ���� �ڱ� �ڽ�(3)�� ������ 
	   * ���׿������� ������ �����ϹǷ� 3 / 10 + 1 = 1�� ���, �� 1��° �׷��� ������ �ȴ�. �ٸ� ���� ���� ��û�� �������� 11���̰�
	   * pageCount�� 5��� 11 % 5 = 1, ���׿����� ������ �����ϹǷ� 11 / 5 + 1 = 3, 3��° �׷쿡 ���ϴ� ���� �� �� �ִ�. */
	  int currentGroup = pageNum % pageCount > 0 ? pageNum / pageCount + 1 : pageNum / pageCount;
	  
	  /* ���� �׷��ȣ�� �˾Ƴ��� ���� �׷쿡 ���ϴ� ���� ��������ȣ�� �� ��������ȣ�� ���� ���̴�. */
	  return makeHtml(currentGroup, totalPage, pageURL);
  }

  private String makeHtml(int currentGroup, int totalPage, String requestPage) {
    StringBuffer sb = new StringBuffer();
    String paramString = "";
    
    // �˻�����
    if(param != null) {
    	paramString = paramString(param);
    }
    
    /* ���� �׷��� ���� ������ ��ȣ�̴�. */
    int start = currentGroup * pageCount - (pageCount - 1);
    /* ���� �׷��� ������ ������ ��ȣ�̴�. */ 
    int end = currentGroup * pageCount >= totalPage ? totalPage : currentGroup * pageCount;
    
    /* start�� 1�� ��� (ù ��° �׷��� ���)�� ����, ���� �׷����� ���ư� �� �ִ� ��ũ */
    if (start != 1) {
      sb.append("<li><a href='"+pageURL+"?pageNum="+ (start - 1) + paramString +"' class='previous'>");
      sb.append("<img src='/admin/img/pre_02.gif'>");
      sb.append("</a></li>");
    } 
    
    for (int i = start; i <= end; i++) {
      if (this.pageNum != i) {
        sb.append("<li class='num'><a href='"+pageURL+"?pageNum=" + i + paramString +"'>");
        sb.append(i);
        sb.append("</a></li>");
      } else {
        sb.append("<li class='num_on'>");
        sb.append(i);
        sb.append("</li>");
      }

      /* ���� �׷��� ������ ������ ��ȣ�� totalPage ���� �۴ٸ� ���� �׷����� �Ѿ �� �ִ� ��ũ */
      if ((i == end) && (i < totalPage)) {
        sb.append("<li><a href='"+ pageURL +"?pageNum="+ (end + 1) + paramString + "' class='next'>");
        sb.append("<img src='/admin/img/next_02.gif'>");
        sb.append("</a></li>");
      } 
    }

    return sb.toString();
  }
  
  private String paramString(Map<?,?> param) {
	  /* param Map�� Ž���Ͽ� a href�� �ּҿ� �˻������� ���Ѵ� */ 
	  Iterator<?> keySet = param.keySet().iterator();
	  StringBuilder parameters = new StringBuilder();
	  while(keySet.hasNext()) {
	    String key = (String)keySet.next();
	    parameters.append("&" + key +"="+param.get(key));
	  }  
	  
	  return parameters.toString();
  }


  
}

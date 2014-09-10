package co.kr.samwoospace.util;

import java.util.Iterator;

import java.util.Map;
import co.kr.samwoospace.bean.Param;

public class Paging {
	
	private int totalCount;        // 전체 개시물 개수
	private int pageNum;          // 현재 요청된 페이지 번호
	private int pageSize;          // 한 개 페이지에 출력할 게시물 개수   
	private int pageCount;       //  한번에 보여줄 페이지 개수
	private String pageURL;    // 요청된 URL
	private String bbsId;         // 연관된 DB 테이블
	private Param<?,?> param;   // 검색조건 리스트
	
	public Paging() { }

  	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 *  현재 요청된 페이지번호를 얻는다.<br/>
	 *  <br/>
	 * @return 요청된 페이지 번호
	 */
	
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * 현재 요청된 페이지번호를 저장한다.<br/>
	 * <br/>
	 * @param pageNum - 요청된 페이지 번호
	 */
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
	/**
	 * 해당 네비게이션이 한 페이지에 보여줄<br/> 
	 * 게시물 개수를 얻는다.<br/>
	 *  <br/>
	 * @return 한 페이지에 보여줄 게시물 개수 
	 */
	
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 해당 네비게이션이 한 페이지에 보여줄<br/>
	 * 게시물 개수를 저장한다.<br/>
	 * <br/>
	 * @param pageSize 한 페이지에 보여줄 게시물 개수
	 */
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 해당 네비게이션이 한번에 보여줄 페이지의<br/> 
	 * 개수를 얻는다. <br/>
	 * <br/>
	 * @return 한번에 보여줄 페이지 개수
	 */
	
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 해당 네비게이션이 한번에 보여줄 페이지의<br/> 
	 * 개수를 저장한다. <br/>
	 * <br/>
	 * @param pageCount 한번에 보여줄 페이지 개수
	 */
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 해당 네비게이션이 쓰일 pageURL 주소를 얻는다.<br/>
	 * <br/>
	 * @return pageURL 네비게이션 주소
	 */
	
	public String getPageURL() {
		return pageURL;
	}

	/**
	 * 해당 네비게이션이 쓰일 pageURL 주소를 저장한다.<br/>
	 * <br/>
	 * @param pageURL 네비게이션 주소
	 */
	
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	/**
	 * 해당 네비게이션에서 추가적으로 필요한 파라미터 목록을<br/>
	 * 얻어온다. Map 타입으로 구성되어 있다.<br/>
	 * <br/>
	 * @return Map - 네비게이션 주소
	 */
	public Param<?, ?> getParam() {
		return param;
	}

	/**
	 * 해당 네비게이션에서 추가적으로 필요한 파라미터 목록을<br/>
	 * 저장한다. Map 타입으로 구성되어 있다.<br/>
	 * <br/>
	 * @param Param - 네비게이션 주소
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
	    
	 /* @param totalPage = 전체 페이지 개수
	  * 
	  * 전체 게시물 개수에서 한 페이지당 출력할 게시물로 나누어 0으로 떨어지면
	  * 전체 게시물 개수 / 한 페이지당 출력할 게시물, 출력될 페이지 개수에 +1을 한다.
	  * 예를 들어 48개의 게시물을 가지고 있고 10개씩 1페이지로 나누어 보여줄 것이라면
	  * 48은 10으로 나누어 떨어지지 않으므로 + 1되어 총 5개의 페이지에 보이게 된다. */
	  int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
   
	  /* @param currentGroup = 현재 요청된 페이지가 속하는 페이지의 그룹 
	   * 
	   * pageCount는 한 번에 보여줄 페이지 번호의 개수를 의미한다. 예를 들어 5인경우 
	   * 하단 페이지 네비게이션은 (1 2 3 4 5)로 출력되고 10인경우 (1 2 3 4 5 6 7 8 9 10)
	   * 로 출력되는 식이다. 전체 게시물 개수가 330건이고 pageSize가 10, pageCount가 10이라면 
	   * pageGroup은 총 4개가 된다. 1에서 10페이지가 첫 번째 그룹, 11에서 20페이지가 두 번째 그룹, 21에서 30페이지가 세 번째 그룹,
	   * 31에서 33페이지가 네 번째 그룹이 되는 것이다. currentGroup은 이들 pageGroup에서 현재
	   * 요청된 페이지 번호가 어디에 속하는지 계산하여 알아내는 역할을 한다.
	   * 
	   * 현재 요청된 페이지가 3번이고 pageCount는 10이라면 나머지 값은 자기 자신(3)이 나오고 
	   * 삼항연산자의 조건을 만족하므로 3 / 10 + 1 = 1의 결과, 즉 1번째 그룹이 나오게 된다. 다른 예로 현재 요청된 페이지가 11번이고
	   * pageCount가 5라면 11 % 5 = 1, 삼항연산자 조건을 만족하므로 11 / 5 + 1 = 3, 3번째 그룹에 속하는 것을 알 수 있다. */
	  int currentGroup = pageNum % pageCount > 0 ? pageNum / pageCount + 1 : pageNum / pageCount;
	  
	  /* 현재 그룹번호를 알아내면 현재 그룹에 속하는 시작 페이지번호와 끝 페이지번호를 구할 것이다. */
	  return makeHtml(currentGroup, totalPage, pageURL);
  }

  private String makeHtml(int currentGroup, int totalPage, String requestPage) {
    StringBuffer sb = new StringBuffer();
    String paramString = "";
    
    // 검색조건
    if(param != null) {
    	paramString = paramString(param);
    }
    
    /* 현재 그룹의 시작 페이지 번호이다. */
    int start = currentGroup * pageCount - (pageCount - 1);
    /* 현재 그룹의 마지막 페이지 번호이다. */ 
    int end = currentGroup * pageCount >= totalPage ? totalPage : currentGroup * pageCount;
    
    /* start가 1인 경우 (첫 번째 그룹인 경우)를 제외, 이전 그룹으로 돌아갈 수 있는 링크 */
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

      /* 현재 그룹의 마지막 페이지 번호가 totalPage 보다 작다면 다음 그룹으로 넘어갈 수 있는 링크 */
      if ((i == end) && (i < totalPage)) {
        sb.append("<li><a href='"+ pageURL +"?pageNum="+ (end + 1) + paramString + "' class='next'>");
        sb.append("<img src='/admin/img/next_02.gif'>");
        sb.append("</a></li>");
      } 
    }

    return sb.toString();
  }
  
  private String paramString(Map<?,?> param) {
	  /* param Map을 탐색하여 a href의 주소에 검색조건을 더한다 */ 
	  Iterator<?> keySet = param.keySet().iterator();
	  StringBuilder parameters = new StringBuilder();
	  while(keySet.hasNext()) {
	    String key = (String)keySet.next();
	    parameters.append("&" + key +"="+param.get(key));
	  }  
	  
	  return parameters.toString();
  }


  
}

package co.kr.samwoospace.util;

import java.util.Iterator;

import java.util.Map;
import co.kr.samwoospace.bean.Param;

public class Paging {
	
	private int totalCount;      
	private int pageNum;          
	private int pageSize;       
	private int pageCount;       
	private String pageURL;   
	private String bbsId;        
	private Param<?,?> param;   
	
	public Paging() { }

  	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	public Param<?, ?> getParam() {
		return param;
	}

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
	    
	  int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
   
	  int currentGroup = pageNum % pageCount > 0 ? pageNum / pageCount + 1 : pageNum / pageCount;
	  
	  return makeHtml(currentGroup, totalPage, pageURL);
  }

  private String makeHtml(int currentGroup, int totalPage, String requestPage) {
    StringBuffer sb = new StringBuffer();
    String paramString = "";
    
    if(param != null) {
    	paramString = paramString(param);
    }
    
    int start = currentGroup * pageCount - (pageCount - 1);
    int end = currentGroup * pageCount >= totalPage ? totalPage : currentGroup * pageCount;
    
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

      if ((i == end) && (i < totalPage)) {
        sb.append("<li><a href='"+ pageURL +"?pageNum="+ (end + 1) + paramString + "' class='next'>");
        sb.append("<img src='/admin/img/next_02.gif'>");
        sb.append("</a></li>");
      } 
    }

    return sb.toString();
  }
  
  private String paramString(Map<?,?> param) {
	  Iterator<?> keySet = param.keySet().iterator();
	  StringBuilder parameters = new StringBuilder();
	  while(keySet.hasNext()) {
	    String key = (String)keySet.next();
	    parameters.append("&" + key +"="+param.get(key));
	  }  
	  
	  return parameters.toString();
  }


  
}

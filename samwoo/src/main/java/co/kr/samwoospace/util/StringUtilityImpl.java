package co.kr.samwoospace.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

public class StringUtilityImpl implements StringUtility {

  @Autowired(required=false)
  private ServletContext servletContext;
  private String RelativePath = "/resources/upload";
  private String RelativeThumbPath = "/resources/upload/thumbnail";
  private String editorUploadPath = "/resources/editorUpload";
  
  public void setServletContext(ServletContext context) {
	  this.servletContext = context;
  }

  public String getRelativeThumbPath() {
		return RelativeThumbPath;
  }

  public void setRelativeThumbPath(String relativeUploadPath) {
		RelativeThumbPath = relativeUploadPath;
  }
  
  @Override
  public String getUploadPath() {
	    String contextPath = this.servletContext.getRealPath(this.RelativePath);
	    StringBuilder sb = new StringBuilder();
	    sb.append(contextPath);
	    return sb.toString();
  }
  
  @Override
  public String getThumbnailUploadPath() {
	   String contextPath = this.servletContext.getRealPath(this.RelativeThumbPath);
	  return contextPath;
  }

  @Override
  public String encodedFileName(String fileName) {
	  	String slicedName = fileName.substring(0, fileName.length() - 4);
    	String slicedExtension = fileName.substring(fileName.length() - 4, fileName.length());

    	String encodedName = null;
    	try {
    		encodedName = URLEncoder.encode(slicedName, "UTF-8");
    	} catch (UnsupportedEncodingException e) {
    		throw new RuntimeException(e);
    	}

    	String notDuplicatedName = buildString("/file", Long.valueOf(System.currentTimeMillis()));
    	return buildString(notDuplicatedName, slicedExtension);
  }

  public String buildString(Object key, Object value) {
	    StringBuilder sb = new StringBuilder();
	    sb.append(key.toString());
	    sb.append(value.toString());
	    return sb.toString();
  }

  public boolean isIllegalExtension(String fileName)
  {
	    List<String> allowExtension = new ArrayList<String>(Arrays.asList
	    		(new String[] { "jpg", "jpeg", "png", "gif", "pdf", "xls", "xslx",
	    						   "ppt", "doc", "hwp"}));
	    int namelength = fileName.length();
	    String extension = fileName.substring(namelength - 3, namelength);
	    return !allowExtension.contains(extension);
  }
  
  @Override
	public boolean isIllegalMimeType(String paramString) {
	  List<String> allowMimeType = new ArrayList<String>(Arrays.asList
	    		(new String[] { "image/jpeg", "image/gif", "image/png", "application/pdf", "application/vnd.ms-excel", 
	    						   "application/vnd.ms-powerpoint", "application/msword", "application/hangul"}));
		
	  return !allowMimeType.contains(paramString);
	}

  public boolean validTableName(String bbs)
  {
    return bbs.matches("(?!.*[\\-\\'\"]).*");
  }

  @Override
	public String getRelativePath() {
		return this.getRelativePath();
	}

	@Override
	public String getFileExtension(String fileName) {
		return fileName.substring(fileName.length(), fileName.length()-3);
	}

	public String getEditorUploadPath() {
		return this.servletContext.getRealPath(this.editorUploadPath);
	}

	public void setEditorUploadPath(String editorUploadPath) {
		this.editorUploadPath = editorUploadPath;
	}

	@Override
	public String removeHTML(String htmlString)
    {
        // Remove HTML tag from java String    
        String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");
        
        // Remove Carriage return from java String
        noHTMLString = noHTMLString.replaceAll("&nbsp;", "");
        noHTMLString = noHTMLString.replaceAll("r", "<br/>");
        
        // Remove New line from java string and replace html break
        noHTMLString = noHTMLString.replaceAll("n", " ");
        noHTMLString = noHTMLString.replaceAll("'", "&#39;");
        noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
        return noHTMLString;
    }

}
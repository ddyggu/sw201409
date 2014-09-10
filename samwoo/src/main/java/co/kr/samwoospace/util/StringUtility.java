package co.kr.samwoospace.util;

public  interface StringUtility {
	
	  public  String getRelativePath();

	  public  String getUploadPath();

	  public String getThumbnailUploadPath();

	  public String getEditorUploadPath();
	  
	  public  String encodedFileName(String paramString);

	  public  String buildString(Object paramObject1, Object paramObject2);

	  public String getFileExtension(String fileName);
	  
	  public  boolean validTableName(String paramString);

	  public  boolean isIllegalExtension(String paramString);

	  public  boolean isIllegalMimeType(String paramString);
	}
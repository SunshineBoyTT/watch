package com.spring.base.websocket.util;

public class BusinessException extends Exception{
	
	private static final long serialVersionUID = -7617925338905953846L;

	/**   
	 * errCode:错误码
	 * @since Ver 1.1   
	 */   
	private String code;
	
	/**     
	 * getCode(取错误码)     
	 * @return  
	 */
	public String getCode() {
		return code;
	}
	
	/**     
	 * getCode(取错误码)     
	 * @return  
	 */
	public String GetErrorCode() {
		return code;
	}


	public BusinessException(String code) {
		super();
		this.code = code;
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}


	
	public BusinessException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
	public BusinessException(String code, Throwable cause) {
		super(cause);
		this.code = code;
	}
}

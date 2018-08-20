/**
 * 
 */
package com.kishore.anant.messenger.exception.model;

/**
 * @author i351596
 *
 */
public class ErrorMessage {
	
	public String errorMsg;
	public int errorCode;
	public String errorDescription;

	/**
	 * 
	 */
	public ErrorMessage() {
	}

	public ErrorMessage(String errorMsg, int errorCode, String errorDescription) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	

}

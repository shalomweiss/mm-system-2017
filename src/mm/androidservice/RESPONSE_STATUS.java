package mm.androidservice;

public class RESPONSE_STATUS implements ErrorModel {

	public static final int PARAM_FAILED = 0;
	public static final int SUCCESS = 1;
	public static final int GENERAL_ERROR = 2;
	public static final int INVALID_SESSION = 3;
	public static final int DATABASE_ERROR = 4;
	public static final int PASSWORD_ERROR = 5;

	private int code;
	private String message;

	public RESPONSE_STATUS(int status) {
		if (status == RESPONSE_STATUS.SUCCESS) {
			code = mm.constants.Constants.STATUS_SUCCESS;
			message = mm.constants.Constants.SUCCESS;
		}
		if (status == RESPONSE_STATUS.PARAM_FAILED) {
			code = mm.constants.Constants.STATUS_MISSINGPARA;
			message = mm.constants.Constants.ERROR;
		}
		if (status == RESPONSE_STATUS.GENERAL_ERROR) {
			code = mm.constants.Constants.STATUS_ERROR;
			message = mm.constants.Constants.ERROR;
		}
		if (status == RESPONSE_STATUS.INVALID_SESSION) {
			code = mm.constants.Constants.STATUS_ERROR;
			message = mm.constants.Constants.INVALID_SESSION_TOKEN;
		}
		if (status == RESPONSE_STATUS.DATABASE_ERROR) {
			code = mm.constants.Constants.STATUS_DB_ERROR;
			message = mm.constants.Constants.DB_ERROR;
		}
		if (status == RESPONSE_STATUS.PASSWORD_ERROR) {
			code = mm.constants.Constants.STATUS_WRONGPARA;
			message = mm.constants.Constants.WRONGPASSWORD;
		}
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;

	}

}

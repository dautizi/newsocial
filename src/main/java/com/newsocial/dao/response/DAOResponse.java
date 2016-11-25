package com.newsocial.dao.response;

public class DAOResponse {

    protected int    statusCode;
    protected int    errorCode;
    protected String statusReason;
    protected String message;
    protected String callId;
    protected String time;

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCallId() {
        return callId;
    }
    public void setCallId(String callId) {
        this.callId = callId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ResponseDAO [statusCode=" + statusCode + ", errorCode="
                + errorCode + ", statusReason=" + statusReason + ", message="
                + message + ", callId=" + callId + ", time=" + time + "]";
    }

}

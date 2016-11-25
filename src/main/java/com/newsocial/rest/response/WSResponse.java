package com.newsocial.rest.response;

import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.newsocial.dao.response.DAOResponse;
import com.newsocial.rest.error.AppException;
import com.newsocial.util.DatetimeManager;
import com.sun.jersey.api.NotFoundException;

public class WSResponse {

    private int     statusCode;
    private int     errorCode;
    private String  statusReason;
    private String  message;
    private String  callId;
    private String  time;
    private JsonObject  result;

    public WSResponse() {
        this.time = DatetimeManager.getJodaNowInString();
    }

    public WSResponse(JsonObject jsonObject) {
        this.statusCode = Response.Status.OK.getStatusCode();
        this.errorCode = ResponseCodeMap.NOT_ERROR;
        this.time = DatetimeManager.getJodaNowInString();
        this.message = "";
        this.result = jsonObject;
    }

    public WSResponse(AppException appException) {
        this.statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.errorCode = ResponseCodeMap.GENERIC_APP_ERROR;
        this.statusReason = appException.getMessage();
        this.time = DatetimeManager.getJodaNowInString();
    }

    public WSResponse(NotFoundException ex){
        this.statusCode = Response.Status.NOT_FOUND.getStatusCode();
        this.errorCode = ResponseCodeMap.NOT_FOUND;
        this.statusReason = ex.getMessage();
        this.time = DatetimeManager.getJodaNowInString();
    }

    public WSResponse(DAOResponse daoResponse) {
        this.statusCode = daoResponse.getStatusCode();
        this.errorCode = daoResponse.getErrorCode();
        this.message = daoResponse.getMessage();
        this.time = daoResponse.getTime();
    }

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
    public JsonObject getResult() {
        return result;
    }
    public void setResult(JsonObject result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WSResponse [statusCode=" + statusCode + ", errorCode="
                + errorCode + ", statusReason=" + statusReason + ", message="
                + message + ", callId=" + callId + ", time=" + time
                + ", result=" + result + "]";
    }

}

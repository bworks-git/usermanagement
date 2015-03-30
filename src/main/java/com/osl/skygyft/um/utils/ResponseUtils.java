package com.osl.skygyft.um.utils;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.osl.skygyft.um.constants.ApplicationConstants;
import com.osl.skygyft.um.vo.Response;

public class ResponseUtils {

	public static Response buildResponseObject(String operationType, ModelMap model, HttpSession session) {
		Response response = new Response();
		response.setOperationType(operationType);
		if(session.getAttribute("status")!=null){
			response.setStatus((String)session.getAttribute("status"));
			response.setMessage((String)session.getAttribute("message"));
			session.removeAttribute("status");
			session.removeAttribute("message");
		}
		model.put(ApplicationConstants.RESPONSE, response);
		return response;
	}

	public static Response getSuccessResponse(String message) {
		Response response = new Response();
		response.setStatus(ApplicationConstants.SUCCESS);
		response.setMessage(message);
		return response;
	}
	
	public static Response getFailureResponse(String message) {
		Response response = new Response();
		response.setStatus(ApplicationConstants.FAILURE);
		response.setMessage(message);
		return response;
	}
	
	public static Response getErrorResponse() {
		Response response = new Response();
		response.setStatus(ApplicationConstants.ERROR);
		response.setMessage(ApplicationConstants.SERVER_ERROR_MSG);
		return response;
	}
}

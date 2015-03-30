package com.osl.skygyft.um.constants;

import java.util.HashMap;
import java.util.Map;

public abstract class ApplicationConstants {
	
	public static Map<String, String> MESSAGE_MAP;
	public static final String OP_TYPE_ADD = "Add";
	public static final String OP_TYPE_EDIT = "Edit";
	public static final String OP_TYPE_DELETE = "Delete";
	public static final String STATUS = "status";
	public static final String MESSAGE = "message";
	public static final String RESPONSE = "response";
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";
	public static final String ERROR = "Error";
	public static final String SERVER_ERROR_MSG = "Server error! Please try again later";
	static
    {
		MESSAGE_MAP = new HashMap<String, String>();
		MESSAGE_MAP.put(OP_TYPE_ADD, " added successfully");
		MESSAGE_MAP.put(OP_TYPE_EDIT, " updated succesfully");
		MESSAGE_MAP.put(OP_TYPE_DELETE, " deleted succesfully");
    }
}

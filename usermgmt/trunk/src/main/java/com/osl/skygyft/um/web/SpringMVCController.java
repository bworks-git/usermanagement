package com.osl.skygyft.um.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.service.UserService;
import com.osl.skygyft.um.vo.DataTableObject;
import com.osl.skygyft.um.vo.PersonVO;


@Controller
public class SpringMVCController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody DataTableObject<User> springPaginationDataTables(HttpServletRequest  request) throws IOException {
		
    	//Fetch the page number from client
    	Integer pageNumber = 0;
    	if (null != request.getParameter("iDisplayStart"))
    		pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;		
    	
    	//Fetch search parameter
    	String searchParameter = request.getParameter("sSearch");
    	
    	//Fetch Page display length
    	Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
    	
    	//Create page list data
    	List<User> userList = null;
//		createPaginationData(userList);
		//Here is server side pagination logic. Based on the page number you could make call 
		//to the data base create new list and send back to the client. 
		
		//Search functionality: Returns filtered list based on search parameter
    	Integer count = 0;
    	if(StringUtils.isBlank(searchParameter)){
    		count = userService.countUsers();
    		userList = userService.findAllUsers(((pageNumber*pageDisplayLength)-pageDisplayLength), pageDisplayLength);
    	}
    	else{
    		count = userService.countForSearch(searchParameter);
    		userList = userService.findUsersForSearch(((pageNumber*pageDisplayLength)-pageDisplayLength), pageDisplayLength, searchParameter);
    	}
		
		DataTableObject<User> userJsonObject = new DataTableObject<User>();
		
		//Set Total display record
		userJsonObject.setiTotalDisplayRecords(count);
		//Set Total record
		userJsonObject.setiTotalRecords(count);
		userJsonObject.setAaData(userList);
		
	
		return userJsonObject;
    }

	private void createPaginationData(List<User> userList) {
		for(User user : userList){
			User userObj = new User();
//			user.setFirst_name(first_name);
		}
		
	}

	private List<PersonVO> getListBasedOnSearchParameter(String searchParameter,List<PersonVO> userList) {
		
		if (null != searchParameter && !searchParameter.equals("")) {
			List<PersonVO> personsListForSearch = new ArrayList<PersonVO>();
			searchParameter = searchParameter.toUpperCase();
			for (PersonVO person : userList) {
				if (person.getFirst_name().toUpperCase().indexOf(searchParameter)!= -1 || person.getOffice().toUpperCase().indexOf(searchParameter)!= -1
						|| person.getPhone().toUpperCase().indexOf(searchParameter)!= -1 || person.getPosition().toUpperCase().indexOf(searchParameter)!= -1
						|| person.getSalary().toUpperCase().indexOf(searchParameter)!= -1 || person.getStart_date().toUpperCase().indexOf(searchParameter)!= -1) {
					personsListForSearch.add(person);					
				}
				
			}
			userList = personsListForSearch;
			personsListForSearch = null;
		}
		return userList;
	}

	private List<PersonVO> createPaginationData(Integer pageDisplayLength) {
		List<PersonVO> personsList = new ArrayList<PersonVO>();
		for (int i = 0; i < 1; i++) {
		    PersonVO person2 = new PersonVO();
	            person2.setFirst_name("John Landy");
	            person2.setPosition("System Architect");
	            person2.setSalary("$320,800");
	            person2.setOffice("NY");
	            person2.setPhone("999999999");
	            person2.setStart_date("05/05/2010");
	            personsList.add(person2);  
	            
	            person2 = new PersonVO();
	            person2.setFirst_name("Igor Vornovitsky");
	            person2.setPosition("Solution Architect");
	            person2.setSalary("$340,800");
	            person2.setOffice("NY");
	            person2.setPhone("987897899");
	            person2.setStart_date("05/05/2010");
	            personsList.add(person2); 
	            
	            person2 = new PersonVO();
	            person2.setFirst_name("Java Honk");
	            person2.setPosition("Architect");
	            person2.setSalary("$380,800");
	            person2.setOffice("NY");
	            person2.setPhone("1234567890");
	            person2.setStart_date("05/05/2010");
	            personsList.add(person2); 
	            
	            person2 = new PersonVO();
	            person2.setFirst_name("Ramesh Arrepu");
	            person2.setPosition("Sr. Architect");
	            person2.setSalary("$310,800");
	            person2.setOffice("NY");
	            person2.setPhone("4654321234");
	            person2.setStart_date("05/05/2010");
	            personsList.add(person2); 
	            
	            person2 = new PersonVO();
	            person2.setFirst_name("Bob Sidebottom");
	            person2.setPosition("Architect");
	            person2.setSalary("$300,800");
	            person2.setOffice("NJ");
	            person2.setPhone("9876543212");
	            person2.setStart_date("05/05/2010");
	            personsList.add(person2); 
	
		}
		
		for (int i = 0; i < pageDisplayLength-5; i++) {
		    PersonVO person2 = new PersonVO();
	            person2.setFirst_name("Zuke Torres");
	            person2.setPosition("System Architect");
	            person2.setSalary("$320,800");
	            person2.setOffice("NY");
	            person2.setPhone("999999999");
	            person2.setStart_date("05/05/2010");
	            personsList.add(person2);  
		}
		return personsList;
	}
}
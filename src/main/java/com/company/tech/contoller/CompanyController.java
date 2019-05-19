package com.company.tech.contoller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.tech.domain.Company;
import com.company.tech.request.CompanyRequest;
import com.company.tech.response.TechResponse;
import com.company.tech.service.CompanyService;

@RestController
@RequestMapping(value = "/tech/companies")
public class CompanyController {
	
	/*
	 * all request come into this controller class.
	 */
	
	@Autowired
	CompanyService companyService;
	
	/* method for create new company */
	@RequestMapping(method = RequestMethod.POST , value = "/create")
	public TechResponse addCompany(@RequestBody CompanyRequest companyRequest) {
		
		HashMap<String, String> hashMap  = companyService.addNewCompany(companyRequest);
		
		TechResponse techResponse = new TechResponse();
		techResponse.setResponseCode("201");
		techResponse.setResponseObject(hashMap);
		
		return techResponse;
	}
	
	/* method for update existing company */
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}/update")
	public TechResponse updateCompany(@PathVariable("id") int id , @RequestBody CompanyRequest companyRequest) {
		
		HashMap<String, String> hashMap = companyService.updateCompany(id, companyRequest);
		
		TechResponse techResponse = new TechResponse();
		techResponse.setResponseCode("204");
		techResponse.setResponseObject(hashMap);
		
		return techResponse;
	}
	
	/* method for display all registered companies */
	@RequestMapping(method = RequestMethod.GET)
	public TechResponse getAllCompany() {
		
		List<Company> companies = companyService.getCompanies();
		
		TechResponse techResponse = new TechResponse();
		techResponse.setResponseCode("200");
		techResponse.setResponseObject(companies);
		
		return techResponse;
	}
	
	/* method for get deleted companies */
	@RequestMapping(method = RequestMethod.GET , value = "/getInactive")
	public TechResponse getInactiveCompany() {
		
		List<Company> companies = companyService.getInactiveCompanyList();
		
		TechResponse techResponse = new TechResponse();
		techResponse.setResponseCode("200");
		techResponse.setResponseObject(companies);
		
		return techResponse;
		
	}
	
	/* method for delete a particular companys */
	@RequestMapping(method = RequestMethod.PUT , value = "/{companyId}/deleteCompany")
	public TechResponse deleteCompany(@PathVariable("companyId") int companyId) {
		
		HashMap<String, String> hashMap = companyService.deleteCompany(companyId);
		
		TechResponse techResponse = new TechResponse();
		techResponse.setResponseCode("200");
		techResponse.setResponseObject(hashMap);
		
		return techResponse;
	}
}

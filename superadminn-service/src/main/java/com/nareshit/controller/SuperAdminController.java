package com.nareshit.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.proxy.AdminServiceProxy;
import com.nareshit.proxy.HospitalServiceProxy;

@ControllerAdvice
@RestController
@RequestMapping("/superadmin")
public class SuperAdminController {
	/*@Autowired
	private SuperAdminService superService;
*/	
	@Autowired
	private HospitalServiceProxy hospproxy;
	@Autowired
	private AdminServiceProxy adminproxy;

	@PostMapping(value = "/addAdmin",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addAdminBySuperAdmin(@RequestBody String adminBody) {
		JSONObject json = new JSONObject(adminBody);
		System.out.println(json.toString());
		String id = (String) json.get("hospId");
		int hid = Integer.parseInt(id);
		System.out.println(hid);
		String hospInfo = null;
		hospInfo = hospproxy.findHospitalById(hid);
		json.put("hospId", hospInfo);
		System.out.println(hospInfo);
		System.out.println(json);
	ResponseEntity<String> adminInfo = adminproxy.addAdmin(json.toString());
		return new ResponseEntity<>(adminInfo.getBody(), HttpStatus.OK);

	}

}

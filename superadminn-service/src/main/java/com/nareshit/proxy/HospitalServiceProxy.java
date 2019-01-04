package com.nareshit.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="hospital-proxy",url="http://localhost:7070/hospital")
public interface HospitalServiceProxy {
@GetMapping(path="/findHospital/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
public String findHospitalById( @PathVariable("id") int id);
	
}

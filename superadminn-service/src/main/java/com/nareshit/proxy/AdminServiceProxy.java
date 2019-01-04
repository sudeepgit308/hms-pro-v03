package com.nareshit.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="admin-proxy",url="http://localhost:7071/admin")
public interface AdminServiceProxy {
  @PostMapping(path="/addAdmin",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addAdmin(@RequestBody String adminBean);
}

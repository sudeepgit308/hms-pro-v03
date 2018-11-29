package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;
import com.nareshit.utility.HospitalMapper;

@RestController
//@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private IHospitalRepository hospRepo;

	/*@RequestMapping
	public String getHomePage(Model model) {
		String msg = "welcome to hms pro";
		model.addAttribute("message", msg);
		model.addAttribute("hospBean", new HospitalBean());

		return "home";
	}

	@GetMapping(value = "/addHospitalPage")
	public String addHospital(Model model) {

		model.addAttribute("hospBean", new HospitalBean());
		return "hospAdd";
	}
*/	
	
	/*s*/
	@GetMapping(value = "/getAllHospitals")
	public ResponseEntity<List<HospitalBean>> getHospotalBoard() {
	Iterator<Hospital> hospList	=hospRepo.findAll().iterator();
	List<HospitalBean> hospitals = HospitalMapper.mapDomainListToBean(hospList);
		return new ResponseEntity<List<HospitalBean>>(hospitals,HttpStatus.OK);
	}

	@PostMapping(value = "/addHospital")
	public ResponseEntity<List<HospitalBean>> addHospital(@RequestBody HospitalBean hospBean) {
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		Iterator<Hospital> hospList	=hospRepo.findAll().iterator();
		List<HospitalBean> hospitals = HospitalMapper.mapDomainListToBean(hospList);
			return new ResponseEntity<List<HospitalBean>>(hospitals,HttpStatus.OK);
	}

	/*
	 * @GetMapping(value="/getAllHospitals") public String findHospotal(Model model)
	 * { Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
	 * List<HospitalBean> hospBeanList =
	 * HospitalMapper.mapDomainListToBean(hospDomainsList);
	 * model.addAttribute("hospList", hospBeanList);
	 * 
	 * return "hospList"; }
	 */
	@GetMapping(value = "/deleteHospital/{id}")
	public ResponseEntity<List<HospitalBean>> delteHospotal( @PathVariable("id") int id) {
		hospRepo.delete(id);
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospitals = HospitalMapper.mapDomainListToBean(hospDomainsList);
		return new ResponseEntity<List<HospitalBean>>(hospitals,HttpStatus.OK);	
	}

	@GetMapping(value = "/findHospital/{id}")
	public ResponseEntity<HospitalBean> findHospitalById( @PathVariable("id") int id) {
		Hospital hosp = hospRepo.findOne(id);
		HospitalBean hospBean = HospitalMapper.mapDomainToBean(hosp);
		return new ResponseEntity<HospitalBean>(hospBean,HttpStatus.OK);
	}

	@PutMapping(value = "/updateHospital")
	public ResponseEntity<HospitalBean> updateHospotal(@RequestBody HospitalBean hospBean) {
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		// return "addHospital";
		return new ResponseEntity<HospitalBean>(hospBean,HttpStatus.OK);

	}

	/*
	 * @PostMapping(value="/addHospital") public HospitalBean
	 * addHospotal(@RequestBody HospitalBean hospBean) {
	 * 
	 * Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean); hosp =
	 * hospRepo.save(hosp); hospBean = HospitalMapper.mapDomainToBean(hosp); return
	 * hospBean;
	 * 
	 * }
	 */
}

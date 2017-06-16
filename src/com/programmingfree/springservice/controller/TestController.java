package com.programmingfree.springservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfree.springservice.domain.Address;
import com.programmingfree.springservice.domain.MyRequest;
import com.programmingfree.springservice.domain.MyResponse;
import com.programmingfree.springservice.domain.Student;

@RestController
public class TestController {
	
	@RequestMapping(value="/test",method = RequestMethod.GET,headers="Accept=application/json")
	public Student test(){
		System.out.println("TestController.test()");
		Student s = new Student();
		s.setName("Maruti Nandan");
		s.setRollNo(8);
		
		Address a = new Address();
		s.setAddress(a);
		
		a.setCity("Bangalore");
		a.setHouseNo(5);
		
		return s;
	}

	@RequestMapping(value="/testGet",method = RequestMethod.GET,headers="Accept=text/plain")
	public String testGetInput(String name,int roll){
		System.out.println("TestController.testGetInput():" +name + roll);
		return name +"\n"+ roll;
	}
	
	@RequestMapping(value="/testGetObj",method = RequestMethod.GET,headers="Accept=application/json")
	public Student testGetInput2(String name1,int roll){
		System.out.println("TestController.testGetInput():" +name1 + roll);
		Student s = new Student();
		s.setName(name1);
		s.setRollNo(roll);
		
		return s;
	}
	
	@RequestMapping(value="/testPost",method = RequestMethod.POST,headers="Accept=application/json")
	public MyResponse testPost(@RequestBody MyRequest req){
		
		System.out.println("TestController.testPost() :: " +req);
		
		System.out.println("add : " + req.getAdd());
		
		MyResponse res = new MyResponse();
		
		res.setTest1(req.getP1());
		res.setTest2(req.getP2());
		res.setTest3(req.isP3());
		res.setTest4(req.getP4());
		return res;
	}
	
	
}

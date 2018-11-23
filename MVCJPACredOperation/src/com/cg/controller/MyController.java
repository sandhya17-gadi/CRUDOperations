package com.cg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.service.IEmployeeService;
import com.cg.springmvcone.dto.Employee;

@Controller
public class MyController {
	@Autowired
	IEmployeeService employeeservice;
	
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String getAll(){
		return "home";
		
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addEmployee(@ModelAttribute("my") Employee emp, Map<String,Object> model ){
		List<String> myDeg=new ArrayList<>();
		myDeg.add("SoftWare Engg");
		myDeg.add("Sr Consoltant");
		myDeg.add("Manager");
		model.put("deg",myDeg);
		return "addemployee";
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@Valid@ModelAttribute("my") 
	Employee emp,BindingResult result,
			Map<String,Object> model){
		//System.out.println("Name is "+emp.getEmpName());
		int id=0;
		if(result.hasErrors()){
			List<String> myDeg=new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg",myDeg);
			return new ModelAndView("addemployee");
		}else{
		 id=employeeservice.addEmployeeData(emp);
		}
		return new ModelAndView("sucess","edata",id);
		
	}
	@RequestMapping(value="show",method=RequestMethod.GET)
	public ModelAndView showAllEmployee(){
		List<Employee> myAllData=employeeservice.showAllEmployee();
		return new ModelAndView("showall","temp", myAllData);
		}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteEmployee(){
		
		return "deleteemployee";
		
	}
	@RequestMapping(value="dodelete",method=RequestMethod.GET)
	public String employeeDelete(@RequestParam("eid") int id){
		//System.out.println("Id is ..."+id);
		employeeservice.deleteEmployee(id);
		return "sucess";
		
	}
	
	
	/*@RequestMapping(value="update",method=RequestMethod.GET)
	public String employeeUpdate(@ModelAttribute("update1") Employee emp, Map<String,Object> model){
		//System.out.println("Id is ..."+id);
		List<String> myDeg=new ArrayList<>();
		myDeg.add("SoftWare Engg");
		myDeg.add("Sr Consoltant");
		myDeg.add("Manager");
		model.put("deg",myDeg);
		return "update";
		
	}*/
	
	
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateEmployee(){
		
		return "update";
		
	}
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String searchEmployee(){
		
		return "search";
		
	}
	
	
	
	@RequestMapping(value="dosearch",method=RequestMethod.GET)
	public ModelAndView searchEmployee1(@RequestParam("eid") int id){
		Employee emp=employeeservice.searchEmployee(id);
		return new ModelAndView("searchId","temp", emp);
		}
	
	
	@RequestMapping(value="updatedata",method=RequestMethod.POST)
    public ModelAndView updateEmployee(@Valid@ModelAttribute("my1") 
    Employee emp,BindingResult result,
                  Map<String,Object> model){
           //System.out.println("Name is "+emp.getEmpName());
           boolean res=false;
           if(result.hasErrors()){
                  List<String> myDeg=new ArrayList<>();
                  myDeg.add("SoftWare Engg");
                  myDeg.add("Sr Consoltant");
                  myDeg.add("Manager");
                  model.put("deg",myDeg);
                  return new ModelAndView("addemployee");
           }else{
           res=employeeservice.updateEmployee(emp);
           }
           if(res == true){
                  return new ModelAndView("sucess","temp", emp);
           }else{
                  return new ModelAndView("updateError","temp", emp);
           }
           
    }

	
	
	
	
	@RequestMapping(value="doupdatesearch",method=RequestMethod.POST)
	public ModelAndView updateSearch(@RequestParam("eid")int id,@ModelAttribute("my1")Employee emp,Map<String,Object> model){
        Employee emp1=employeeservice.searchEmployee(id);
        if(emp1 != null){
               List<String> myDeg=new ArrayList<>();
               myDeg.add("SoftWare Engg");
               myDeg.add("Sr Consoltant");
               myDeg.add("Manager");
               model.put("deg",myDeg);
               return new ModelAndView("updateEmployee","temp", emp1);
        }else{
               return new ModelAndView("updateerror","emp", id);
        }
        
        }


	
	
	
	
}

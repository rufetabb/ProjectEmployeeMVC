package com.example.projectemployeemvc.controller;


import com.example.projectemployeemvc.dao.entity.Employee;
import com.example.projectemployeemvc.service.EmployeeWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees-web")
public class EmployeeWebController {
    private final EmployeeWebService employeeService;

    public EmployeeWebController(EmployeeWebService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/home")
    public String viewHomePage(Model model){
        var list=employeeService.findAllEmployee();
        model.addAttribute("employees",list);
        return "index";
    }
    @GetMapping("/addnew")
    public String   addEmployee (Model model){
        Employee employee=new Employee();

        model.addAttribute("employee",employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees-web/home";
    }

    @GetMapping("/showAndUpdate/{id}")
    public String updateEmployee(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.updateEmployeeById(id));
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees-web/home";
    }




}

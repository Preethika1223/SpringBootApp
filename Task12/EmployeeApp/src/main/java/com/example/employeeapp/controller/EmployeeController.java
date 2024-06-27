package com.example.employeeapp.controller;

import com.example.employeeapp.model.Employee;
import com.example.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "displayAll";
    }

    @GetMapping("/display")
    public String displayEmployee(@RequestParam String employeeId, Model model) {
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        return "display";
    }
}
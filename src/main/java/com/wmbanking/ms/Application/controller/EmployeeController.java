package com.wmbanking.ms.Application.controller;

import com.wmbanking.ms.Application.entity.Employee;
import com.wmbanking.ms.Application.exception.NotFoundException;
import com.wmbanking.ms.Application.repository.EmployeeRepository;
import org.hibernate.cfg.CreateKeySecondPass;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestParam String name, @RequestParam String role){
        return repository.save(new Employee(name, role));
    }

    @GetMapping("/employee/{id}")
    public EntityModel<Employee> findEmployee(@PathVariable int id){
        Employee employee = repository.findById(id).orElseThrow(() -> new NotFoundException(id));

        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).findEmployee(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees"));
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestParam String name, @RequestParam String role, @PathVariable int id) {
        return repository.findById(id)
                .map(emp -> {
                            emp.setName(name);
                            emp.setRole(role);
                            return repository.save(emp);
                        }).orElseGet(() -> repository.save(new Employee(name, role)));
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        repository.deleteById(id);
    }

}

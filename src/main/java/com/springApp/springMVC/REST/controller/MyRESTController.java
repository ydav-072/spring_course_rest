package com.springApp.springMVC.REST.controller;

import com.springApp.springMVC.REST.entity.Employee;
import com.springApp.springMVC.REST.exceptionHandling.EmployeeIncorrectData;
import com.springApp.springMVC.REST.exceptionHandling.NoSuchEmployeeException;
import com.springApp.springMVC.REST.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = "+
                    id + " in Database");
        }
        return employee;
    }

//    @ExceptionHandler // EmployeeIncorrectData added in body response
//    public ResponseEntity<EmployeeIncorrectData>handleException(
//            NoSuchEmployeeException exception){
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler // EmployeeIncorrectData added in body response
//    public ResponseEntity<EmployeeIncorrectData>handleException(
//            Exception exception){
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }

}

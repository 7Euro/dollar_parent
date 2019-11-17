package com.leo.controller;

import com.leo.dao.DepartmentDao;
import com.leo.dao.EmployeeDao;
import com.leo.entities.Department;
import com.leo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;

/**
 * @author Leo
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list (Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中进行共享
        model.addAttribute("emps",employees);
        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }
}

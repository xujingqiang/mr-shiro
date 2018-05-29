package com.mr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {


    @RequiresPermissions("employee:list")
    @RequestMapping("list")
    public String list(){
        System.out.println("调用员工查询方法");
        return "emp";
    }

    @RequiresPermissions("employee:save")
    @RequestMapping("save")
    public String save(){
        System.out.println("调用员工增加方法");
        return "emp";
    }

    @RequiresPermissions("employee:delete")
    @RequestMapping("delete")
    public String delete(){
        System.out.println("调用员工删除方法");
        return "emp";
    }

    @RequiresPermissions("employee:update")
    @RequestMapping("update")
    public String update(){
        System.out.println("调用员工修改方法");
        return "emp";
    }
}

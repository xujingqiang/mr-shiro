package com.mr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
@RequestMapping("department ")
public class DepartmentController {

    @RequiresPermissions("department:list")
    @RequestMapping("list")
    public String list(){
        System.out.println("调用部门查询方法");
        return "dep";
    }

    @RequiresPermissions("department:save")
    @RequestMapping("save")
    public String save(){
        System.out.println("调用部门增加方法");
        return "dep";
    }

    @RequiresPermissions("department:delete")
    @RequestMapping("delete")
    public String delete(){
        System.out.println("调用部门删除方法");
        return "dep";
    }

    @RequiresPermissions("department:update")
    @RequestMapping("update")
    public String update(){
        System.out.println("调用部门修改方法");
        return "dep";
    }
}

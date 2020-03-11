package com.dk.controller;

import com.dk.pojo.TbUser;
import com.dk.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userController")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("toList")
    public String toList(){
        return "list";
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public Map<Object,Object> getInfo(@RequestParam(defaultValue = "1",required = false)Integer pageNum, @RequestParam(defaultValue = "3",required = false)Integer pageSize){
        PageInfo<TbUser> userList = userService.getInfo(pageNum,pageSize);
        Map<Object, Object> map = new HashMap<>();
        map.put("rows",userList.getList());
        map.put("total",userList.getTotal());
        return map;
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(TbUser tbUser){
        try{
            userService.addUser(tbUser);
            return "true";
        }catch (Exception e){
            return "true";
        }
    }

    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        TbUser tbUser = userService.getInfoById(id);
        model.addAttribute("user",tbUser);
        return "update";
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(TbUser tbUser){
        try{
            userService.updateUser(tbUser);
            return "true";
        }catch (Exception e){
            return "false";
        }

    }


    @RequestMapping("deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id")Integer id){
        try{
            userService.deleteUser(id);
            return "true";
        }catch (Exception e){
            return "false";
        }

    }

    @RequestMapping("deleteAll")
    @ResponseBody
    public String deleteAll(Integer[] ids){
        try{
            userService.deleteAll(ids);
            return "true";
        }catch (Exception e){
            return "false";
        }
    }


}

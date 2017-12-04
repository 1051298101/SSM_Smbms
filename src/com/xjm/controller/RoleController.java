package com.xjm.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xjm.entity.Role;
import com.xjm.entity.User;
import com.xjm.service.RoleService;


@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService rs;
	
	@ResponseBody
	@RequestMapping("findrole.do/{roleCode}")
	public String findRoleByCode(@PathVariable("roleCode") String roleCode){
		String data = "ture";
		int count = rs.findRoleByCode(roleCode);
		if (count > 0) {
			data = "exist";
		}
		return JSONArray.toJSONString(data);
	}
	
	@RequestMapping("addrole.do")
	public String addrole(Role role,HttpSession session){
		role.setCreationDate(new Date());
		User user = (User) session.getAttribute("userSession");
		role.setCreatedBy(user.getId());
		int count = rs.addRole(role);
		if (count > 0) {
			return "redirect:../jsp/role.do";
		}
		return "jsp/roleadd";
	}
	
	@RequestMapping("findrole.do/{id}")
	public String findRoleById(@PathVariable("id") Integer id,Map<String, Object> map){
		Role role = rs.findRoleById(id);
		map.put("role", role);
		return "jsp/rolemodify";
	}
	
	@RequestMapping("updateRoel.do")
	public String updateRole(Role role,HttpSession session){
		User user = (User) session.getAttribute("userSession");
		role.setModifyDate(new Date());
		role.setModifyBy(user.getId());
		int count = rs.updateRole(role);
		if (count > 0) {
			return "redirect:../jsp/role.do";
		}
		return "jsp/rolemodify";
	}
	
	
}

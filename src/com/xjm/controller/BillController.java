package com.xjm.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xjm.entity.Bill;
import com.xjm.entity.User;
import com.xjm.service.BillService;
import com.xjm.service.ProviderService;

@Controller
@RequestMapping("bill")
public class BillController {
	
	@Autowired
	private BillService bs;
	@Autowired
	private ProviderService ps;
	
	@RequestMapping("findbill.do/{id}")
	public String findBill(@PathVariable("id") Integer id,Map<String, Object> map){
		Bill bill = bs.findBillById(id);
		map.put("bill", bill);
		return "jsp/billview";
	}
	
	@RequestMapping("findbill2.do/{id}")
	public String findBill2(@PathVariable("id") Integer id,Map<String, Object> map){
		Bill bill = bs.findBillById(id);
		map.put("bill", bill);
		return "jsp/billmodify";
	}
	
	@RequestMapping("addbill.do")
	public String addBill(@ModelAttribute("bill") @Valid Bill bill,HttpSession session){
		bill.setCreationDate(new Date());
		User user = (User) session.getAttribute("userSession");
		bill.setCreatedBy(user.getId());
		int count = bs.addBill(bill);
		if(count > 0){
			return "redirect:../jsp/bill.do";			
		}
		return "jsp/billadd";
	}
	
	@RequestMapping("updateBill.do")
	public String updateBill(@ModelAttribute("bill") @Valid Bill bill,HttpSession session){
		bill.setModifyDate(new Date());
		User user = (User) session.getAttribute("userSession");
		bill.setModifyBy(user.getId());
		int count = bs.updateBill(bill);
		if(count > 0){
			return "redirect:../jsp/bill.do";			
		}
		return "jsp/billmodify";
	}
	
	@ResponseBody
	@RequestMapping("deletebill.do/{id}")
	public String deletebill(@PathVariable("id") Integer id){
		String data = "false";
		try {
			int count = bs.deleteBill(id);
			if(count > 0){
				data = "true";		
			}			
		} catch (Exception e) {
			e.printStackTrace();
			 data = "notexist";
		}
		return JSONArray.toJSONString(data);
	}
	
}

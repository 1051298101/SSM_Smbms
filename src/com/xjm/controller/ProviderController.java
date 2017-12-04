package com.xjm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.xjm.entity.Provider;
import com.xjm.entity.User;
import com.xjm.service.ProviderService;

@Controller
@RequestMapping("pro")
public class ProviderController {
	
	@Autowired
	private ProviderService ps;
	
	
	@RequestMapping("addProvider.do")
	public String addProvider(@ModelAttribute("provider") @Valid Provider provider,BindingResult result,
				MultipartFile picture,@RequestParam("picturePaths") MultipartFile[] picturePaths,HttpServletRequest req,
					HttpSession session){
		//检测数据是否为空
		if(!result.hasErrors()){
			//文件位置
			String path = req.getSession().getServletContext().getRealPath("photos");
			//1.检测 	企业营业执照
			String err = getErrInfo(picture);
			//2.上传		企业营业执照
			if(err == null){
				String fileName = upload(picture, path);
				provider.setPhotoPath(fileName);
				System.out.println(fileName);
			}
			List<String> errors = new ArrayList<String>();
			List<String> filenames = new ArrayList<String>();
			
			//1.检测		组织机构代码证
			for(MultipartFile picturePath:picturePaths){
				//查询图片是否有问题
				String errs = getErrInfo(picturePath);
				//2.上传		组织机构代码证
				if(errs == null){
					//获取名称
					String fileName = upload(picturePath, path);
					filenames.add(fileName);
				}else{
					errors.add(errs);
				}
			}
			
			if(filenames.size() > 1){
				provider.setPicturePath(filenames.get(0) + ":" + filenames.get(1));
				System.out.println(provider.toString());
			} else if (filenames.size() > 0) {
				provider.setPicturePath(filenames.get(0));
				System.out.println(provider.toString());
			}
			//新增供应商
			provider.setCreationDate(new Date());
			User user = (User) session.getAttribute("userSession");
			provider.setCreatedBy(user.getId());
			int count = ps.addProvider(provider);
			if(count>0){
				return "redirect:../jsp/provider.do";
			}
			req.setAttribute("errors", errors);
			req.setAttribute("filenames", filenames);
		}
		return "jsp/provideradd";
	}
	
	@RequestMapping("findprovider.do/{id}")
	public String findprovider(@PathVariable("id") Integer id,Map<String, Object> map){
		Provider provider = ps.findProById(id);
		map.put("provider", provider);
		String picture[] = provider.getPicturePath().split(":");
		map.put("picture", picture);
		return "jsp/providerview";
	}
	
	@ResponseBody
	@RequestMapping("getproviderlist.do")
	public String getproviderlist(){
		return JSONArray.toJSONString(ps.getAllPro());
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 *	修改上传图片名称
	 * @param photo
	 * @param path
	 * @return
	 */
	public String upload(MultipartFile photo,String path){
		//图片名
		String fileName = photo.getOriginalFilename();
		//时间
		long time = System.currentTimeMillis();
		//随机数
		int randNumber = RandomUtils.nextInt(1000000);
		//拼接
		File dest = new File(path,time+"_"+randNumber+"_"+fileName);
		fileName = time + "_" + randNumber + "_" + fileName;
		try {
			photo.transferTo(dest);
			return fileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 1.上传的文件是否为空
	 * 2.上传文件的大小
	 * 3.上传文件的格式
	 * @param photo
	 * @return null is ok!!!
	 */
	public String getErrInfo(MultipartFile photo){
		String fileName = photo.getOriginalFilename();
		String suf = FilenameUtils.getExtension(fileName);
		String err = null;
		if(photo.isEmpty()){
			err = String.format("%s：上传文件不能为空",fileName);
		}else if(photo.getSize()>500000){
			err = String.format("%s：上传文件大小不能超过500KB",fileName);
		}else if(!formats.contains(suf.toLowerCase())){
			err = String.format("%s：上传文件格式不正确，支持的格式：%s",fileName,formats);
		}
		return err;
	}
	static List<String> formats = new ArrayList<String>();
	static{
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}
	
}

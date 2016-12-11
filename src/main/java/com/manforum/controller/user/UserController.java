package com.manforum.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manforum.dto.DTO;
import com.manforum.pojo.user.User;
import com.manforum.service.user.*;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/showUser",method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public @ResponseBody String findById(@RequestParam(required=false) int id){
		DTO dto = DTO.newDTO();
		try {
			// 模拟数据
			
			User user = this.userService.getUserById(id);
			dto.data = user;
			System.out.println(dto.toJson());
			return dto.toJson();
		} catch (Exception e) {
			e.printStackTrace();
			dto.errMsg = "error";
			dto.errCode = -1;
			return dto.toJson();
		}
	}
//	public String toIndex(HttpServletRequest request,Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
//		return "showUser";
//	}
	//	public String toIndex(HttpServletRequest request,Model model){
//		DTO dto = DTO.newDTO();
//		try {
//			// 模拟数据
//			int userId = Integer.parseInt(request.getParameter("id"));
//			User user = this.userService.getUserById(userId);
//			dto.data = user;
//			return dto.toJson();
//		} catch (Exception e) {
//			e.printStackTrace();
//			dto.errMsg = "error";
//			dto.errCode = -1;
//			return dto.toJson();
//		}
//	}
	
	@RequestMapping(value="/createUser",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	public  String createUser(HttpServletRequest request,
			                  @RequestBody User user){
		
		DTO dto = DTO.newDTO();
		try{
		    int userId = userService.insertUser(user);
		    User searchUser = this.userService.getUserById(userId);
			dto.data = searchUser;
			return dto.toJson();
		   
		}catch (Exception e) {
			e.printStackTrace();
			dto.errMsg = "error";
			dto.errCode = -1;
			return dto.toJson();
		}
	}
	
	
}

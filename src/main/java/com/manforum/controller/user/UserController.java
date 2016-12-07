package com.manforum.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manforum.dto.DTO;
import com.manforum.pojo.user.User;
import com.manforum.service.user.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		DTO dto = DTO.newDTO();
		try {
			// Ä£ÄâÊý¾Ý
			int userId = Integer.parseInt(request.getParameter("id"));
			User user = this.userService.getUserById(userId);
			dto.data = user;
			return dto.toJson();
		} catch (Exception e) {
			e.printStackTrace();
			dto.errMsg = "error";
			dto.errCode = -1;
			return dto.toJson();
		}
	}
	
	@RequestMapping(value="/createUser",method = RequestMethod.POST)
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

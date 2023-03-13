package com.community.kcl;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.community.kcl.service.UserService;
import com.community.kcl.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/userAll.do")
	public String userAll(Model model) {
		ArrayList<UserVO> alist = userService.getAllUser();
		
		model.addAttribute("alist", alist);
		
		return "userAll";
	}
	
	@RequestMapping(value = "/userJoinForm.do")
	public String userJoinForm(@ModelAttribute("UserVO") UserVO uvo, Model model) {
		
		return "userJoinForm";
	}
	
	@RequestMapping(value = "/userJoin.do", method = RequestMethod.POST)
	public String userJoin(@ModelAttribute("UserVO") UserVO uvo, Model model) {
		
		userService.userJoin(uvo);
		
		return "redirect:/userAll.do";
	}
	
	
	@RequestMapping(value = "/loginForm.do")
	public String userLoginForm(@ModelAttribute("UserVO") UserVO uvo, Model model) {
		return "userLoginForm";
	}
	
	@RequestMapping(value = "/userLogin.do", method = RequestMethod.POST)
	public String userLogin(UserVO uvo, String id, String pw, HttpSession session, Model model) {
		
		int result = userService.userLogin(uvo, id, pw);
		
		if(result == 2) {
			return "redirect:/userAll.do";
		}
		else if(result == 3) {
			session.setAttribute("id", id);
			/* model.addAttribute("id", id); */
			return "test";
		}
		else {
			return "userLoginForm";
		}
		
	}
	
	@RequestMapping(value = "/userLogout.do")
	public String userLogout(@ModelAttribute("UserVO") UserVO uvo, HttpSession session) {
		System.out.println("out");
		session.invalidate();
		
		return "test";	// 로그아웃 되었는지 세션 id 날라갔는지 확인하려고 씀
		// return "userLoginForm";
	}
	
	@RequestMapping(value = "/userUpdateForm.do")
	public String userUpdateForm(@ModelAttribute("UserVO") UserVO uvo, Model model, String id) {
		return "userUpdateForm";
	}
	
	@RequestMapping(value = "/userUpdate.do", method = RequestMethod.POST)
	public String userUpdate(UserVO uvo, String id, Model model) {
		userService.userUpdate(uvo, id);
		return "redirect:/userAll.do";
	}
	
	@RequestMapping(value = "/userDeleteForm.do")
	public String userDeleteForm(@ModelAttribute("UserVO") UserVO userVO, Model model) {
		return "userDeleteForm";
	}
	
	@RequestMapping(value = "/userDelete.do", method = RequestMethod.POST)
	public String userDelete(UserVO uvo, String id, String pw, Model model) {
		
		System.out.println("get" + id);
		System.out.println("get" + pw);
		
		int result = userService.userDelete(uvo, id, pw);
		System.out.println("result : " + result);
		
		if(result == 2) {
			System.out.println("con delete!!!");
			return "redirect:/userAll.do";
		}
		else if(result == -1){
			System.out.println("아이디 null");
			return "redirect:/userDeleteForm.do";
		}
		else {
			return "redirect:/userDeleteForm.do";
		}
	}

	
}

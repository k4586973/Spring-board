package com.community.kcl.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.kcl.service.UserService;
import com.community.kcl.service.dao.UserDAO;
import com.community.kcl.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO udao;
	
	@Override
	@Transactional
	public ArrayList<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		return udao.getAllUser();
	}

	@Override
	public void userJoin(UserVO uvo) {
		// TODO Auto-generated method stub
		udao.userJoin(uvo);
	}

	@Override
	public int userLogin(UserVO uvo, String id, String pw) {
		// TODO Auto-generated method stub
		int result = udao.userLogin(uvo).size();
		
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println();
		
		System.out.println("DB" + uvo.getId());
		System.out.println(uvo.getPw());
		
		if(result == 1) {	// id != null
			if(!uvo.getPw().equals(pw)) {
				result = -1;
			}
			else if(id.equals("admin") && pw.equals("1234")) {
				result = 2;
			}
			else if(uvo.getId().equals(id) && uvo.getPw().equals(pw)) {
				result = 3;
			}
			
		}
		else {
			result = 0;
		}
		
		return result;
	}

	@Override
	public int userDelete(UserVO uvo, String id, String pw) {
		// TODO Auto-generated method stub
		
		int result = udao.userLogin(uvo).size();
		
		System.out.println("input" + id);
		System.out.println("input" + pw);
		System.out.println("vo" + uvo.getId());
		System.out.println("vo" + uvo.getPw());
		
		if(result == 1) {	// id != null
			if(!uvo.getPw().equals(pw)) {	// 비밀번호 틀림
				result = 0;
			}
			else if(uvo.getId().equals(id) && uvo.getPw().equals(pw)) {	// 탈퇴 성공 uvo.getId().equals(id) && uvo.getPw().equals(pw)
				System.out.println("delete!!!!");
				udao.userDelete(uvo);
				result = 2;
			}
			
		}
		else {	// id null
			result = -1;
		}
		
	
		return result;
	}

	@Override
	public void userUpdate(UserVO uvo, String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		System.out.println("vo" + uvo.getId());
		if(uvo.getId().equals(id))
			udao.userUpdate(uvo);
		
	}

}

package com.community.kcl.service.dao;

import java.util.ArrayList;

import com.community.kcl.vo.UserVO;

public interface UserDAO {

	ArrayList<UserVO> getAllUser();
	
	UserVO getUserById(UserVO vo);//아이디 가져오기위해서 만들어줘야댐

	void userJoin(UserVO uvo);

	ArrayList<UserVO> userLogin(UserVO uvo);
	
	void userUpdate(UserVO uvo);
	
	void userDelete(UserVO uvo);

}

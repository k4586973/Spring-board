package com.community.kcl.service;

import java.util.ArrayList;

import com.community.kcl.vo.UserVO;

public interface UserService {
	ArrayList<UserVO> getAllUser();

	void userJoin(UserVO uvo);

	int userLogin(UserVO uvo, String id, String pw);
	
	void userUpdate(UserVO uvo, String id);

	int userDelete(UserVO uvo, String id, String pw);

}

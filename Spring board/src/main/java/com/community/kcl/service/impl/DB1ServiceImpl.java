package com.community.kcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.kcl.service.DB1Service;
import com.community.kcl.service.dao.DB1DAO;
import com.community.kcl.service.dao.UserDAO;
import com.community.kcl.vo.DB1VO;
import com.community.kcl.vo.UserVO;

@Service("boardService")
// 여기 서비스 정의는 빈즈에 
public class DB1ServiceImpl implements DB1Service {
	
	@Autowired
	private DB1DAO db1DAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<DB1VO> getBoardList(DB1VO vo) {
		// 이거는 전부 호출
		return db1DAO.getBoardList(vo);
	}

	@Override
	public DB1VO getContent(DB1VO vo) {
		return db1DAO.getContent(vo);
	}

	@Override
	public void insertBoard(DB1VO vo, String userId) {
		
		UserVO searchVO = new UserVO();
		searchVO.setId(userId);
		UserVO user = userDAO.getUserById( searchVO );
		if(user == null) {
			// 존재하지 않는 id 거나 비회원일 경우 처리
//			throw new Exception("에러입니다.");
		}
		vo.setWriter(user.getName()); // 요렇게 하면 
		
		db1DAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(DB1VO vo) {
		db1DAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(DB1VO vo) {
		db1DAO.deleteBoard(vo);
	}

	@Override
	public int countBoardList() {
		// TODO Auto-generated method stub
		return db1DAO.countBoardList();
	}

}

package com.community.kcl.service.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.kcl.vo.DB1VO;

public interface DB1DAO {

	//
	// 

	/*
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(DB1VO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardMapper.insertBoard", vo);
	}

	public void updateBoard(DB1VO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardMapper.updateBoard", vo);
	}

	public void deleteBoard(DB1VO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardMapper.deleteBoard", vo);
	}

	public DB1VO getContent(DB1VO vo) {
		System.out.println("===> Mybatis로 getContent() 기능 처리");
		return (DB1VO) mybatis.selectOne("BoardMapper.getContent", vo);
	}

	public List<DB1VO> getBoardList() {
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardMapper.getBoardList");
	}
	*/

	public void insertBoard(DB1VO vo);

	public void updateBoard(DB1VO vo);

	public void deleteBoard(DB1VO vo);

	public DB1VO getContent(DB1VO vo);

	public List<DB1VO> getBoardList(DB1VO vo);
	
	public int countBoardList();
}

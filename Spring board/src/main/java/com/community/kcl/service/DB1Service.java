package com.community.kcl.service;

import java.util.List;

import com.community.kcl.vo.DB1VO;

public interface DB1Service {

	// 글 목록 조회
	List<DB1VO> getBoardList(DB1VO vo);

	// 글 상세 조회
	DB1VO getContent(DB1VO vo);

	// 글 등록
	void insertBoard(DB1VO vo, String userId);

	// 글 수정
	void updateBoard(DB1VO vo);

	// 글 삭제
	void deleteBoard(DB1VO vo);

	int countBoardList();
}

package com.community.kcl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.community.kcl.service.DB1Service;
import com.community.kcl.vo.DB1VO;

@Controller
public class DB1Controller {

	@Autowired
	private DB1Service boardService;

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(DB1VO vo, Model model) {
		List<DB1VO> boardList = boardService.getBoardList(vo);

		int totalCount = boardService.countBoardList();
		// Model 정보 저장
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("vo", vo);
		return "DB1/boardList"; // View 이름 리턴
	}

	// 글 상세 조회
	@RequestMapping("/getContent.do")
	public String getBoard(DB1VO vo, Model model) {
		// 페이지 사이즈 전달이 추가
		model.addAttribute("board", boardService.getContent(vo)); // Model 정보 저장
		return "DB1/content"; // View 이름 리턴
	}

	// 글 쓰기
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(DB1VO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(vo.toString());

		HttpSession session = request.getSession();
		// 세션은 비어 있을 수 있다.널체크
		if(session == null) {
			// 예외 처리
			throw new Exception("세션이 없어요.");
		}
		String userId = (String) session.getAttribute("id"); // set 한 곳과 동일한 값을 get 한다.
		// userId 를 가져왔다
		// 작성자 
		
		// 파일 업로드 처리
		String fileName = null;
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File("D:\\upload\\" + fileName));
		}
		vo.setFileName(fileName);
		
		boardService.insertBoard(vo, userId);
		
		return "redirect:getBoardList.do";
	}

	// 글 쓰기 페이지 이동
	@RequestMapping("/moveInsertBoard.do")
	public String moveInsertBoard() throws Exception {
		return "DB1/insertBoard";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") DB1VO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(DB1VO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
}

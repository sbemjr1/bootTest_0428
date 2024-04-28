package com.ssafy.boot.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.boot.member.model.MemberDto;
import com.ssafy.boot.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/loginform")
	public String loginform() throws Exception {
		return "/member/login";
	}

	@GetMapping("/signupform")
	public String signupform() throws Exception {
		return "/member/signup";
	}

	@PostMapping("/signup")
	private String signup(MemberDto memberDto, Model model) {

		try {
			service.memberInsert(memberDto);
		} catch (Exception e) {
			model.addAttribute("msg", "회원 가입 중 문제 발생!!!");
			return "error/error";
		}

		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse res, HttpSession session,
			@RequestParam("id") String id, @RequestParam("pw") String pw, Model model, ModelAndView mv) {
		Map<String, String> map = new HashMap<>();
		MemberDto member;
		try {
			map.put("id", id);
			map.put("pw", pw);
			member = service.login(map);
			if (member != null) {
				session.setAttribute("login", id);
			}
		} catch (Exception e) {
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}

		return "redirect:/";
	}

	@GetMapping("/logout")
	public String login(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/memberlist")
	public ModelAndView memberList(ModelAndView mv, HttpSession session) {
		List<MemberDto> list;
		if (session.getAttribute("login") != null) {
			try {
				list = service.memberList();
				mv.addObject("list", list);
				mv.setViewName("/member/memberlist");
			} catch (Exception e) {
				mv.addObject("msg", "리스트 불러오던 중 문제 발생!!!");
				mv.setViewName("error/error");
			}
			return mv;
		}
		mv.setViewName("/member/login");
		return mv;
	}
	
	@GetMapping("/memberupdateform")
	public String memberUpdateForm(@RequestParam("id") String id, Model model) {
		MemberDto memberDto;
		try {
			memberDto = service.memberById(id);
			model.addAttribute("m", memberDto);
		} catch (Exception e) {
			model.addAttribute("msg", "업데이트 폼 이동 중 문제 발생!!!");
			return "error/error";
		}

		return "/member/memberupdate";
	}
	
	@PostMapping("/memberupdate")
	public String memberUpdate(MemberDto memberDto, Model model) {
		try {
			service.memberUpdate(memberDto);
		} catch (Exception e) {
			model.addAttribute("msg", "업데이트 중 문제 발생!!!");
			return "error/error";
		}

		return "redirect:/member/memberlist";
	}
	
	@PostMapping("/memberdelete")
	public String memberDelete(MemberDto memberDto, Model model) {
		// update logic 처리 하고
		try {
			service.memberDelete(memberDto.getId());
		} catch (Exception e) {
			model.addAttribute("msg", "삭제 중 문제 발생!!!");
			return "error/error";
		}

		return "redirect:/member/memberlist";
	}
	
	@PostMapping("/memberdeleteall")
	public String memberDeleteAll(@RequestParam(value = "memberdels", required = false) String[] memberdels)
			throws Exception {
		if (memberdels != null) {
			service.memberAllDelete(memberdels);
		}
		return "redirect:/member/memberlist";
	}
}

package com.ssafy.boot.member.service;

import java.util.List;
import java.util.Map;

import com.ssafy.boot.member.model.MemberDto;

public interface MemberService {
	public void memberInsert(MemberDto m) throws Exception;

	public List<MemberDto> memberList() throws Exception;

	public MemberDto memberById(String id) throws Exception;

	public MemberDto login(Map<String, String> map) throws Exception;

	public void memberUpdate(MemberDto memberDto) throws Exception;

	public void memberDelete(String id) throws Exception;

	public void memberAllDelete(String[] ids) throws Exception;
}

package com.ssafy.boot.member.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.boot.member.model.MemberDto;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	@Autowired
	SqlSession session;
	private String ns = "com.ssafy.boot.member.repository.MemberRepository.";

	@Override
	public void memberInsert(MemberDto memberDto) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberDto", memberDto);
		session.insert(ns + "memberInsert", map);
	}

	@Override
	public List<MemberDto> memberList() throws Exception {
		return session.selectList(ns + "memberList");
	}

	@Override
	public MemberDto memberById(String id) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return session.selectOne(ns + "memberById", id);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return session.selectOne(ns + "login", map);
	}

	@Override
	public void memberUpdate(MemberDto memberDto) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberDto", memberDto);
		session.update(ns+"memberUpdate", map);
	}

	@Override
	public void memberDelete(String id) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		session.update(ns+"memberDelete", map);
	}

}

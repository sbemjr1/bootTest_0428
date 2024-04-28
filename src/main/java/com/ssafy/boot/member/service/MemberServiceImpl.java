package com.ssafy.boot.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.boot.member.model.MemberDto;
import com.ssafy.boot.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repo;

	@Override
	public void memberInsert(MemberDto memberDto) throws Exception {
		repo.memberInsert(memberDto);
	}

	@Override
	public List<MemberDto> memberList() throws Exception {
		return repo.memberList();
	}

	@Override
	public MemberDto memberById(String id) throws Exception {
		return repo.memberById(id);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return repo.login(map);
	}

	@Override
	public void memberUpdate(MemberDto memberDto) throws Exception {
		repo.memberUpdate(memberDto);
	}

	@Override
	public void memberDelete(String id) throws Exception {
		repo.memberDelete(id);
	}

	@Override
	public void memberAllDelete(String[] ids) throws Exception {
		for (int i = 0; i < ids.length; i++) {
			repo.memberDelete(ids[i]);
		}
	}

}

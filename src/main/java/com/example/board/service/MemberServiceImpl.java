package com.example.board.service;

import com.example.board.mapper.MemberMapper;
import com.example.board.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Override
    public Member login(Member member) {

        return memberMapper.selectLogin(member);
    }

}

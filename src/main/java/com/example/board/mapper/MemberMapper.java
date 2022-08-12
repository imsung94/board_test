package com.example.board.mapper;

import com.example.board.entity.MemberEntity;
import com.example.board.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member selectLogin(Member member);

}

package com.example.board.controller;

import com.example.board.entity.MemberEntity;
import com.example.board.service.MemberService;
import com.example.board.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemeberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/index")
    public String index() {
        return "/index";
    }

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/logOut")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.invalidate();

        return "/index";
    }

    @RequestMapping(value="/login_ajax")
    @ResponseBody
    public Map<String, Object> login_ajax(Member member, HttpServletRequest request, Model model) {

        request.getRemoteAddr(); //jpv6

        Map<String, Object> map = new HashMap<>();

        Member mVo = memberService.login(member);	// 전체리스트 가져오기

        map.put("", mVo); //리스트 가져와서 넣기

        if(mVo==null) {
            map.put("flag", "fail");
            map.put("msg", "아이디와 패스워드가 일치하지 않습니다.");
        }else {
            map.put("flag", "success");
            map.put("msg", "로그인 성공!");

            HttpSession session = request.getSession();
            session.setAttribute("session_flag", "success");
            session.setAttribute("session_id", mVo.getUserId());
            session.setAttribute("password", mVo.getPassword());
        }
        return map;
    }


}

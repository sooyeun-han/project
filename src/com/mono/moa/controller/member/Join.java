package com.mono.moa.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mono.moa.controller.Controller;
import com.mono.moa.util.MailUtil;

public class Join implements Controller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "member/join";
		if(req.getSession().getAttribute("SID") != null) {
			req.setAttribute("isRedirect", true);
			view = "/moa/main.moa";
		}
		
		//MailUtil.gmailSend("인증번호 안내", "고객님의 인증번호는 1234 입니다", "start_river@naver.com");
		return view;
	}

}

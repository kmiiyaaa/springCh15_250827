package com.kmii.vali;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk") //유저가 입력한 값이 유효한 값인지 체크->validation(유효성 체크)
	public String joinOk(StudentDto studentDto, Model model, BindingResult result) {
		//studentDto->유저가 입력한 4개의 값이 초기화된 상태의 객체
		
		//아이디가 공란이면 error
		//비밀번호가 공란이면 error
		//나이가 20세 미만이어야 학생회원 가입 가능-> 20세 이상이면 error
		StudentValidator validator = new StudentValidator();
		validator.validate(studentDto, result);
		//result가 발생한 error를 받은 결과
		
		if(result.hasErrors()) { //result 내에 error가 1개라도 있으면 true, 에러가 1개도 없으면 false
			model.addAttribute("error", "error");
			return "join"; //가입 실패->회원 가입 패이지로 돌려보내기
		}
		
		model.addAttribute("sDto", studentDto);
		
		return "joinOk"; //가입 성공->회원 가입 성공 페이지로 이동
	}
	
}

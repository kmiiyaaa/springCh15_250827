package com.kmii.vali;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { //검증할 객체(studetnDto)의 클래스 타입 정보
		// TODO Auto-generated method stub
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentDto studentDto = (StudentDto) target;
		
		String id = studentDto.getId(); //유저가 가입할 때 입력한 아이디
		String pw = studentDto.getPw(); //유저가 가입할 때 입력한 비밀번호
		int age = studentDto.getAge(); //유저가 가입할 때 입력한 나이
		
		if(id.strip().isEmpty() || id == null) { //두 조건 중에 한개라도 참이면 error
			System.out.println("에러가 발생된 아이디 : " + id);
			errors.rejectValue("id", "id가 공란입니다!"); //(에러가 발생한 필드 이름, 에러코드(메시지))
		}
		
		if(pw.strip().isEmpty() || pw == null) { //두 조건 중에 한개라도 참이면 error
			System.out.println("에러가 발생된 비밀번호 : " + pw);
			errors.rejectValue("pw", "비밀번호가 공란입니다!"); //(에러가 발생한 필드 이름, 에러코드(메시지))
		}
		
		if(age > 19 || age <0) { //나이가 19세 초과일 경우 학생회원 자격 없음->error, 나이값이 음수일 경우 error
			errors.rejectValue("age", "19세 초과면 학생가입 불가능합니다!"); //(에러가 발생한 필드 이름, 에러코드(메시지))
		}
	}

}
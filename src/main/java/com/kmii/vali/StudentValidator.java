package com.kmii.vali;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {   // 검증할 객체 (StudentDto)의 클래스 타입 정보
		// TODO Auto-generated method stub
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentDto studentDto = (StudentDto)target;
		
		String id = studentDto.getId();  // 유저가 가입할때 입력한 아이디
		String pw = studentDto.getPw();
		int age = studentDto.getAge();
		
		if(id.strip().isEmpty() || id == null ){ // 두 조건중 하나라도 참이면 erorr
			System.out.println("에러가 발생된 에이디 + " +id);  // 
			errors.rejectValue("id", "trouble");  // ( 에러가 발생한필드 이름, 에러코드(메시지)
			
		}
		
		if(pw.strip().isEmpty() || pw == null ){ // 두 조건중 하나라도 참이면 erorr
			System.out.println("에러가 발생된 비밀번호 + " +pw);  // 
			errors.rejectValue("pw", "trouble2");  // ( 에러가 발생한필드 이름, 에러코드(메시지)
			
		}
		
		if(age>19 || age<0) { // 나이가 19세 초과일 경우 학생회원 자격 없음error
			errors.rejectValue("age","trouble3");  //( 에러가 발생한필드 이름, 에러코드(메시지)
			
			
		}
		
		
	}

}

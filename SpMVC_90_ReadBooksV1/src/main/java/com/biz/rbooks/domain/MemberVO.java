package com.biz.rbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberVO {

	// 로그인정보 테이블 명세
	
	public String m_id; //	varchar2(20) , ID
	public String m_password; //	nvarchar2(125)  , 비밀번호 
	public String m_login_date; //	varchar2(10)  , 최종로그인
	public String m_rem; //	nvarchar2(125)  , 기타

}

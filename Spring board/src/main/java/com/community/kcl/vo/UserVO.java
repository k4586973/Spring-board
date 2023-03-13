package com.community.kcl.vo;
/*
CREATE TABLE user1(
       uno   number(10) NOT NULL,-- 시퀀스를 받기위해 사용
       id varchar2(40) NOT NULL, -- ID 10자리
       pw varchar2(40), -- 비밀번호 최대 16자리
       name varchar2(10), -- 이름
       birth varchar2(30), -- 생년월일
       tel varchar2(30), -- 번호
       
       CONSTRAINT pk_user1 PRIMARY KEY(id)
   );
*/
public class UserVO {
	
	private int uno;
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String tel;
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}

package com.itwill.shop.member;

public class MemberSQL {
	public static final String MEMBER_INSERT = "insert into Member(m_id, m_name ,m_pw, m_phone, m_email, m_address) values(?,?,?,?,?,?)";
	public static final String MEMBER_SELECT_BY_ID = "select m_id, m_name ,m_pw, m_phone, m_email, m_address  from Member where m_id=?";
	public static final String MEMBER_REMOVE = "delete from Member where m_id=?";
	public static final String MEMBER_UPDATE = "update Member set m_name=?, m_phone=?, m_email=? , m_address=? where m_id=?";
	public static final String MEMBER_SELECT_BY_ID_COUNT = "select count(*) from Member where m_id=?";
	public static final String MEMBER_SELECT_BY_ALL = "select * from Member";
	
	
	
}

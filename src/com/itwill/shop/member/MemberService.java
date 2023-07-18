package com.itwill.shop.member;

/*
 * - 쇼핑몰 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - UI(SWING,서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
public class MemberService {
	private MemberDao userDao;
	public MemberService() throws Exception {
		userDao=new MemberDao();
	}
	
	
	/*
	 * 회원가입
	 */
	public int create(Member member) throws Exception{
		//1.아이디중복체크
		if(userDao.countByMemberId(member.getM_Id())>=1) {
			//중복
			return -1;
		}else {
			//가입
			int rowCount=userDao.insert(member);
			return rowCount;
		}
	}
	
	/*
	 * 회원로그인
	 */
	public int login(String m_Id,String m_Pw)throws Exception{
		/*
		 * 0 : 실패
		 * 1 : 성공
		 * 
		 */
		int result=0;
		if(userDao.countByMemberId(m_Id)==1) {
			//아이디존재하는경우
			Member loginUser = userDao.findById(m_Id);
			if(loginUser.getM_Pw().equals(m_Id)) {
				//패쓰워드일치
				result=1;
			}else {
				//패쓰워드불일치
				result=0;
			}
		}else {
			//회원이아닌경우
			result=0;
		}
		return result;
	}
	
	
	/*
	 * 회원로그아웃
	 */
	public void logout() {
		/*
		 * 로그아웃시 DB작업이필요하다면 기술함
		 */
	}
	/*
	 * 로그인한 회원의 정보보기
	 */
	public Member findUser(String m_Id) throws Exception{
		return userDao.findById(m_Id);
	}
	/*
	 * 회원수정
	 */
	public int update(Member user)throws Exception{
		return userDao.update(user);
	}
	/*
	 * 아이디중복체크
	 */
	public boolean isDuplicateId(String m_Id) throws Exception{
		if(userDao.countByMemberId(m_Id)>=1) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 회원탈퇴
	 */
	public int remove(String m_Id) throws Exception{
		return userDao.delete(m_Id);
	}
	
}

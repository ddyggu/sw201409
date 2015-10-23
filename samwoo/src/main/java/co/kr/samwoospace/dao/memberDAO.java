package co.kr.samwoospace.dao;

import co.kr.samwoospace.bean.Member;

public interface memberDAO {
	Member isAdminMember(Member member);
	Member getAdminMemberInfo();
	void updateAdminMember(Member member);
}

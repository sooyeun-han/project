package com.mono.moa.sql;

public class MemberSQL {
	
	public final int SEL_ID_CHECK 	= 1001;
	public final int SEL_LOGIN 		= 1002;
	public final int SEL_ID_INFO 	= 1003;
	public final int SEL_MEMB_LIST 	= 1004;
	
	public final int EDIT_MEMB	 	= 2001;
	
	public final int ADD_MEMB 		= 3001;

	public String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		
		case SEL_LOGIN:
			buff.append("SELECT ");
			buff.append("count(*) cnt ");
			buff.append("FROM ");
			buff.append("member ");
			buff.append("WHERE ");
			buff.append("isShow = 'Y' ");
			buff.append("AND id = ? ");
			buff.append("AND pw = ? ");
			break;
		
		case SEL_ID_CHECK:
			buff.append("SELECT ");
			buff.append("count(*) cnt ");
			buff.append("FROM ");
			buff.append("member ");
			buff.append("WHERE ");
			buff.append("isShow = 'Y' ");
			buff.append("AND id = ? ");
			break;		
			
		case SEL_ID_INFO:
			buff.append("SELECT ");
			buff.append("* ");
			buff.append("FROM ");
			buff.append("member ");
			buff.append("WHERE ");
			buff.append("isShow = 'Y' ");
			buff.append("AND id = ? ");
			break;	
		
		case SEL_MEMB_LIST:
			buff.append("SELECT ");
			buff.append("    * ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");	// 현재 활동중인 회원만 꺼내온다.
			buff.append("ORDER BY ");
			buff.append("    mno DESC ");
			break;
		
		case EDIT_MEMB:
			buff.append("UPDATE member ");
			buff.append("SET ");
			buff.append("    name = ?, pw = ?, tel = ?, email = ?, gen = ?, birth = ? ");
			buff.append("WHERE ");
			buff.append("    id = ? ");

			break;	
			
		case ADD_MEMB:
			buff.append("INSERT INTO ");
			buff.append("member ");
			buff.append("    (mno, name, id, pw, tel, email, gen, birth) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), ");
			buff.append("    ?, ?, ?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}

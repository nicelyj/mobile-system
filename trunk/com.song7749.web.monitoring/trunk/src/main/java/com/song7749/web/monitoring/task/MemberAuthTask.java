package com.song7749.web.monitoring.task;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.service.MemberManager;

/**
 * <pre>
 * Class Name : MemberAuthTask.java
 * Description : ȸ�� �������� ��ġó��
 * �ѽð��� �ѹ��� ȸ�� �α��� ���� ������ �����Ѵ�.
 * 
 *  Modification Information
 *  Modify Date 	Modifier		Comment
 * -----------------------------------------------
 *  2011. 9. 8.	song7749		    �ű� ����
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 8.
 */
@Component
public class MemberAuthTask {
	@Autowired
	private MemberManager memberManager;

	// �Ž� ������ �ѹ� ���� ��
	@Scheduled(fixedRate = 60 * 60 * 1000)
	public void deleteMemberAuth() {
		MemberAuth memberAuth = new MemberAuth();

		// 1�ð��� ������ select
		Calendar cal = Calendar.getInstance();
		cal.add(cal.HOUR, -1);
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd h:m:s");
		memberAuth.setEndDate(dFormat.format(cal.getTime()));

		ArrayList<MemberAuth> memberAuthList = memberManager
				.selectMemberAuthListByMemberAuth(memberAuth);

		try {
			memberManager.deleteMemberAuthBatch(memberAuthList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
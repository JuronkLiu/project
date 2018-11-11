package com.service;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��30��---����2:08:20 
*/

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.ZhangWuDao;
import com.domain.ZhangWu;

public class ZhangWuService {

	private ZhangWuDao zhangWuDao = new ZhangWuDao();

	public List<ZhangWu> selectAll() {
		try {
			return zhangWuDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��������ѯ���񷽷�
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ZhangWu> select(String start, String end) {
		try {
			//��ѯ���ݿ����ݴ���ڼ����У��ڼ����в��ҷ�������������
			List<ZhangWu> selectAll = selectAll();
			List<ZhangWu> select = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);
			
			for (ZhangWu zhangWu : selectAll) {
				Date createtime = sdf.parse(zhangWu.getCreatetime());
				if (createtime.getTime() >= startDate.getTime() && createtime.getTime() <= endDate.getTime() ) {
					select.add(zhangWu);
				}
			}
			return select;
			
			//ֱ�������ݿ��в�������
//			return zhangWuDao.select(startDate, startEnd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �������
	 * @param zw
	 */
	public void addZhangWu(ZhangWu zhangWu) {
		try {
			zhangWuDao.addZhangWu(zhangWu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �༭����
	 * @param zw
	 */
	public void editZhangWu(ZhangWu zw) {
		try {
			zhangWuDao.editZhangWu(zw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ������
	 * @param zwid
	 */
	public void deleteZhangWu(Integer zwid) {
		try {
			zhangWuDao.deleteZhangWu(zwid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������id��������
	 * @param zwid
	 * @return
	 */
	public boolean findZWById(Integer zwid) {
		List<ZhangWu> selectAll = selectAll();
		for (ZhangWu zhangWu : selectAll) {
			if (zwid == zhangWu.getZwid()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ҳ
	 * @param pageNow
	 * @param pageSize 
	 */
	public List<ZhangWu> selectByPage(int pageNow, int pageSize) {
		try {
			return zhangWuDao.selectByPage(pageNow,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<ZhangWu> selectAll = selectAll();
//		List<ZhangWu> selectByPage = new ArrayList<>();
//		for (int i = (pageNow-1)*pageSize; i < (pageNow-1)*pageSize + pageSize; i++) {
//			selectByPage.add(selectAll.get(i));
//		}
//		return selectByPage;
		return null;
	}

	/**
	 * �������ݵ�����
	 * @return
	 */
	public int getNum() {
		return selectAll().size();
	}

}

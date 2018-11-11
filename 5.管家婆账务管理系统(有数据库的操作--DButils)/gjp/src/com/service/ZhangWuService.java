package com.service;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月30日---下午2:08:20 
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
	 * 按条件查询账务方法
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ZhangWu> select(String start, String end) {
		try {
			//查询数据库数据存放在集合中，在集合中查找符合条件的数据
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
			
			//直接在数据库中查找数据
//			return zhangWuDao.select(startDate, startEnd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加账务
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
	 * 编辑账务
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
	 * 删除账务
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
	 * 按账务id查找账务
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
	 * 分页
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
	 * 返回数据的数量
	 * @return
	 */
	public int getNum() {
		return selectAll().size();
	}

}

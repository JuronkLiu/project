package com.dao;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月30日---下午2:08:04 
*/

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.ZhangWu;
import com.tools.JDBCUtils;

public class ZhangWuDao {

	QueryRunner qr = new QueryRunner();
	Connection conn = JDBCUtils.getConnection();

	/**
	 * 查询所有账务
	 */
	public List<ZhangWu> selectAll() throws SQLException {
		String sql = "select * from gjp_zhangwu";
		return qr.query(conn, sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
	}

	/**
	 * 按条件查询账务方法
	 * 
	 * @param startDate
	 * @param startEnd
	 * @return
	 * @throws SQLException
	 */
	public List<ZhangWu> select(Date startDate, Date startEnd) throws SQLException {
		String sql = "select * from gjp_zhangwu where createtime between ? and ?";
		Object[] params = { startDate, startEnd };
		return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class), params);
	}

	/**
	 * 添加账务
	 * 
	 * @param zw
	 * @throws SQLException
	 */
	public void addZhangWu(ZhangWu zw) throws SQLException {
		// Connection conn = JDBCUtils.getConnection();
		String sql = "insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) values(?,?,?,?,?)";
		Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription() };
		qr.update(conn, sql, params);

	}

	/**
	 * 编辑账务
	 * 
	 * @param zw
	 * @throws SQLException
	 */
	public void editZhangWu(ZhangWu zw) throws SQLException {
		// Connection conn = JDBCUtils.getConnection();
		String sql = "update gjp_zhangwu set flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription(),
				zw.getZwid() };
		qr.update(conn, sql, params);
	}

	/**
	 * 删除账务
	 * 
	 * @param zwid
	 * @throws SQLException
	 */
	public void deleteZhangWu(Integer zwid) throws SQLException {
		// Connection conn = JDBCUtils.getConnection();
		String sql = "delete from gjp_zhangwu where zwid=?";
		qr.update(conn, sql, zwid);
	}

	/**
	 * 分页查询
	 * @param pageSize 
	 * @param pageNow 
	 * @return 
	 * @throws SQLException 
	 */
	public List<ZhangWu> selectByPage(int pageNow, int pageSize) throws SQLException {
		String sql = "select * from gjp_zhangwu limit ?,?";
		Object[] params = {(pageNow-1)*pageSize,pageSize};
		return qr.query(conn, sql, new BeanListHandler<ZhangWu>(ZhangWu.class),params);
	}
}

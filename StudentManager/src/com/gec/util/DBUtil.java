package com.gec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DBUtil<T> {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8", "root",
					"root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 通用更新模板方法
	public boolean update(String sql, List<Object> obj) {
		int row = 0;
		try {
			pst = getConn().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.size(); i++) {
					pst.setObject(i + 1, obj.get(i));
				}
			}
			row = pst.executeUpdate();
			if (row > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose(conn, pst, rs);
		}
		return false;
	}

	// 通用查询模板方法
	public List<T> query(String sql, Object...obj) {
		List<T> list = new ArrayList<>();
		try {
			pst = getConn().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			rs = pst.executeQuery();
			while(rs.next()){
				//将重写方法获取的对象,放入集合中
				list.add(getEntity(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose(conn, pst, rs);
		}
		return list;
	}

	//通过子类实现类,具体重写获取rs的方法
	public abstract T getEntity(ResultSet rs) throws Exception;

	
	//查询出总记录数
	public int queryCount(String sql,Object...obj){
		int row = 0;
		try {
			pst = getConn().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			rs = pst.executeQuery();
			if(rs.next()){
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose(conn, pst, rs);
		}
		return row;
	}
	
	public void getClose(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

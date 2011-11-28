package com.song7749.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapSession;
import com.song7749.util.database.model.DatabaseProcessForMysql;
import com.song7749.util.database.model.DatabaseStateForMysql;

public class DatabaseStateUtil {
	private static Logger logger = Logger.getLogger(DatabaseStateUtil.class);

	public static ArrayList<DatabaseStateForMysql> getMysqlDatabaseState(
			SqlMapClientTemplate dataSource) throws SQLException {
		String sql = "show status";
		PreparedStatement statement = null;
		ResultSet rs = null;
		SqlMapSession session = dataSource.getSqlMapClient().openSession();
		try {

			statement = session.getDataSource().getConnection()
					.prepareStatement(sql);
			rs = statement.executeQuery();
			ArrayList<DatabaseStateForMysql> stateList = new ArrayList<DatabaseStateForMysql>();
			while (rs.next()) {
				DatabaseStateForMysql databaseStateForMysql = new DatabaseStateForMysql();
				databaseStateForMysql.setName(rs.getString("Variable_name"));
				databaseStateForMysql.setValue(rs.getString("Value"));
				stateList.add(databaseStateForMysql);
			}
			return stateList;
		} catch (SQLException e) {
			throw e;
		} finally {
			rs.close();
			statement.getConnection().close();
			statement.close();
			session.close();
		}
	}

	public static ArrayList<DatabaseProcessForMysql> getMysqlDatebaseProcess(
			SqlMapClientTemplate dataSource) throws SQLException {
		String sql = "show processlist";
		PreparedStatement statement = null;
		ResultSet rs = null;
		SqlMapSession session = dataSource.getSqlMapClient().openSession();
		try {
			statement = session.getDataSource().getConnection().prepareStatement(sql);
			rs = statement.executeQuery();
			ArrayList<DatabaseProcessForMysql> stateList = new ArrayList<DatabaseProcessForMysql>();
			while (rs.next()) {
				DatabaseProcessForMysql databaseProcessForMysql = new DatabaseProcessForMysql();
				databaseProcessForMysql.setCommand(rs.getString("Command"));
				databaseProcessForMysql.setDb(rs.getString("db"));
				databaseProcessForMysql.setHost(rs.getString("Host"));
				databaseProcessForMysql.setId(rs.getString("Id"));
				databaseProcessForMysql.setInfo(rs.getString("Info"));
				databaseProcessForMysql.setState(rs.getString("State"));
				databaseProcessForMysql.setTime(rs.getString("Time"));
				databaseProcessForMysql.setUser(rs.getString("User"));

				stateList.add(databaseProcessForMysql);
			}
			return stateList;
		} catch (SQLException e) {
			throw e;
		} finally {
			rs.close();
			statement.getConnection().close();
			statement.close();
			session.close();
		}
	}

	public static Integer killMysqlDatebaseProcess(
			Integer id,
			SqlMapClientTemplate dataSource) throws SQLException {
		String sql = "kill "+ id;
		PreparedStatement statement = null;
		SqlMapSession session = dataSource.getSqlMapClient().openSession();
		try {
			statement = session.getDataSource().getConnection().prepareStatement(sql);
			statement.executeQuery();
			return id;
		} catch (SQLException e) {
			throw e;
		} finally {
			statement.getConnection().close();
			statement.close();
			session.close();
		}
	}
}
package com.song7749.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.util.database.model.DatabaseProcessForMysql;
import com.song7749.util.database.model.DatabaseStateForMysql;

public class DatabaseStateUtil {
	public static ArrayList<DatabaseStateForMysql> getMysqlDatabaseState(
			SqlMapClientTemplate dataSource) throws SQLException {
		String sql = "show status";
		try {
			java.sql.PreparedStatement statement = dataSource.getDataSource()
					.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
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
		}
	}

	public static ArrayList<DatabaseProcessForMysql> getMysqlDatebaseProcess(
			SqlMapClientTemplate dataSource) throws SQLException {
		String sql = "show processlist";
		try {
			PreparedStatement statement = dataSource.getDataSource()
					.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
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
		}
	}
}

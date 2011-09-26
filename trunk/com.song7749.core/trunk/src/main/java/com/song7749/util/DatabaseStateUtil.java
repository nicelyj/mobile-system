package com.song7749.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseStateUtil {
	public static ArrayList<HashedMap> getMysqlDatabaseState(SqlMapClientTemplate dataSource) throws SQLException{
		String sql = "show status";
		try {
			PreparedStatement statement = (PreparedStatement) dataSource.getDataSource().getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			ArrayList<HashedMap> stateListHashedMap = new ArrayList<HashedMap>();  
			while(rs.next()){
				HashedMap state = new HashedMap();
				state.put("name", rs.getString("Variable_name"));
				state.put("value", rs.getString("Value"));
				stateListHashedMap.add(state);
			}
			return stateListHashedMap;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static ArrayList<HashedMap> getMysqlDatebaseProcess(SqlMapClientTemplate dataSource) throws SQLException{
		String sql = "show processlist";
		try {
			PreparedStatement statement = (PreparedStatement) dataSource.getDataSource().getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			ArrayList<HashedMap> stateListHashedMap = new ArrayList<HashedMap>();  
			while(rs.next()){
				HashedMap state = new HashedMap();
				state.put("id", rs.getString("Id"));
				state.put("user", rs.getString("User"));
				state.put("host", rs.getString("Host"));
				state.put("db", rs.getString("db"));
				state.put("command", rs.getString("Command"));
				state.put("time", rs.getString("Time"));
				state.put("state", rs.getString("State"));
				state.put("info", rs.getString("Info"));
				stateListHashedMap.add(state);
			}
			return stateListHashedMap;
		} catch (SQLException e) {
			throw e;
		}
	}
}

package com.song7749.mds.servers.model.type;

public enum ServerType {
	WEB_JAVA(1,"JAVA WEB SERVICE"),
	WEB_PHP(2,"PHP WEB SERVICE"),
	DB_ORACLE(3,"ORACLE DB SERVICE"),
	DB_MYSQL(3,"MYSQL DB SERVICE");
	
	private Integer serverTypeCode;
	private String severTypeDescription;
	
    ServerType(Integer serverTypeCode, String severTypeDescription) { 
        this.serverTypeCode = serverTypeCode;
    	this.severTypeDescription = severTypeDescription; 
    } 
    public String getSeverTypeDescription() { 
        return this.severTypeDescription; 
    } 

    public Integer getServerTypeCode() { 
        return this.serverTypeCode; 
    } 
}

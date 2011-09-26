package com.song7749.mds.servers.model.type;

public enum ServerType {
	WEB_JAVA(1,"JAVA WEB SERVICE"),
	WEB_PHP(2,"PHP WEB SERVICE"),
	DB_MYSQL(3,"MYSQL DB SERVICE"),
	DB_ORACLE(4,"ORACLE DB SERVICE");
	
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
    
    public static String getServerTypeDescriptionFromCode(Integer code){
    	for(ServerType servertype : ServerType.values()){
    		if(servertype.serverTypeCode.equals(code)){
    			return servertype.severTypeDescription;
    		}
    	}
    	return null;
    }

    public static Integer getServerTypeCodeFromName(String Name){
    	for(ServerType servertype : ServerType.values()){
    		if(servertype.name().equals(Name)){
    			return servertype.serverTypeCode;
    		}
    	}
    	return null;
    }
}

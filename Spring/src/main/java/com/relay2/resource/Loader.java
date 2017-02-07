package com.relay2.resource;

import java.util.Properties;

public class Loader {
	
	private Properties db;

	public Properties getDb() {
		return db;
	}

	public void setDb(Properties db) {
		this.db = db;
	}

	@Override
	public String toString() {
		return "Loader [db=" + db + "]";
	}
	
}

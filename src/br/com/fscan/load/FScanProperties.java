package br.com.fscan.load;

import java.util.Locale;
import java.util.ResourceBundle;

final public class FScanProperties {
	private FScanProperties(){}

	final static ResourceBundle RESOURCE_BUNDLE;

	static{
		RESOURCE_BUNDLE = ResourceBundle.getBundle("fscan-configuration", new Locale("pt"), 
		Thread.currentThread().getContextClassLoader());		
	}
	
	private static final String getString(String key){
		return RESOURCE_BUNDLE.getString(key);
	}
	
	public static final String 
		REPOSITORY = getString("fscan.repository");
		
}

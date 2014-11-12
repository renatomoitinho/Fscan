package br.com.fscan.impl;

import br.com.fscan.interfaces.IFScanLoader;
import br.com.fscan.type.ClassLoaderType;

public class FScanLoader implements IFScanLoader{
	
	ClassLoader classLoader;
	public FScanLoader(ClassLoaderType jars) {
		this.classLoader = jars.getClassLoader();
	}


	@Override
	@SuppressWarnings("unchecked")
	public <T> T newInstance(String className) {		
		Class<?> clazz;
		try {
			 clazz = classLoader.loadClass(className);
			 return (T) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
		return null;
	}

}

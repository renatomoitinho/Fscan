package br.com.fscan.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import br.com.fscan.load.FScanProperties;


public final class FScanLoadFactory {
	
	public static ClassLoader CLASS_LOADER_JARS;
	public static ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();
	 
	static{
		readLibsDirectory();
		if(CLASS_LOADER_JARS==null){
			CLASS_LOADER_JARS = CLASS_LOADER;
		}
		
	}
		
	
	 private static boolean readLibsDirectory() {
		String repository = FScanProperties.REPOSITORY;
		try {
			File dir = new File(repository);
			URL[] url = null;
			if (dir.isDirectory()){
				File[] jarFiles = dir.listFiles();
				url = new URL[jarFiles.length];
				for (int i=0;i<jarFiles.length; i++) {
					if (jarFiles[i].getAbsolutePath().endsWith(".jar")) {
					//	System.out.println("file:" + jarFiles[i].getCanonicalPath());
						url[i] = new URL("file:" + jarFiles[i].getCanonicalPath());
					}
				}
			} else {
				return false;
			}
			CLASS_LOADER_JARS = new URLClassLoader(url,CLASS_LOADER);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			return false;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	  
	 
	 
	 
	 
}

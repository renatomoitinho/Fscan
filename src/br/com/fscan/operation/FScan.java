package br.com.fscan.operation;

import java.util.Set;

import br.com.fscan.impl.FScanner;
import br.com.fscan.interfaces.IFScanSelector;
import br.com.fscan.interfaces.IFScanSelectorPackage;
import br.com.fscan.interfaces.IFScanner;


public abstract class FScan {
	
	private FScan(){} //not extends

	public static IFScanSelector<Set<Class<?>>> findInterfaces(){
		return newIstanceScanner().findInterfaces();
	}
	
	public static IFScanSelector<Set<Class<?>>> findClass(){
		return newIstanceScanner().findClass();
	}
	
	public static IFScanSelector<Set<Class<?>>> findEnum(){
		return newIstanceScanner().findEnum();
	}

	public static IFScanSelector<Set<Class<?>>> findAnnotation(){
		return newIstanceScanner().findAnnotation();
	}	
	
	public static IFScanSelector<Set<Class<?>>> findAll(){
		return newIstanceScanner().findAll();
	}	
	
	public static IFScanSelectorPackage<String[]> findPackages(){
		return newIstanceScanner().findPackages();
	}	

	public static<T> T newInstance(String className){
		return newIstanceScanner().loaderJars().newInstance(className);
	} 

	private static IFScanner newIstanceScanner(){
		return SCANNER.createScanner();
	}
	
	
	
	private static final IFScanner SCANNER = new FScanner();
}

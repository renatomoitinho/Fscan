package br.com.fscan.interfaces;

import java.util.Set;


public interface IFScanner{
	  IFScanSelector<Set<Class<?>>> findInterfaces();
	  IFScanSelector<Set<Class<?>>> findClass();
	  IFScanSelector<Set<Class<?>>> findEnum();
	  IFScanSelector<Set<Class<?>>> findAll();
	  IFScanSelector<Set<Class<?>>> findAnnotation();
	  IFScanSelectorPackage<String[]> findPackages();
	  IFScanLoader loaderJars();
	  IFScanner createScanner();
}

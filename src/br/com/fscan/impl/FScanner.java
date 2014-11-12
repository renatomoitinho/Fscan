package br.com.fscan.impl;

import br.com.fscan.interfaces.IFScanLoader;
import br.com.fscan.interfaces.IFScanSelector;
import br.com.fscan.interfaces.IFScanSelectorPackage;
import br.com.fscan.interfaces.IFScanner;
import br.com.fscan.type.ClassLoaderType;
import br.com.fscan.type.FScanType;


@SuppressWarnings("unchecked")
public class FScanner implements IFScanner {

	
	@Override
	public IFScanner createScanner() {
		return (this);
	}

	@Override
	public IFScanSelector findAll() {
		return new FScanSelector(FScanType.FULL,ClassLoaderType.SIMPLE);
	}

	@Override
	public IFScanSelector findClass() {
		return new FScanSelector(FScanType.CLASS,ClassLoaderType.SIMPLE);
	}

	@Override
	public IFScanSelector findEnum() {
		return new FScanSelector(FScanType.ENUM,ClassLoaderType.SIMPLE);
	}

	@Override
	public IFScanSelector findInterfaces() {
		return new FScanSelector(FScanType.INTERFACE,ClassLoaderType.SIMPLE);
	}

	@Override
	public IFScanLoader loaderJars() {
		return new FScanLoader(ClassLoaderType.JARS);
	}

	@Override
	public IFScanSelector findAnnotation() {
		return new FScanSelector(FScanType.ANNOTATION,ClassLoaderType.SIMPLE);
	}

	@Override
	public IFScanSelectorPackage<String[]> findPackages() {
		return new FScanSelectorPackage(FScanType.FULL,ClassLoaderType.JARS);
	}

}

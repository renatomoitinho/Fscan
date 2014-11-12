package br.com.fscan.interfaces;


public interface IFScanLoader {	
	<T> T newInstance(String className);
}

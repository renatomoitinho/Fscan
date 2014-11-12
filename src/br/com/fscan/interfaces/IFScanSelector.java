package br.com.fscan.interfaces;

import java.util.Set;

public interface IFScanSelector<T> extends IFScanSelectorPackage<T>{
	Set<Class<?>> in(String... packages);
	IFScanSelector<T> filter(IFScanQuery scanQuery);
}

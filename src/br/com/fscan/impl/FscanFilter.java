package br.com.fscan.impl;

import java.lang.annotation.Annotation;

import br.com.fscan.interfaces.IFScanFilter;
import br.com.fscan.interfaces.IFScanQuery;

public abstract class FscanFilter implements IFScanFilter{
	private FscanFilter(){;} //not extends
	
	public static<T extends Annotation> IFScanQuery annotationPresent(final Class<T>...annotClasses){
		return new IFScanQuery() {	
			@Override
			public boolean check(Class<?> clazz) {
				for(Class<? extends Annotation> c : annotClasses){
					if(clazz.isAnnotationPresent(c))
						return true;
				}
				return false;
			}
		};
	}
	
	public static IFScanQuery contains(final String... filters){
		return new IFScanQuery() {	
			@Override
			public boolean check(Class<?> clazz) {
			final String name = clazz.getSimpleName().toLowerCase();
			for(String fil: filters){
				fil = fil.toLowerCase();
				if(name.contains(fil))
					return true;
			}
			return false;
			}
		};
	}	
}

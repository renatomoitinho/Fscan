package br.com.fscan.type;

import br.com.fscan.impl.FScanLoadFactory;
import br.com.fscan.interfaces.IFSClassLoaderReturn;

/**
 *<h3>ClassLoaderType.java</h3>
 */
public enum ClassLoaderType implements IFSClassLoaderReturn{
	JARS{
		@Override
		public ClassLoader getClassLoader() {
			return FScanLoadFactory.CLASS_LOADER_JARS;
		}
	},SIMPLE{
		@Override
		public ClassLoader getClassLoader() {
			return FScanLoadFactory.CLASS_LOADER;
		}
	};
	
}

package br.com.fscan.type;

import br.com.fscan.impl.FScanLoadFactory;
import br.com.fscan.interfaces.IFSClassLoaderReturn;

/**
 *<h3>ClassLoaderType.java</h3>
 *<p><b>Company:</b> Cedro Market & Finances<p>
 *<p><b>Copyright:</b>(c) 2011 </p>
 * @version 1.0
 * @author <a href="mailto:renato.dias@cedrofinances.com.br">renato.dias</a>
 * @since 12/09/2011
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

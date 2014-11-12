package br.com.fscan.type;

import br.com.fscan.interfaces.IFScanTypeOperation;

/**
 *<h3>FScanType.java</h3>
 *<p><b>Company:</b> Cedro Market & Finances<p>
 *<p><b>Copyright:</b>(c) 2011 </p>
 * @version 1.0
 * @author <a href="mailto:renato.dias@cedrofinances.com.br">renato.dias</a>
 * @since 12/09/2011
 */
public enum FScanType implements IFScanTypeOperation<Class<?>>{
	INTERFACE{
		@Override
		public boolean operation(Class<?> c) {
			return c.isInterface();
		}
	},ENUM{
		@Override
		public boolean operation(Class<?> c) {
			return c.isEnum();
		}
	},CLASS{
		@Override
		public boolean operation(Class<?> c) {
			return !c.isInterface()&&!c.isEnum() ;
		}
	},ANNOTATION{
		@Override
		public boolean operation(Class<?> c) {
			return c.isAnnotation();
		}
	}
	,FULL{
		@Override
		public boolean operation(Class<?> c) {
			return true;
		}
	};
}

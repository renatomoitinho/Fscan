package br.com.fscan.type;

import br.com.fscan.interfaces.IFScanTypeOperation;

/**
 *<h3>FScanType.java</h3>
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

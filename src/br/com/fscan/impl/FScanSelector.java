package br.com.fscan.impl;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.fscan.interfaces.IFScanQuery;
import br.com.fscan.interfaces.IFScanSelector;
import br.com.fscan.interfaces.IFScanSelectorPackage;
import br.com.fscan.interfaces.IFScanTypeOperation;
import br.com.fscan.type.ClassLoaderType;


public class FScanSelector implements IFScanSelector<Set<Class<?>>>{

	final IFScanTypeOperation fScanTypeOperation;
	final ClassLoader classLoader;
	final static String FILE_SEPARATOR = System.getProperty("file.separator");
	final static String FILE_EXTENSION = ".class";
	final static Map<String,Set<String>> mapPackages = new HashMap<String,Set<String>>();
	final IFScanSelectorPackage<String[]> ifScanSelectorPackage = new FScanSelectorPackage();	 
	final List<IFScanQuery> ifScanQueries = new ArrayList<IFScanQuery>();
	
	public FScanSelector(IFScanTypeOperation fScanTypeOperation,ClassLoaderType classLoader){
		this.fScanTypeOperation = fScanTypeOperation;
		this.classLoader = classLoader.getClassLoader();
		if(FScanSelector.mapPackages.size() == 0)
			runningAllPackages();
	}
	
	public void addClass(String dir,String packages,Set<Class<?>> classes){
		try {
			if(dir.contains(FILE_EXTENSION)){
				String path = dir.substring(0,dir.indexOf(FILE_EXTENSION));
				Class<?> clazz = Class.forName(packages.concat(".").concat(path));
				if(fScanTypeOperation.operation(clazz)){
					if(ifScanQueries.size()>0){
						for(IFScanQuery query :ifScanQueries){
							if(query.check(clazz)){
								classes.add(clazz);	
							}
						}	
					}else{
						classes.add(clazz);	
					}
				}															
			}
		} 
		catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Set<Class<?>> in(String... packages) {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		for(String pkg : packages){
			String base = pkg.replaceAll("\\.", "/"); 
			URL url = classLoader.getResource(base);
			if(url!=null){
				String path = url.getPath();
				File dir  = new File(path);
				if(dir.isDirectory()){
					for(String c : dir.list()){					
						addClass(c, pkg, classes);
					}
				}			
			}		
		}		
		return classes;
	}

	@SuppressWarnings("serial")
	private void recursiveList(File file,String absolute){
		if(file.isDirectory()){
			String path = file.getAbsolutePath();			
			String pkg = path.substring(absolute.length(),path.length());			
			//System.out.println("ABSOLUTE PATH: "+ absolute +"\n path: " + path +"\n package: " + pkg);
			if(!"".equals(pkg)){
			  	pkg = pkg.substring(1).replaceAll("[^\\w]", ".");
				String key = absolute.substring(0,absolute.lastIndexOf(FILE_SEPARATOR));
				key = key.substring(key.lastIndexOf(FILE_SEPARATOR)+1);
				final String packageName = pkg;
				
				Set<String> listPackage = mapPackages.get(key);
				if(listPackage == null){
					mapPackages.put(key, new HashSet<String>(){{
						add(packageName);
					}});
				}else{
					listPackage.add(packageName);
				}	
			}
	        File[] lista= file.listFiles();
	        for (int i= 0; i < lista.length; i++)
	        	recursiveList(lista[i],absolute);
		}
	}
		
	public void runningAllPackages() {
		URL url = classLoader.getResource(".");
		if(url!=null){
			try {
				Enumeration<URL> enumeration = classLoader.getResources(".");				
				for (Enumeration<URL> e = enumeration;e.hasMoreElements();){				   
					URL url2 = (URL) e.nextElement();
					File file = new File(url2.getPath());
					recursiveList(file,file.getAbsolutePath());	   
				}		   				   
			} catch (Exception e) {}
		}
	}

	@Override
	public Set<Class<?>> all() {
		String[] packages = ifScanSelectorPackage.all();
		return in(packages);
	}


	@Override
	public Set<Class<?>> inProject(String... projects) {
		String[] packages = ifScanSelectorPackage.inProject(projects);
		return in(packages);
	}


	@Override
	public IFScanSelector<Set<Class<?>>> filter(IFScanQuery scanQuery) {
		ifScanQueries.add(scanQuery);
		return (this);
	}

}

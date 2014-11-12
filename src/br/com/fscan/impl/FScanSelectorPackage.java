package br.com.fscan.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import br.com.fscan.interfaces.IFScanSelectorPackage;
import br.com.fscan.type.ClassLoaderType;
import br.com.fscan.type.FScanType;

public class FScanSelectorPackage implements IFScanSelectorPackage<String[]>{

	FScanSelector fScanSelector;
		
	public FScanSelectorPackage() {
		
	}
	
	public FScanSelectorPackage(FScanType scanType, ClassLoaderType jars) {
		fScanSelector = new FScanSelector(scanType,jars);
		if(FScanSelector.mapPackages.size() == 0)
			fScanSelector.runningAllPackages();
	}

	@Override
	public String[] all() {
		Set<String> response = new HashSet<String>(); 
		Map<String,Set<String>> map = FScanSelector.mapPackages;
		
		for(Iterator<Set<String>> i = map.values().iterator(); i.hasNext();){
			Set<String> set = i.next();
			response.addAll(set);
		}
		return response.toArray(new String[response.size()]);
	
	}

	@Override
	public String[] inProject(String... filter) {
		Set<String> response = new HashSet<String>(); 
		Map<String,Set<String>> map = FScanSelector.mapPackages;
		
		for(String projectName: filter){
			Set<String> set = map.get(projectName);
			if(set!=null)
				response.addAll(set);
		}
		return response.toArray(new String[response.size()]);

	}

}

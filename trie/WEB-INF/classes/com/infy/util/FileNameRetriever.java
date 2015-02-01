package com.infy.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileNameRetriever {
	
	private List<String> fileNames = new ArrayList<String>();
	
	public void listFiles(File[] files) throws IOException {
	    for (File file : files) {
	        if (file.isDirectory()) {
	        	listFiles(file.listFiles()); // Calls same method again.
	        } else {
	            String path = file.getCanonicalPath();
	            if(path.lastIndexOf("LSIE")!= -1){
	            String a = path.substring(path.lastIndexOf("LSIE")-1);
	            fileNames.add(a);
	            }
	            
	        }
	    }
	}
	
	public List<String> retrieveFileNames(String path) throws IOException
	{
		 File[] files = new File(path).listFiles();
		 listFiles(files);
		 return fileNames;
	}

}

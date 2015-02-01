package com.infy.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.infy.engine.Engine;

public class SearchClient {
	
	private Engine engine;
	
	public void createRepository(List<String> fileNames) throws IOException
	{
		engine = new Engine();
		for(int i=0;i<fileNames.size();i++)
		{
			String value = fileNames.get(i);
			String fileName = value.substring(value.lastIndexOf(File.separator)+1);
			engine.add(fileName, value);
		}
	}
	
	public String getCombinations(String key)
	{
		return engine.getCombinations(key);
	}
	
}

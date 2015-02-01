package com.infy.engine;

import java.util.ArrayList;
import java.util.List;

public class Node {
	char value;
	Node[] children;
	boolean isVisited;
	int depth;
	boolean isTerminalNode;
	List<String> content;
	Node()
	{
		children = new Node[26];
	}
	public List<String> getContent() {
		if(content == null)
		{
			content = new ArrayList<String>();
		}
		return content;
	}
}

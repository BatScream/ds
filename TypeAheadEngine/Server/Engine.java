package search.engine;
/*
 * author: Clement
 */

import java.io.File;
import java.util.Stack;

public class Engine {
	
	private Node rootNode;
	private Stack<Node> nodeStack;
	
	public Engine()
	{
		this.nodeStack = new Stack<Node>();
		this.rootNode = new Node();
		this.rootNode.depth = -1;
		this.rootNode.value = '~';
		this.nodeStack.push(this.rootNode);
	}
	
	public void add(String key, String value)
	{
		this.add(this.rootNode,key,0,value);
	}
	
	public String getCombinations(String key)
	{
		StringBuilder jsonString = new StringBuilder("[");
		String sep = "";
		while(!nodeStack.isEmpty())
		{
			Node node = nodeStack.peek();
			if(node.isTerminalNode && !node.isVisited)
			{
				int size = node.content.size();
				boolean isUnique = true;
				if(size > 1)
				{
					isUnique = false;
				}
				for(int i=0;i<size;i++)
				{
					jsonString.append(sep);
					jsonString.append("{");
					jsonString.append("\"file\":\"");
					jsonString.append(node.content.get(i).replace(File.separator, "\\"+File.separator));
					jsonString.append("\"");
					jsonString.append(",");
					jsonString.append("\"isUnique\":\"");
					if(isUnique)
					{
						jsonString.append("Y");
					}
					else
					{
						jsonString.append("N");
					}
					jsonString.append("\"");
					jsonString.append("}");
					sep = ",";
				}
			}
			// Check if it is a terminal but a part of another word
			int chldrenToBeTraversed = getValidChildrenCount(node,key,nodeStack.indexOf(node));
			if(chldrenToBeTraversed == 0)
			{
				node.isVisited = true;
				nodeStack.pop();
			}
			else
			{
				addChildToStack(node,key, nodeStack.indexOf(node));
				// If this is the last child
				if(chldrenToBeTraversed == 1)
				{
					node.isVisited = true;
				}
			}
		}
		jsonString.append("]");
		return jsonString.toString();
	}
	
	private void addChildToStack(Node parentNode,String key, int depth)
	{
		for(int i=0;i<parentNode.children.length;i++)
		{
			if(parentNode.children[i] == null) break;
			if((depth >= key.length() || Character.toLowerCase(parentNode.children[i].value) == Character.toLowerCase(key.charAt(depth))) && !parentNode.children[i].isVisited)
			{
				nodeStack.push(parentNode.children[i]);
				break;
			}
		}
	}
	
	private int getValidChildrenCount(Node parentNode,String key, int depth)
	{
		int count = 0;
		for(int i=0;i<parentNode.children.length;i++)
		{
			if(parentNode.children[i] == null) break;
			if((depth >= key.length() || Character.toLowerCase(parentNode.children[i].value) == Character.toLowerCase(key.charAt(depth))) && !parentNode.children[i].isVisited)
			{
				count++;
			}
		}
		return count;
	}
	
	private void add(Node root, String element, int depth, String content)
	{	
		if(depth == element.length()) return;
		Node node = this.getChildNode(root, element.charAt(depth));
		if(node == null)
		{
			node = new Node();
			node.value = element.charAt(depth);
			addChildToNode(root,node);
		}
		if(depth == element.length() -1)
		{
			node.isTerminalNode = true;
			node.getContent().add(content);
		}
		add(node,element,++depth,content);
	}
	
	private Node getChildNode(Node node,char key)
	{
		for(int i=0;i<node.children.length;i++)
		{
			if(node.children[i] == null) break;
			if(Character.toLowerCase(node.children[i].value) == Character.toLowerCase(key))
			{
				return node.children[i];
			}
		}
		return null;
	}
	
	private void addChildToNode(Node parent, Node child)
	{
		for(int i=0;i<parent.children.length;i++)
		{
			if(parent.children[i] == null)
			{
				parent.children[i] = child;
				break;
			}
		}
	}
}

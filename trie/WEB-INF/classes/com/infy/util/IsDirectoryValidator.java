package com.infy.util;

import java.io.File;
import java.io.IOException;

public class IsDirectoryValidator {
	public static boolean showDirectory(File[] files) throws IOException {
		boolean isDir = false;
		for (File file : files) {
			if (file.isDirectory()) {
				isDir = true;
				showDirectory(file.listFiles()); // Calls same method again.
			}
			else{
				isDir =false;
			}
		}
		return isDir;
	}
}

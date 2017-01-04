package com.kumanoit.mylocal;

import java.io.File;

public class FileUtils {

	private static int id = 111;

	public static void renameFiles(String directory, String oldPattern, String prefix, String suffix) {
		File dir = new File(directory);
		if (dir.isFile()) {
			return;
		}
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				renameFiles(file.toString(), oldPattern, prefix, suffix);
			} else {
				if (file.toString().contains(oldPattern)) {
					String newFileName = "";
					while (true) {
						newFileName = directory + "/" + prefix + id++ + suffix;
						if (new File(newFileName).exists()) {
							continue;
						}
						file.renameTo(new File(newFileName));
						System.out.println("Renamed:\n" + file.toString() + "\n to \n" + newFileName);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		String dir = "/Users/kuma/Documents/kumanoit/Personal/Documents/folder/Whatsapp/videos";
		if (dir.charAt(dir.length() - 1) != '/') {
			dir = dir + "/";
		}
		String oldPattern = "VIDEO";
		String newPrefix = "Rdata";
		String newSuffix = ".rds";
		renameFiles(dir, oldPattern, newPrefix, newSuffix);
	}
}

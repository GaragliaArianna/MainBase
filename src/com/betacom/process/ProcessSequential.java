package com.betacom.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.interfaces.ProcessInterface;

public class ProcessSequential implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin process sequential");
		
		String filePath="/Users/arian/Downloads/fileToRead.txt";
		String filePathOut="/Users/arian/Downloads/fileToWrite.txt";
		
		List <String> records=readFile(filePath);
		
		for (String record:records) {
			System.out.println(record);
		}
		
		return false;
	}

	private List<String> readFile (String path) {
		List<String> r=new ArrayList<String>();
		
		try (BufferedReader reader=new BufferedReader (new FileReader(path))) {
			String line=reader.readLine();
			while (line!=null) {
				r.add(line);
				line=reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	private int writeFile (String path, List <String> inp) {
		int num=0;
		
		File f=new File (path);
		if (f.exists()) {
			System.out.println("File "+path+" exists");
			f.delete();
		}
		
		FileWriter o=null;
		try {
			o=new FileWriter (f);
			for (String rec : inp) {
				o.write(rec);
				o.write("\n");
				num++;
			}
			
			o.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return num;
	}
	
	
	
	
}

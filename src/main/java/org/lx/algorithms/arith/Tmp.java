package org.lx.algorithms.arith;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

@SuppressWarnings("resource")
public class Tmp {
	public static void main(String[] args) throws Exception {
		
		String pathname = "F:/BaiduYunDownload/temp/vocabulary1.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(pathname)));
		String line;
		while( (line = br.readLine()) != null ){
			String word;
			StringTokenizer st = new StringTokenizer(line);
			st.nextToken();
			st.nextToken();
			st.nextToken();
			word = st.nextToken();
			System.out.println(word);
		}
		
	}
}


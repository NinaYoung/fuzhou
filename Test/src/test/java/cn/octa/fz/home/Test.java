package cn.octa.fz.home;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Test {
	
	public static void main(String[] arg0){
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		File file = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		
		String str = null;
		try {
			fis = new FileInputStream("C:/Users/pc-4/Desktop/bad/newbad/newbadresult.txt");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			file = new File("C:/Users/pc-4/Desktop/bad/newbad/newbadresult1.txt");
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
		   while((str = br.readLine()) != null){
			
				
//			   if(!str.startsWith("/")){
//				   
//				   str += "\r\n";
//				   bw.write("/?username=" + str);
//			   }else{
//				   str += "\r\n";
//				   bw.write(str);
//			   }
//			   if(str.contains("\\")){
//				   System.out.println(str);
//				   str.replace("\\", "");
//				   str += "\r\n";
//				   System.out.println(str);
//				   bw.write(str);
//			   }else{
//				   str += "\r\n";
//				   bw.write(str);
//			   }
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
	}

}

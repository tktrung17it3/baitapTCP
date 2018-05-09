package giuaki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bai3 {
	public static void copy(String path1 , String path2) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream(path1);
			fos = new FileOutputStream(path2);
			int data = fis.read();
			while(data!=-1) {
				// System.out.print((char)data);
				fos.write(data);
				data = fis.read();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		finally {
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
	}

	public static void main(String[] args)  {
		copy("F:\\hello.txt","E:\\text.txt");
	}
        

}

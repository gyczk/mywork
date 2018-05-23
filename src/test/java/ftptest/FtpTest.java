package ftptest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;

public class FtpTest {
	@Test
	public void ftp1(){
		
		FTPClient ftp = new FTPClient();  
		int reply;  
		try {
			ftp.connect("192.168.179.128", 21);
			ftp.login("czkftp", "czkftp");
			reply  = ftp.getReplyCode();
			 if (!FTPReply.isPositiveCompletion(reply)) {  
		            ftp.disconnect();  
		        }  
			 System.out.println(ftp.getLocalAddress());
			 ftp.enterLocalPassiveMode();
//			 ftp.changeToParentDirectory();
			 boolean flag = ftp.changeWorkingDirectory("/123/");//转移到FTP服务器目录 
//			 boolean flag = ftp.changeWorkingDirectory("/");//转移到FTP服务器目录 
			 System.out.println(ftp.getLocalAddress());
//			 System.out.println(flag);
			 FTPFile[] fs = ftp.listFiles(); 
			 for(FTPFile ff:fs){  
				 System.out.println(new String(ff.getName().getBytes("iso-8859-1"),"gbk"));
//		            if(new String(ff.getName().getBytes("iso-8859-1"),"utf-8").equals("设计模式之禅.pdf")){  
				 if(new String(ff.getName().getBytes("iso-8859-1"),"gbk").equals("设计模式之禅.pdf")){  
		                File localFile = new File("f:/"+new String(ff.getName().getBytes("iso-8859-1"),"gbk"));  
		                  
		                OutputStream is = new FileOutputStream(localFile);   
		                ftp.retrieveFile(ff.getName(), is);  
		                is.close();  
		            }  
		        }  
		          
		        ftp.logout();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

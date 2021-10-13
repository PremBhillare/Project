package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.project.Testbase;

public class TestUtil extends Testbase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 35;
	
	public TestUtil() throws IOException {
	}
	
	public static void takeScreenShotAtEndOfTest() {
		File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File("Screenshots/"+time()+".jpeg");
		try {
			FileUtils.copyFile(ScrFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String time() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/HH_mm_ss");
		java.util.Date date = new java.util.Date();
		String time= formatter.format(date);
		return time;
	}
}

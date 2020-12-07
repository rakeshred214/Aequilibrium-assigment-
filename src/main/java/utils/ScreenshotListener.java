package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                String time = formatter.format(calendar.getTime());
                File destFile = new File((String) reportDirectory+ "/failure_screenshots/"+methodName+"_"+time+".png");
                FileUtils.copyFile(scrFile, destFile);
                String name = "\\testng-maven\\target\\surefire-reports\\" + "failure_screenshots\\"+ methodName +"_"+ time +".png";
                Reporter.log("<a href=\""+ name + "\"target=\"_blank\"> screenshot");
          } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
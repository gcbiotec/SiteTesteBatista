package FrameWork.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import okio.Utf8;
import org.openqa.selenium.WebDriver;

import javax.swing.text.html.HTML;
import java.io.File;

public class Report {

    public static WebDriver driver;
    public static String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report"
            + File.separator + "Report_" + DateTime.getDateTimeFormatt();

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extendReports;
    public static ExtentTest extentTest;
    public static void setExtentReport(){
        CreateFolder.createFolderReport(PATH_REPORT);
        htmlReporter = new ExtentHtmlReporter(PATH_REPORT + File.separator + "meu relatório_" + DateTime.getDateTimeFormatt() + ".html");
        htmlReporter.config().setDocumentTitle("Relatório de Execução de Testes Automatizados");
        htmlReporter.config().setReportName("Relatório de Execução do Form Batista");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setTimeStampFormat(" EEEE , MMMM dd , yyyy , hh:mm a '('zzz')'");

        extendReports = new ExtentReports();
        extendReports.attachReporter(htmlReporter);
    }

        public static void startReport(String testName){
            extentTest = extendReports.createTest(testName);
    }
        public static void endReport(){
            extendReports.flush();
            if(driver != null){
                driver.quit();
                driver = null;
            }
        }
}



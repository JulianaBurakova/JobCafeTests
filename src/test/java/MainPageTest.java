
import Pages.AboutUsPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {

    static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup(){
        mainPage = new MainPage();
    }

    @BeforeEach
    public  void beforeTest(){
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest() throws IOException {
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }
    @Test
    public void captureLogoElement() throws IOException {
        WebElement logo = webDriver.findElement(By.xpath("//div[@class = 'logo']"));
        File file = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
    }

    @Test
    public void comingSoonImgTest() throws IOException {
        logger.info("Main page image Coming soon");
        Boolean success = mainPage.isComingSoonVisible();
        assertTrue(success);
    }
    @Test
    public void openAboutUsPage(){
        AboutUsPage aboutUsPage =  mainPage.openAboutUsPage();
        boolean isLoaded = aboutUsPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void LogoAboutUsTest(){
        AboutUsPage aboutUsPage =  mainPage.openAboutUsPage();
        logger.info("About Us page logo is visible");
        Boolean success = aboutUsPage.isLogoVisible();
        assertTrue(success);
    }
    @Test
    public void CaptureLogoAboutUsTest() throws IOException {
        mainPage.openAboutUsPage();
        WebElement logo = webDriver.findElement(By.xpath("//div[@class = 'logo']"));
        File file = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
    }
}
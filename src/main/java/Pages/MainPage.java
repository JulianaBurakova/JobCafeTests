package Pages;
import Consts.Consts;

public class MainPage extends BasePage{

    private static final String LOGO_IMG = "//div[@class = 'logo']";
    private static final String ABOUT_US_OPTION = "//a[text() = 'About Us']";

    private static final String COMING_SOON_IMG = "//*[text() = 'Coming soon']";

    private static final String JOBS_PAGE_LINK = "//a[text()='Find Job']";
    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
    public AboutUsPage openAboutUsPage(){
        clickElementByXpath(ABOUT_US_OPTION);
        return new AboutUsPage();
    }
    public boolean isComingSoonVisible(){
        Boolean isVisible = elementExists(COMING_SOON_IMG);
        return isVisible;
    }

    public JobsPage navigateToJobsPage() {
        clickElementByXpath(JOBS_PAGE_LINK);
        return new JobsPage();
    }

}
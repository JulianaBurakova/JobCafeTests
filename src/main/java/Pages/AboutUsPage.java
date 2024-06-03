package Pages;

public class AboutUsPage extends BasePage {

    public static final String ABOUT_US_HEADER = "//h2[text()=' CAFE']";

    public boolean isPageTitleVisible() {
        return elementExists(ABOUT_US_HEADER);
    }

    private static final String LOGO_IMG = "//div[@class = 'logo']";

    public boolean isLogoVisible() {
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
}
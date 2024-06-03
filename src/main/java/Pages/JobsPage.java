package Pages;
import Pages.BasePage;
import Consts.Consts;
import org.openqa.selenium.WebElement;

public class JobsPage extends BasePage {
    private static final String SEARCH_LOCATION_INPUT = "//input[@name='location']";
    private static final String SEARCH_POSITION_INPUT = "//input[@name='position']";
    private static final String SEARCH_COMPANY_INPUT = "//input[@name='company']";
    private static final String SEARCH_BUTTON = "//button[text()='search']";
    private static final String RESET_BUTTON = "//button[text()='reset']";
    private static final String RESULTS_LIST = "//div[@class='entry-content']";
    private static final String NO_RESULTS_MESSAGE = "//*[text()='No results found!']";

    public void navigateToJobsPage() {
        webDriver.get(Consts.MAIN_URL);

    }
    public void clearLocationSearch() {
        WebElement locationInput = findElementByXpath(SEARCH_LOCATION_INPUT);
        locationInput.clear();
    }

    public void clearPositionSearch() {
        WebElement positionInput = findElementByXpath(SEARCH_POSITION_INPUT);
        positionInput.clear();
    }

    public void clearCompanySearch() {
        WebElement companyInput = findElementByXpath(SEARCH_COMPANY_INPUT);
        companyInput.clear();
    }
    public void searchForLocation(String location) {
        sendTextToElementByXpath(SEARCH_LOCATION_INPUT, location);
        clickElementByXpath(SEARCH_BUTTON);
    }

    public void searchForPosition(String position) {
        sendTextToElementByXpath(SEARCH_POSITION_INPUT, position);
        clickElementByXpath(SEARCH_BUTTON);
    }

    public void searchForCompany(String company) {
        sendTextToElementByXpath(SEARCH_COMPANY_INPUT, company);
        clickElementByXpath(SEARCH_BUTTON);
    }

    public boolean isResultsListDisplayed() {
        return elementExists(RESULTS_LIST);
    }

    public boolean isNoResultsMessageDisplayed() {
        return elementExists(NO_RESULTS_MESSAGE);
    }

    public void resetSearch() {
        clickElementByXpath(RESET_BUTTON);
    }

    public boolean isSearchReset() {
        return findElementByXpath(SEARCH_LOCATION_INPUT).getText().isEmpty() &&
                findElementByXpath(SEARCH_POSITION_INPUT).getText().isEmpty() &&
                findElementByXpath(SEARCH_COMPANY_INPUT).getText().isEmpty();
    }

    public void searchForJob(String position, String company, String location) {
        sendTextToElementByXpath(SEARCH_POSITION_INPUT, position);
        sendTextToElementByXpath(SEARCH_COMPANY_INPUT, company);
        sendTextToElementByXpath(SEARCH_LOCATION_INPUT, location);
        clickElementByXpath(SEARCH_BUTTON);
    }
}


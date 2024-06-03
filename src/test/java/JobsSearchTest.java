import Pages.JobsPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobsSearchTest extends UseCaseBase {
    private MainPage mainPage;
    private JobsPage jobsPage;

    @BeforeEach
    public void setup() {
        mainPage = new MainPage();
        mainPage.navigateToMainPage();
        jobsPage = mainPage.navigateToJobsPage();
    }

    @Test
    public void searchByLocationTest() {
        String[] locations = {"Toronto", "Tel-Aviv", "Chicago", "New-York"};
        for (String location : locations) {
            jobsPage.clearLocationSearch();
            jobsPage.searchForLocation(location);
            assertTrue(jobsPage.isResultsListDisplayed());
        }
    }

    @Test
    public void searchByPositionTest() {
        String[] positions = {"QA", "Developer", "Project Manager"};
        for (String position : positions) {
            jobsPage.clearPositionSearch();
            jobsPage.searchForPosition(position);
            assertTrue(jobsPage.isResultsListDisplayed());
        }
    }

    @Test
    public void searchByCompanyTest() {
        String[] companies = {"Apple", "Facebook", "Google"};
        for (String company : companies) {
            jobsPage.clearCompanySearch();
            jobsPage.searchForCompany(company);
            assertTrue(jobsPage.isResultsListDisplayed());
        }
    }
    @Test
    public void resetSearchTest() {
        jobsPage.searchForLocation("Toronto");
        jobsPage.searchForPosition("QA");
        jobsPage.searchForCompany("Apple");
        jobsPage.resetSearch();
        assertTrue(jobsPage.isSearchReset());
    }

    @Test
    public void combinedSearchTest() {
        jobsPage.searchForJob("Manager", "Google", "USA");
        assertTrue(jobsPage.isResultsListDisplayed());
    }

    @Test
    public void noResultsAndResetTest() {
        jobsPage.searchForPosition("abracadabra");
        assertTrue(jobsPage.isNoResultsMessageDisplayed());

        jobsPage.searchForLocation("Toronto");
        jobsPage.searchForPosition("QA");
        jobsPage.searchForCompany("Apple");
        jobsPage.resetSearch();
        assertTrue(jobsPage.isSearchReset());
    }
}

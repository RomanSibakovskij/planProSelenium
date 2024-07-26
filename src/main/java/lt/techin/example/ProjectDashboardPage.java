package lt.techin.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProjectDashboardPage extends BasePage{

    //buttons
    @FindBy(xpath = "//div[@id='root']/nav//a[@href='/projects']")
    private WebElement projectsNavBarButton;

    @FindBy(xpath = "//*//div[@id='root']/div//a[@href='/projects']")
    private WebElement projectsLink;


    public ProjectDashboardPage(WebDriver driver) {
        super(driver);
    }

    //methods

    public void clickProjectsNavBarButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(projectsNavBarButton));
        projectsNavBarButton.click();
    }

    public void clickProjectsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(projectsLink));
        projectsLink.click();
    }

    //assert methods

    public boolean isProjectsNavBarButtonPresent() {
        return projectsNavBarButton.isDisplayed();
    }

    public boolean isProjectsLinkPresent() {
        return projectsLink.isDisplayed();
    }

}

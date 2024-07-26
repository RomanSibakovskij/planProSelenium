package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddNewProjectPage extends BasePage {

    //elements
    @FindBy(xpath = "//*//input[@id='name']")
    private WebElement projectNameInputField;

    @FindBy(xpath = "//*//textarea[@id='description']")
    private WebElement projectDescriptionInputField;

    @FindBy(css = "img[alt='Project status bubble']")
    private List<WebElement> projectStatusIcons;

    //buttons
    @FindBy(xpath = "//*//div[@id='root']//button[.='Add project']")
    private WebElement addProjectButton;

    @FindBy(xpath = "//div[@id='root']//form/button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='root']//button[.='Next']")
    private WebElement nextPageButton;

    public AddNewProjectPage(WebDriver driver) {
        super(driver);
    }

    private String projectName;
    private String projectDescription;

    // Data input method
    public void generateProjectDetails() {
        this.projectName = TestDataGenerator.generateRandomProjectName(12);
        this.projectDescription = TestDataGenerator.generateRandomProjectDescription(16);

        System.out.println("Generated Data:");
        System.out.println("Project name: " + projectName);
        System.out.println("Project description: " + projectDescription + "\n");
    }

    // Getters
    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public int getProjectStatusIconCount(){
        return projectStatusIcons.size();
    }

    // Input methods
    public void inputProjectDetails() {
        inputProjectName();
        inputProjectDescription();
    }

    public void inputProjectName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(projectNameInputField));
        if (projectName != null && !projectName.isEmpty()) {
            projectNameInputField.sendKeys(this.projectName);
        } else {
            throw new IllegalArgumentException("Project name is null or empty.");
        }
    }

    public void inputProjectDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(projectDescriptionInputField));
        if (projectDescription != null && !projectDescription.isEmpty()) {
            projectDescriptionInputField.sendKeys(this.projectDescription);
        } else {
            throw new IllegalArgumentException("Project description is null or empty.");
        }
    }

    // Click button methods
    public void clickAddProjectButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(addProjectButton));
        addProjectButton.click();
    }

    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

//    public void clickNextPageButton(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOf(nextPageButton));
//        nextPageButton.click();
//    }

    public void clickNextPageButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1150));

        while(true){
            try{
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
                button.click();
                Thread.sleep(750);
            }catch(Exception e){
                break;
            }
        }
    }

    // Assert methods
    public boolean isAddProjectButtonPresent() {
        return addProjectButton.isDisplayed();
    }

    public boolean isProjectNameInputPresent() {
        return projectNameInputField.isDisplayed();
    }

    public boolean isProjectDescriptionInputPresent() {
        return projectDescriptionInputField.isDisplayed();
    }

    public boolean isSubmitButtonPresent(){
        return submitButton.isDisplayed();
    }

    public boolean isNextPageButtonPresent(){
        return nextPageButton.isDisplayed();
    }

    public boolean isAnyProgressStatusIconsDisplayed(){
        for(WebElement icon : projectStatusIcons){
            if(icon.isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public void printAllProgressStatusIconsDetails() {
        for (WebElement icon : projectStatusIcons) {
            if (icon.isDisplayed()) {
                System.out.println("In-progress icons found: " + icon.getAttribute("alt"));
            }
        }


    }
}

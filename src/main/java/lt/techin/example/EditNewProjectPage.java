package lt.techin.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditNewProjectPage extends BasePage{

    //elements

    @FindBy(xpath = "//*//input[@id='name']")
    private WebElement projectNameInputField;

    @FindBy(xpath = "//*//input[@id='name']")
    private WebElement projectDescriptionInputField;

    @FindBy(xpath = "/html//select[@id='status']")
    private WebElement projectStatusDropdownMenu;


    //buttons
    @FindBy(css = "#root > div.sc-dBmyGf.eyQNUC > div:nth-child(1) > p > p.sc-eyvHYj.fsKLeo > img")
    private WebElement editProjectButton;

    @FindBy(xpath = "//div[@id='root']//form/button[@type='submit']")
    private WebElement submitEditedProjectButton;

    public EditNewProjectPage(WebDriver driver) {
        super(driver);
    }


    private String editedProjectName;
    private String editedProjectDescription;

    public void generateEditedProjectDetails() {
        this.editedProjectName = TestDataGenerator.generateRandomProjectName(15);
        this.editedProjectDescription = TestDataGenerator.generateRandomProjectDescription(21);

        System.out.println("Generated Data:");
        System.out.println("Edited project name: " + editedProjectName);
        System.out.println("Edited project description: " + editedProjectDescription + "\n");
    }

    // Getters
    public String getEditedProjectName() {
        return editedProjectName;
    }

    public String getEditedProjectDescription() {
        return editedProjectDescription;
    }

    // Input methods
    public void inputEditedProjectDetails() {
        inputEditedProjectName();
        inputEditedProjectDescription();
    }

    public void inputEditedProjectName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(projectNameInputField));
        if (editedProjectName != null && !editedProjectName.isEmpty()) {
            projectNameInputField.clear();
            projectNameInputField.sendKeys(this.editedProjectName);
        } else {
            projectNameInputField.sendKeys(this.editedProjectName);
        }
    }

    public void inputEditedProjectDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800));
        wait.until(ExpectedConditions.visibilityOf(projectDescriptionInputField));
        if (editedProjectDescription != null && !editedProjectDescription.isEmpty()) {
            projectDescriptionInputField.clear();
            projectDescriptionInputField.sendKeys(this.editedProjectDescription);
        } else {
            projectDescriptionInputField.sendKeys(this.editedProjectDescription);
        }
    }

    //methods

    public void clickEditProjectButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1150));
        wait.until(ExpectedConditions.visibilityOf(editProjectButton));
        editProjectButton.click();
    }

    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1150));
        wait.until(ExpectedConditions.visibilityOf(submitEditedProjectButton));
        submitEditedProjectButton.click();
    }



    //assert method
    public boolean isEditProjectButtonPresent(){
        return editProjectButton.isDisplayed();
    }

    public boolean isProjectNameInputFieldPresent(){
        return projectNameInputField.isDisplayed();
    }

    public boolean isProjectDescriptionInputFieldPresent(){
        return projectDescriptionInputField.isDisplayed();
    }

    public boolean isProjectStatusDropdownMenuPresent(){
        return projectStatusDropdownMenu.isDisplayed();
    }

    public boolean isSubmitButtonPresent(){
        return submitEditedProjectButton.isDisplayed();
    }
}

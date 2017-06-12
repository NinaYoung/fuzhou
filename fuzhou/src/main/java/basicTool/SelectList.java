package basicTool;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.customize.reporter.WebReporter;

public class SelectList {

    WebDriver driver;
    By menuItemBy = By.cssSelector(""); // option
    By dropDownArrowBy = By.cssSelector(""); // dropdownbutton
    By textBoxLabelBy = By.cssSelector(""); // textlabel
    By menuItemCheckBy = By.cssSelector(""); // option checkbox
    WebElement selectButton; // parent div!!!

    public SelectList(WebDriver driver, WebElement selectButton) {
        this.driver = driver;
        this.selectButton = selectButton;
    }

    public SelectList(WebDriver driver, WebElement selectButton, By menuItemBy) {
        this.driver = driver;
        this.selectButton = selectButton;
        this.menuItemBy = menuItemBy;
    }

    public SelectList(WebDriver driver, WebElement selectButton, By menuItemBy, By dropDownArrowBy) {
        this.driver = driver;
        this.selectButton = selectButton;
        this.menuItemBy = menuItemBy;
        this.dropDownArrowBy = dropDownArrowBy;
    }

    public void selectByLabel(String option) throws Exception {
        clickOnDropDown();
        List<WebElement> optionElements = driver.findElements(menuItemBy);
        for (WebElement optionElement : optionElements) {
            if (optionElement.getText().equals(option)) {
                optionElement.click();
                return;
            }
        }
        throw new Exception("The expected option is not listed in select list options");
    }

    public void selectByPartialLabel(String option) throws Exception {
        clickOnDropDown();
    //    WebReporter.log(driver, driver.getTitle(), true, true);
        List<WebElement> optionElements = driver.findElements(menuItemBy);
        for (WebElement optionElement : optionElements) {
            if (optionElement.getText().contains(option)) {
                optionElement.click();
                return;
            }
        }
        throw new Exception("The expected option is not listed in select list options");
    }

    public void selectByIndex(int index) throws Exception {
        clickOnDropDown();
      //  WebReporter.log(driver, driver.getTitle(), true, true);
        List<WebElement> optionElements = driver.findElements(menuItemBy);
        if (optionElements.size() == 0)
            throw new Exception("The expected option is not listed in select list options");
        optionElements.get(index).click();
    }

    public void selectByIndexNoClickDropDown(int index) throws Exception {
        List<WebElement> optionElements = driver.findElements(menuItemBy);
        if (optionElements.size() == 0)
            throw new Exception("The expected option is not listed in select list options");
        optionElements.get(index).click();
    }

    public List<String> getAllAvailableOptions() {
        clickOnDropDown();
        return getAllDisplayedOptions();
    }

    public void clickOnDropDown() {
        try {
            WebElement dijitArrowButton = selectButton.findElement(dropDownArrowBy);
            dijitArrowButton.click();
        } catch (Exception e) {
            selectButton.click();
        }
        try {
            WaitTool.waitFor(driver, ExpectedConditions.visibilityOfElementLocated(menuItemBy),
                    WaitTool.DEFAULT_WAIT_4_ELEMENT);
        } catch (Exception e) {
            WebElement dijitArrowButton = selectButton.findElement(dropDownArrowBy);
            dijitArrowButton.click();
            WaitTool.waitFor(driver, ExpectedConditions.visibilityOfElementLocated(menuItemBy),
                    WaitTool.DEFAULT_WAIT_4_ELEMENT);
        }

    }

    public void clickOnDropDownWithoutWait() {
        try {
            // driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebElement dijitArrowButton = selectButton.findElement(dropDownArrowBy);
            dijitArrowButton.click();
        } catch (Exception e) {
            selectButton.click();
        }
    }

    public String getSelectedValue() {
        try {
            List<WebElement> dijitValidationTextBoxLabel = selectButton.findElements(textBoxLabelBy);
            return dijitValidationTextBoxLabel.get(0).getText();
        } catch (Exception e) {
            return selectButton.getText();
        }
    }

    // This method is for quickfill, no need to click dropdown button
    public List<String> getAllDisplayedOptions() {
        WaitTool.waitFor(driver, ExpectedConditions.visibilityOfElementLocated(menuItemBy),
                WaitTool.DEFAULT_WAIT_4_ELEMENT);
        List<String> menuItemElements = new ArrayList<String>();
        List<WebElement> optionElements = driver.findElements(menuItemBy);
        for (WebElement optionElement : optionElements) {
            menuItemElements.add(optionElement.getText());
        }
        return menuItemElements;
    }

    public List<WebElement> getAllDisplayedOptionsElement() {
        WaitTool.waitFor(driver, ExpectedConditions.visibilityOfElementLocated(menuItemBy),
                WaitTool.DEFAULT_WAIT_4_ELEMENT);
        List<WebElement> optionElements = driver.findElements(menuItemBy);
        return optionElements;
    }

    public void setMultipleCheckBox(int amount, boolean status) {
        clickOnDropDown();
        List<WebElement> checkBoxList = driver.findElements(menuItemCheckBy);
        if (amount > checkBoxList.size())
            new Exception("the amount big than checkbox size");
        for (int i = 0; i < amount; i++) {
            if (status == true)
                checkBoxList.get(i).click();
            else {
                for (int j = 0; j < 3; j++) {
                    if (checkBoxList.get(i).isSelected()) {
                        checkBoxList.get(i).click();
                    }
                }
                if (checkBoxList.get(i).isSelected() == true)
                    new Exception("can't uncheck this checkbox");
            }
        }
    }

}

package ru.training.at.hw7jdi.site.sections;

import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Text;
import java.util.Arrays;
import org.openqa.selenium.By;
import ru.training.at.hw7jdi.data.ReadData;
import ru.training.at.hw7jdi.entities.MetalsColorsData;

public class MetalsColorForm {
    public static int numberOfData;
    public static By oddNumber = By.xpath("//*[@id='odds-selector']/p/label[text()='%s']");
    public static By evenNumber = By.xpath("//*[@id='even-selector']/p/label[text()='%s']");
    public static By natureElement = By.xpath("//*[@id='elements-checklist']/p/label[text()='%s']");

    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[ui=droplist]",
               list = "li",
               expand = ".caret")
    public static Dropdown vegetables;

    @XPath("//li[@class='summ-res']")
    public static Text summaryResult;

    @XPath("//li[@class='elem-res']")
    public static Text elementsResult;

    @XPath("//li[@class='col-res']")
    public static Text colorResult;

    @XPath("//li[@class='met-res']")
    public static Text metalResult;

    @XPath("//li[@class='sal-res']")
    public static Text vegetablesResult;

    public static UIElement getOddNumber() {
        return new UIElement(
            WebDriverByUtils.fillByTemplate(oddNumber, ReadData.readJsonForMetalsColors(numberOfData).summary[0]));
    }

    public static UIElement getEvenNumber() {
        return new UIElement(
            WebDriverByUtils.fillByTemplate(evenNumber, ReadData.readJsonForMetalsColors(numberOfData).summary[1]));
    }

    public static UIElement getNatureElement(String element) {
        return new UIElement(WebDriverByUtils.fillByTemplate(natureElement, element));
    }

    public static void fillByData(int numberOfData) {
        MetalsColorForm.numberOfData = numberOfData;
        getOddNumber().click();
        getEvenNumber().click();
        Arrays.stream(ReadData.readJsonForMetalsColors(numberOfData).elements)
              .forEach(s -> getNatureElement(s).click());
        colors.select(ReadData.readJsonForMetalsColors(numberOfData).color);
        metals.select(ReadData.readJsonForMetalsColors(numberOfData).metals);
        vegetables.select("Vegetables");
        Arrays.stream(ReadData.readJsonForMetalsColors(numberOfData).vegetables)
              .forEach(s -> vegetables.select(s));
    }

    public static void checkByData(int numberOfData) {
        MetalsColorsData metalsColorsData = ReadData.readJsonForMetalsColors(numberOfData);
        summaryResult.is().text("Summary: " + (metalsColorsData.summary[0] + metalsColorsData.summary[1]));
        elementsResult.is()
                      .text("Elements: " + String.join(", ", metalsColorsData.elements));
        colorResult.is().text("Color: " + metalsColorsData.color);
        metalResult.is().text("Metal: " + metalsColorsData.metals);
        vegetablesResult.is().text(
            "Vegetables: " + String.join(", ", metalsColorsData.vegetables));
    }
}

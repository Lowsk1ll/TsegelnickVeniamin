package ru.training.at.hw7jdi.site.sections.metalcolors;

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
import ru.training.at.hw7jdi.site.sections.metalcolors.elements.NatureElements;

public class MetalsColorForm {
    public static int numberOfData;
    public static String file;
    public static By oddNumber = By.xpath("//*[@id='odds-selector']/p/label[text()='%s']");
    public static By evenNumber = By.xpath("//*[@id='even-selector']/p/label[text()='%s']");

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
               value = "div#vegetables>div>button.btn",
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

    @XPath("//*[@id='elements-checklist']")
    public static NatureElements natureElements;

    public static UIElement getOddNumber() {
        return new UIElement(
            WebDriverByUtils
                .fillByTemplate(oddNumber, ReadData.readJsonForMetalsColors(file, numberOfData).summary[0]));
    }

    public static UIElement getEvenNumber() {
        return new UIElement(
            WebDriverByUtils
                .fillByTemplate(evenNumber, ReadData.readJsonForMetalsColors(file, numberOfData).summary[1]));
    }

    public static void fillByData(String file, int numberOfData) {
        MetalsColorForm.numberOfData = numberOfData;
        MetalsColorForm.file = file;
        getOddNumber().click();
        getEvenNumber().click();
        natureElements.deselectAllNatureElements();
        deselectAllVegetables();
        MetalsColorsData metalsColorsData = ReadData.readJsonForMetalsColors(file, numberOfData);
        Arrays.stream(metalsColorsData.elements).forEach(s -> natureElements.getElement(s).click());
        colors.select(metalsColorsData.color);
        metals.select(metalsColorsData.metals);
        Arrays.stream(metalsColorsData.vegetables)
              .forEach(s -> vegetables.select(s));
    }

    public static void checkByData(String file, int numberOfData) {
        MetalsColorsData metalsColorsData = ReadData.readJsonForMetalsColors(file, numberOfData);
        summaryResult.is().text("Summary: " + (metalsColorsData.summary[0] + metalsColorsData.summary[1]));
        elementsResult.is()
                      .text("Elements: " + String.join(", ", metalsColorsData.elements));
        colorResult.is().text("Color: " + metalsColorsData.color);
        metalResult.is().text("Metal: " + metalsColorsData.metals);
        vegetablesResult.is().text(
            "Vegetables: " + String.join(", ", metalsColorsData.vegetables));
    }

    public static void deselectAllVegetables() {
        Arrays.stream(vegetables.getValue().split(",")).filter(s -> (!s.isEmpty())).forEach(s -> vegetables.select(s));
    }
}

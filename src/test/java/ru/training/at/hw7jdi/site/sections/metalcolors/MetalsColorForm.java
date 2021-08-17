package ru.training.at.hw7jdi.site.sections.metalcolors;

import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import java.util.Arrays;
import org.openqa.selenium.By;
import ru.training.at.hw7jdi.entities.MetalsColorsData;
import ru.training.at.hw7jdi.site.sections.metalcolors.elements.NatureElements;

public class MetalsColorForm {
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

    @XPath("//*[text()=\"Submit\"]")
    public static Button submit;

    public static UIElement getOddNumber(MetalsColorsData data) {
        return new UIElement(
            WebDriverByUtils
                .fillByTemplate(oddNumber, data.summary[0]));
    }

    public static UIElement getEvenNumber(MetalsColorsData data) {
        return new UIElement(
            WebDriverByUtils
                .fillByTemplate(evenNumber, data.summary[1]));
    }

    public static void fillByData(MetalsColorsData metalsColorsData) {
        getOddNumber(metalsColorsData).click();
        getEvenNumber(metalsColorsData).click();
        Arrays.stream(metalsColorsData.elements).forEach(element -> natureElements.getElement(element).click());
        colors.select(metalsColorsData.color);
        metals.select(metalsColorsData.metals);
        Arrays.stream(metalsColorsData.vegetables)
              .forEach(vegetable -> vegetables.select(vegetable));
    }

    public static void checkByData(MetalsColorsData data) {
        summaryResult.is().text("Summary: " + (data.summary[0] + data.summary[1]));
        elementsResult.is()
                      .text("Elements: " + String.join(", ", data.elements));
        colorResult.is().text("Color: " + data.color);
        metalResult.is().text("Metal: " + data.metals);
        vegetablesResult.is().text(
            "Vegetables: " + String.join(", ", data.vegetables));
    }

    public static void deselectAllVegetables() {
        Arrays.stream(vegetables.getValue().split(",")).filter(s -> (!s.isEmpty())).forEach(s -> vegetables.select(s));
    }
}

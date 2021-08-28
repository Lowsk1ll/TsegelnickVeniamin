package ru.training.at.hw7jdi.site.sections.result;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Text;
import ru.training.at.hw7jdi.entities.MetalsColorsData;

public class Result extends Section {
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

    public void checkResults(MetalsColorsData data) {
        summaryResult.is().text("Summary: " + (data.summary[0] + data.summary[1]));
        elementsResult.is()
                      .text("Elements: " + String.join(", ", data.elements));
        colorResult.is().text("Color: " + data.color);
        metalResult.is().text("Metal: " + data.metals);
        vegetablesResult.is().text(
            "Vegetables: " + String.join(", ", data.vegetables));
    }
}

package ru.training.at.hw7jdi.site.sections.metalcolors;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.Arrays;
import ru.training.at.hw7jdi.entities.MetalsColorsData;
import ru.training.at.hw7jdi.site.sections.metalcolors.elements.NatureElements;

public class MetalsColorForm extends Form<MetalsColorsData> {
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

    @FindBy(id = "elements-checklist")
    public static NatureElements natureElements;

    @XPath("//*[text()='Submit']")
    public Button submit;

    @UI("[name='custom_radio_odd']")
    public static RadioButtons oddNumbers;

    @UI("[name='custom_radio_even']")
    public static RadioButtons evenNumbers;

    @Override
    public void fill(MetalsColorsData entity) {
        oddNumbers.select(entity.summary[0].toString());
        evenNumbers.select(entity.summary[1].toString());
        Arrays.stream(entity.elements).forEach(element -> natureElements.getElement(element).click());
        colors.select(entity.color);
        metals.select(entity.metals);
        Arrays.stream(entity.vegetables)
              .forEach(vegetable -> vegetables.select(vegetable));
    }


    public static void deselectAllVegetables() {
        Arrays.stream(vegetables.getValue().split(",")).filter(s -> (!s.isEmpty())).forEach(s -> vegetables.select(s));
    }
}

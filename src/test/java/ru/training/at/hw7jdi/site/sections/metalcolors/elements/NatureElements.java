package ru.training.at.hw7jdi.site.sections.metalcolors.elements;

import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import java.util.stream.Stream;

public class NatureElements {
    @XPath("//*[@id='elements-checklist']/p[contains(.,'Water')]/input")
    public static Checkbox Water;
    @XPath("//*[@id='elements-checklist']/p[contains(.,'Earth')]/input")
    public static Checkbox Earth;
    @XPath("//*[@id='elements-checklist']/p[contains(.,'Wind')]/input")
    public static Checkbox Wind;
    @XPath("//*[@id='elements-checklist']/p[contains(.,'Fire')]/input")
    public static Checkbox Fire;

    public Checkbox getElement(String element) {
        return Stream.of(Water, Wind, Earth, Fire).filter(s -> s.getName().equals(element)).findFirst().get();
    }

    public void deselectAllNatureElements() {
        Stream.of(Water, Wind, Earth, Fire).filter(CanBeSelected::isSelected).forEach(Checkbox::click);
    }
}

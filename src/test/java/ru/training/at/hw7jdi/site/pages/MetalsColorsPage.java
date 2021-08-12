package ru.training.at.hw7jdi.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw7jdi.site.sections.metalcolors.MetalsColorForm;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @XPath("//*[@class='form']")
    public MetalsColorForm metalsColorForm;

}

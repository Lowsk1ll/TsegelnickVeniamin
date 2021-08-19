package ru.training.at.hw7jdi.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import ru.training.at.hw7jdi.site.sections.metalcolors.MetalsColorForm;
import ru.training.at.hw7jdi.site.sections.result.Result;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @XPath("//*[@class='form']")
    public MetalsColorForm metalsColorForm;

    @Css(".info-panel-body.info-panel-body-result")
    public Result result;

}

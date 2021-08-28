package ru.training.at.hw7jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw7jdi.entities.User;

public class LoginForm extends Form<User> {

    @FindBy(xpath = "//input[@id='name']")
    public TextField username;

    @FindBy(xpath = "//input[@id='password']")
    public TextField password;

    @FindBy(xpath = "//button[@type='submit']")
    public Button submit;
}

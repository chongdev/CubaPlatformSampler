package com.company.cubaplatformsampler.web.screens.login;

import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("cubaplatformsampler_LoginScreen")
@UiDescriptor("login-screen.xml")
public class LoginScreen extends Screen {

    @Inject
    private Button btnSubmit;
    @Inject
    private Button btnCancel;
    @Inject
    private Button btnClear;
    @Inject
    private TextField<String> textField;
    @Inject
    private Notifications notifications;

    boolean isClear = true;

    @Subscribe("textField")
    public void onTextFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        // TODO TextField Event เมื่อมีข้อมูลเปลี่ยน
        btnClear.setEnabled(true);
    }
    @Subscribe("textField")
    public void onTextFieldEnterPress(TextInputField.EnterPressEvent event) {
        // TODO TextField Event กด enter
    }

    @Subscribe("textField")
    public void onTextFieldTextChange(TextInputField.TextChangeEvent event) {
        // TODO TextField Event เมื่อมีข้อมูลเปลี่ยน
        btnSubmit.setEnabled(true);
    }

    @Subscribe("btnSubmit")
    public void onBtnSubmitClick(Button.ClickEvent event) {
        // TODO onClick

        textField.setEnabled(false);
        btnSubmit.setEnabled(false);
    }

    @Subscribe("btnCancel")
    public void onBtnCancelClick(Button.ClickEvent event) {

        // TODO Notifications
        notifications.create(Notifications.NotificationType.WARNING).withCaption("Cancel").show();
    }

    @Subscribe("btnClear")
    public void onBtnClearClick(Button.ClickEvent event) {
        textField.setEnabled(true);
        btnSubmit.setEnabled(true);

        textField.setValue("");
        textField.isFocusable();
    }

}
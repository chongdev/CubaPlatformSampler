package com.company.cubaplatformsampler.web.screens.user;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("cubaplatformsampler_UserScreen")
@UiDescriptor("user-screen.xml")
public class UserScreen extends Screen {

    @Inject
    private Label<String> userId;

    @Inject
    private Label<String> userName;

    @Subscribe("btnGetUser")
    public void onBtnGetUserClick(Button.ClickEvent event) {

        userName.setValue( "userName: Loading..." );
    }

    @Subscribe("inputUserId")
    public void onInputUserIdTextChange(TextInputField.TextChangeEvent event) {

        userName.setValue( "userName: Null" );
        userId.setValue( "userId: " + event.getText() );
    }



}
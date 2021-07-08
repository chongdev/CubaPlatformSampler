package com.company.cubaplatformsampler.web.screens.component;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("cubaplatformsampler_JavaScriptComponent")
@UiDescriptor("java-script-component.xml")
public class JavaScriptComponent extends Screen {

    @Inject
    private com.haulmont.cuba.web.gui.components.JavaScriptComponent demoJs;

    @Inject
    private Button showValueBtn;

    @Subscribe("showValueBtn")
    public void onShowValueBtnClick(Button.ClickEvent event) {
        demoJs.callFunction("showValue");
    }
    
    
}
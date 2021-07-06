package com.company.cubaplatformsampler.web.screens.session;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubaplatformsampler.entity.Session;

@UiController("cubaplatformsampler_Session.edit")
@UiDescriptor("session-edit.xml")
@EditedEntityContainer("sessionDc")
@LoadDataBeforeShow
public class SessionEdit extends StandardEditor<Session> {
}
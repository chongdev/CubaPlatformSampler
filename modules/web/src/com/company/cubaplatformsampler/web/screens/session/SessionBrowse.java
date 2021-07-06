package com.company.cubaplatformsampler.web.screens.session;

import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubaplatformsampler.entity.Session;

import javax.inject.Inject;

@UiController("cubaplatformsampler_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
    @Inject
    private VBoxLayout tab;
}
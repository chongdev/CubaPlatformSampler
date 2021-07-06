package com.company.cubaplatformsampler.web.screens.session;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubaplatformsampler.entity.Session;

import javax.inject.Inject;
import java.util.Date;

@UiController("cubaplatformsampler_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {
    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventClick(Calendar.CalendarEventClickEvent<Date> event) {
         Screen screen = screenBuilders.editor(Session.class, this).editEntity((Session) event.getEntity()).withLaunchMode(OpenMode.DIALOG).build();

         screen.addAfterCloseListener(afterCloseEvent -> {
             getScreenData().loadAll();
         });

         screen.show();
    }
    
}
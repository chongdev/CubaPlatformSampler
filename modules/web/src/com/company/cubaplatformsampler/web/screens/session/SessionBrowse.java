package com.company.cubaplatformsampler.web.screens.session;

import com.company.cubaplatformsampler.service.SessionService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.calendar.EntityCalendarEvent;
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

    @Inject
    private SessionService SessionService;

    @Inject
    private Notifications notifications;

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventClick(Calendar.CalendarEventClickEvent event) {
         Screen screen = screenBuilders.editor(Session.class, this)
                 .editEntity((Session) event.getEntity())
                 .withLaunchMode(OpenMode.DIALOG).build();

         screen.addAfterCloseListener(afterCloseEvent -> {
             getScreenData().loadAll();
         });

         screen.show();
    }

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventMove(Calendar.CalendarEventMoveEvent event) {

//        notifications.create(Notifications.NotificationType.WARNING)
//            .withCaption("Session ")
//            .show();

//        Session session = ((EntityCalendarEvent<Session>)event.getCalendarEvent()).getEntity();
//
//        if(!SessionService.rescheduleSession(session, event.getNewStart()) ){
//            notifications.create(Notifications.NotificationType.WARNING)
//                    .withCaption("Session "+session.getTopic()+ " cannot be reschedule")
//                    .show();
//        }
//
//        getScreenData().loadAll();
    }

    
}
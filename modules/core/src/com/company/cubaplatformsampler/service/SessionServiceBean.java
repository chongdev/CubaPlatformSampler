package com.company.cubaplatformsampler.service;

import com.company.cubaplatformsampler.entity.Session;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

@Service(SessionService.NAME)
public class SessionServiceBean implements SessionService {

    @Inject
    private DataManager dataManage;

    @Override
    public boolean rescheduleSession(Session session, Date newStarDate) {

        Date newEndDate = Session.calculateEndDate(newStarDate);
        int sessionSameTime = dataManage.load(Session.class)
                .query("select s form cubaplatformsampler_Session s where " +
                        "s.startDate < :newEndDate and s.endDate > :newStartDate " +
                        "and s.speaker = :speaker " +
                        "and s.id <> :sessionId"
                )
                .parameter("newStartDate", newStarDate)
                .parameter("newEndDate", newEndDate)
                .parameter("speaker",   session.getSpeaker())
                .parameter("sessionId", session.getId())
                .list().size();

        if (sessionSameTime == 0){
            session.setStartDate(newStarDate);
            dataManage.commit(session);
            return true;
        }

        return false;
    }
}
package com.company.cubaplatformsampler.service;

import com.company.cubaplatformsampler.entity.Session;

import java.util.Date;

public interface SessionService {
    String NAME = "cubaplatformsampler_SessionService";

    boolean rescheduleSession(Session session, Date newStarDate);
}
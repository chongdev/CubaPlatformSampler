package com.company.cubaplatformsampler.service;

import com.company.cubaplatformsampler.entity.Speaker;

import java.util.List;

public interface SpeakerService {
    String NAME = "cubaplatformsampler_SpeakerService";

    String findUser(String name);
    List<Speaker> find(String id);
    List<Speaker> getUser();
}
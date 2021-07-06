package com.company.cubaplatformsampler.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubaplatformsampler.entity.Speaker;

@UiController("cubaplatformsampler_Speaker.browse")
@UiDescriptor("speaker-browse.xml")
@LookupComponent("speakersTable")
@LoadDataBeforeShow
public class SpeakerBrowse extends StandardLookup<Speaker> {
}
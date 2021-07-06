package com.company.cubaplatformsampler.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubaplatformsampler.entity.Speaker;

@UiController("cubaplatformsampler_Speaker.edit")
@UiDescriptor("speaker-edit.xml")
@EditedEntityContainer("speakerDc")
@LoadDataBeforeShow
public class SpeakerEdit extends StandardEditor<Speaker> {
}
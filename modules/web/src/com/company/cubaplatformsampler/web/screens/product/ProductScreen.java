package com.company.cubaplatformsampler.web.screens.product;

import com.company.cubaplatformsampler.entity.Speaker;
import com.company.cubaplatformsampler.service.SpeakerService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.entity.User;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.List;

@UiController("cubaplatformsampler_ProductScreen")
@UiDescriptor("product-screen.xml")
public class ProductScreen extends Screen {

    @Inject
    private Logger log;
    @Inject
    private Label<String> showResult;
    @Inject
    private TextField<String> inputSearch;
    @Inject
    private SpeakerService speakerService;
    @Inject
    private Label<String> showUser;

    @Subscribe
    public void onInit(InitEvent event) {
        inputSearch.setValue("Chong");
    }

    @Subscribe("btnSearch")
    public void onBtnSearchClick(Button.ClickEvent event) {
        searchData();
    }

    public void searchData() {

//        log.info("After CallBack");

        showResult.setValue("Loading...");

        String name = inputSearch.getValue().trim();

        // TODO get user form name
        String speaker = speakerService.findUser( "aaa" );

        if (speaker == null) {
            showResult.setValue( "Error..." + speaker + "__input name: " + name );
        }
        else{
            showResult.setValue( "Ok -> " + speaker );
        }


        // TODO get user form id
        List<Speaker> user = speakerService.find("8c1062fb-6d74-fd25-6a8a-b80c2bdf00cf");

        if( user == null ){
            showUser.setValue( "Error user -> " );
        }
//        for ( user ) {
//
//        }
    }
}
package com.example.hackathonsbee.tests;

import com.example.hackathonsbee.appManager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager();

    @BeforeEach
    void setUp(){
        app.init();
    }


    @AfterEach
    public void tearDown() {
        app.stop();
    }

}

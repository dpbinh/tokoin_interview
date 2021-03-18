package com.dpbinh.search;

import com.dpbinh.search.gui.ViewFactory;
import com.dpbinh.search.gui.ViewName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory
            .getLogger(MainApp.class);

    @Autowired
    private ViewFactory viewFactory;

    public static void main(String[] args) {
         SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            viewFactory.getView(ViewName.MAIN).draw(viewFactory, new HashMap<>());
        } catch (Exception e) {
            System.out.printf("Application get exception %s", e.getMessage());
            logger.error("Application get exception", e);
        }
    }
}

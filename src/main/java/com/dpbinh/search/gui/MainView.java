package com.dpbinh.search.gui;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class MainView implements View {

    @Override
    public void draw(Map<String, Object> params) {
        System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue\n\n");
        System.out.println("\t\tSelect search options:");
        System.out.println("\t\t - Press 1 to search");
        System.out.println("\t\t - Press 2 to view a list of searchable fields");
        System.out.println("\t\t - Type 'quit' to exit");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

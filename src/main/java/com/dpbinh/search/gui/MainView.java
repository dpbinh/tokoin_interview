package com.dpbinh.search.gui;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;

@Component
public class MainView implements View {

    @Override
    public ViewName getName() {
        return ViewName.MAIN;
    }

    @Override
    public void draw(ViewFactory viewFactory, Map<String, Object> params) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {

            System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue\n\n");
            System.out.println("\t\tSelect search options:");
            System.out.println("\t\t - Press 1 to search");
            System.out.println("\t\t - Press 2 to view a list of searchable fields");
            System.out.println("\t\t - Type 'quit' to exit");

            String selection = scanner.nextLine();
            switch (selection) {
                case "1": {
                    viewFactory.getView(ViewName.SEARCH).draw(viewFactory, params);
                } break;
                case "2": {
                    viewFactory.getView(ViewName.SEARCHABLE_LIST).draw(viewFactory, params);
                } break;
                case "quit": running = false;
            }
        }


    }
}

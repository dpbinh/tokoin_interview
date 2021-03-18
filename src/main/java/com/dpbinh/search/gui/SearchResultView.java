package com.dpbinh.search.gui;

import com.dpbinh.search.config.Constants;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SearchResultView implements View {
    @Override
    public ViewName getName() {
        return ViewName.SEARCH_RESULT;
    }

    @Override
    public void draw(ViewFactory viewFactory, Map<String, Object> params) throws Exception {
        List searchResult = (List)params.get(Constants.SEARCH_RESULT_DATA);

        if(searchResult == null) {
            return;
        }

        for(Object object : searchResult) {
            System.out.println("-------------------------------");
            System.out.println(object.toString());
            System.out.println("-------------------------------");
        }
    }
}

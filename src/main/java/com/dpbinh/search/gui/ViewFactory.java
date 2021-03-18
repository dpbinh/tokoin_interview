package com.dpbinh.search.gui;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ViewFactory {
    private Map<ViewName, View> viewMap;

    public ViewFactory(List<View> views) {
        viewMap = views.stream().collect(Collectors.toMap(View::getName, Function.identity(), (p1, p2) -> p2));
    }

    public View getView(ViewName viewName) {
        View view = viewMap.get(viewName);

        if(view == null) {
            throw new IllegalArgumentException(String.format("Not found view for name %s", viewName));
        }

        return view;
    }
}

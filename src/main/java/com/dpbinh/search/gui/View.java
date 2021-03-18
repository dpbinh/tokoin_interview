package com.dpbinh.search.gui;

import java.util.Map;

public interface View {
    ViewName getName();

    void draw(ViewFactory viewFactory, Map<String, Object> params) throws Exception;
}

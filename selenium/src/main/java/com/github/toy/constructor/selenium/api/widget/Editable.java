package com.github.toy.constructor.selenium.api.widget;

import org.openqa.selenium.SearchContext;

public interface Editable<T> extends SearchContext {

    /**
     * Change value of some element (text in a text input field, select a checkbox/radiobutton etc.)
     * @param valueToSet as the value of some element
     */
    void edit(T valueToSet);
}

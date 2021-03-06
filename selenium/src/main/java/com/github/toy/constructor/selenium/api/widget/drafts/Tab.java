package com.github.toy.constructor.selenium.api.widget.drafts;

import com.github.toy.constructor.selenium.api.widget.Clickable;
import com.github.toy.constructor.selenium.api.widget.Labeled;
import com.github.toy.constructor.selenium.api.widget.Name;
import com.github.toy.constructor.selenium.api.widget.Widget;
import org.openqa.selenium.WebElement;

@Name("Tab")
public abstract class Tab extends Widget implements Clickable {
    public Tab(WebElement wrappedElement) {
        super(wrappedElement);
    }

    /**
     * @return is the tab selected or not.
     */
    public abstract boolean isActive();
}

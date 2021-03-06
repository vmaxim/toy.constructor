package com.github.toy.constructor.selenium.test.steps.tests.searching.widgets.select;

import com.github.toy.constructor.selenium.api.widget.Labeled;
import com.github.toy.constructor.selenium.api.widget.Name;
import com.github.toy.constructor.selenium.api.widget.Priority;
import com.github.toy.constructor.selenium.api.widget.drafts.Select;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
;
import static com.github.toy.constructor.selenium.test.FakeDOMModel.*;
import static com.github.toy.constructor.selenium.test.steps.tests.searching.widgets.WidgetNames.MULTI_SELECT;
import static com.github.toy.constructor.selenium.test.steps.tests.searching.widgets.WidgetNames.SIMPLE_SELECT;
import static java.util.stream.Collectors.toList;

@Name(MULTI_SELECT)
@FindBy(className = MULTI_SELECT_CLASS)
@Priority(2)
public class MultiSelect extends Select implements Labeled {

    @FindBy(className = ITEM_OPTION_CLASS)
    private List<WebElement> options;

    @FindAll({@FindBy(xpath = LABEL_XPATH),
            @FindBy(xpath = LABEL_XPATH2)})
    private List<WebElement> labels;

    public MultiSelect(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void edit(String valueToSet) {
        WebElement optionToSelect =
                options.stream().filter(option -> valueToSet.equals(option.getText()))
                        .findFirst().orElseThrow(() -> new NoSuchElementException("There is no option " + valueToSet));
        optionToSelect.click();
    }

    @Override
    public List<String> getValue() {
        return options.stream().filter(WebElement::isSelected).map(WebElement::getText).collect(toList());
    }

    @Override
    public List<String> labels() {
        return labels.stream().map(WebElement::getText).collect(toList());
    }
}

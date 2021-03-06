package com.github.toy.constructor.selenium.hamcrest.matchers.window;

import com.github.toy.constructor.selenium.functions.target.locator.window.Window;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;

public final class WindowHasTitleMatcher extends TypeSafeDiagnosingMatcher<Window> {

    private final Matcher<String> titleMatcher;

    private WindowHasTitleMatcher(Matcher<String> titleMatcher) {
        checkArgument(titleMatcher != null, "Criteria to match title of a window should be defined");
        this.titleMatcher = titleMatcher;
    }

    /**
     * Creates an instance of {@link WindowHasTitleMatcher} which checks attribute of an instance of {@link Window}.
     *
     * @param titleMatcher criteria to check title of a window
     * @return an instance of a {@link WindowHasTitleMatcher}
     */
    public static WindowHasTitleMatcher windowHasTitle(Matcher<String> titleMatcher) {
        return new WindowHasTitleMatcher(titleMatcher);
    }

    /**
     * Creates an instance of {@link WindowHasTitleMatcher} which checks attribute of an instance of {@link Window}.
     *
     * @param title expected title of a window
     * @return an instance of a {@link WindowHasTitleMatcher}
     */
    public static WindowHasTitleMatcher windowHasTitle(String title) {
        return windowHasTitle(equalTo(title));
    }

    @Override
    protected boolean matchesSafely(Window item, Description mismatchDescription) {
        String title;
        boolean result = titleMatcher.matches(title = item.getTitle());
        if (!result) {
            titleMatcher.describeMismatch(title, mismatchDescription);
        }
        return result;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(toString());
    }

    @Override
    public String toString() {
        return format("has title %s", titleMatcher);
    }
}

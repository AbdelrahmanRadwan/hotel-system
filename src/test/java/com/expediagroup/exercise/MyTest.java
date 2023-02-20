package com.expediagroup.exercise;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void testJunitStyle() {
        assertEquals("hello", "hello");
    }

    @Test
    public void testHamcrestStyle() {
        assertThat("hello", equalTo("hello"));
    }
}

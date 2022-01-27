package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutImperial() throws Exception {
        assertThat(queryProcessor.process("Imperial"),
                containsString("university"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowOurName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("tn"));
    }

    @Test
    public void largest() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 62, 391, 49"), containsString("391"));
    }

    @Test
    public void plus() throws Exception {
        assertThat(queryProcessor.process("what is 69 plus 70"), containsString("139"));
    }

    @Test
    public void multiplied() throws Exception {
        assertThat(queryProcessor.process("what is 20 multipled by 18"), containsString("360"));
    }
}

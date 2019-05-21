package testing;

import org.junit.Before;
import org.junit.Test;
import regexExercises.RegexExpr;

import static org.junit.Assert.*;

public class RegexExprTest {
    public RegexExpr regexExpr;

    @Before
    public void init() {
        regexExpr = new RegexExpr();
    }
    @Test
    public void test1() {
        assertTrue(regexExpr.matchToPattern("abc.*", "abc"));
        assertTrue(regexExpr.matchToPattern("abc.*", "abcdefg"));
        assertTrue(regexExpr.matchToPattern("abc.*", "abcde"));
    }
    @Test
    public void test2() {
        assertTrue(regexExpr.matchToPattern(".*123.*", "abc123xyz"));
        assertTrue(regexExpr.matchToPattern(".*123.*", "define \"123\""));
        assertTrue(regexExpr.matchToPattern(".*123.*", "var g = 123;"));
    }

    @Test
    public void test3() {
        assertTrue(regexExpr.matchToPattern(".*\\.", "cat."));
        assertTrue(regexExpr.matchToPattern(".*\\.", "896."));
        assertTrue(regexExpr.matchToPattern(".*\\.", "?=+."));
        assertFalse(regexExpr.matchToPattern(".*\\.", "abc1"));
    }

    @Test
    public void test4() {
        assertTrue(regexExpr.matchToPattern("[cmf].*", "can"));
        assertTrue(regexExpr.matchToPattern("[cmf].*", "man"));
        assertTrue(regexExpr.matchToPattern("[cmf].*", "fan"));
        assertFalse(regexExpr.matchToPattern("[cmf].*", "dan"));
        assertFalse(regexExpr.matchToPattern("[cmf].*", "ran"));
        assertFalse(regexExpr.matchToPattern("[cmf].*", "pan"));
    }

    @Test
    public void test5() {
        assertTrue(regexExpr.matchToPattern("^[^b].*", "hog"));
        assertTrue(regexExpr.matchToPattern("^[^b].*", "dog"));
        assertFalse(regexExpr.matchToPattern("^[^b].*", "bog"));
    }

    @Test
    public void test6() {
        assertTrue(regexExpr.matchToPattern("[A-Z].*", "Ana"));
        assertTrue(regexExpr.matchToPattern("[A-Z].*", "Bob"));
        assertTrue(regexExpr.matchToPattern("[A-Z].*", "Cpc"));
        assertFalse(regexExpr.matchToPattern("[A-Z].*", "aax"));
        assertFalse(regexExpr.matchToPattern("[A-Z].*", "bby"));
        assertFalse(regexExpr.matchToPattern("[A-Z].*", "ccz"));
    }
    @Test
    public void test7() {
        assertTrue(regexExpr.matchToPattern("^waz{2,5}up$", "wazzzzzup"));
        assertTrue(regexExpr.matchToPattern("^waz{2,5}up$", "wazzzup"));
        assertFalse(regexExpr.matchToPattern("^waz{2,5}up$", "wazup"));
    }
    @Test
    public void test8() {
        assertTrue(regexExpr.matchToPattern("a+b*c+", "aaaabcc"));
        assertTrue(regexExpr.matchToPattern("a+b*c+", "aabbcc"));
        assertTrue(regexExpr.matchToPattern("a+b*c+", "aacc"));
        assertFalse(regexExpr.matchToPattern("a+b*c+", "a"));
    }
    @Test
    public void test9() {
        assertTrue(regexExpr.matchToPattern(".*?\\?", "1 file found?"));
        assertTrue(regexExpr.matchToPattern(".*?\\?", "2 files found?"));
        assertTrue(regexExpr.matchToPattern(".*?\\?", "24 files found?"));
        assertFalse(regexExpr.matchToPattern(".*?\\?", "No file found."));

    }
    @Test
    public void test10() {
        assertTrue(regexExpr.matchToPattern("[0-9].\\s+abc", "1.   abc"));
        assertTrue(regexExpr.matchToPattern("[0-9].\\s+abc", "2.    abc"));
        assertTrue(regexExpr.matchToPattern("[0-9].\\s+abc", "3.           abc"));
        assertFalse(regexExpr.matchToPattern("[0-9].\\s+abc", "4.abc"));
    }
    @Test
    public void test11() {
        assertTrue(regexExpr.matchToPattern("^Mission: successful$", "Mission: successful"));
        assertFalse(regexExpr.matchToPattern("^Mission: successful$", "Last Mission: unsuccessful"));
        assertFalse(regexExpr.matchToPattern("^Mission: successful$", "Next Mission: successful upon capture of target"));

    }
    @Test
    public void test13() {
        assertTrue(regexExpr.matchToPattern("^(\\w*\\s(\\d*))$", "Jan 1987"));
        assertTrue(regexExpr.matchToPattern("^(\\w*\\s(\\d*))$", "May 1969"));
        assertTrue(regexExpr.matchToPattern("^(\\w*\\s(\\d*))$", "Aug 2011"));
    }
    @Test
    public void test14() {
        assertTrue(regexExpr.matchToPattern("(\\d{4})x(\\d{3,4})", "1280x720"));
        assertTrue(regexExpr.matchToPattern("(\\d{4})x(\\d{3,4})", "1920x1600"));
        assertTrue(regexExpr.matchToPattern("(\\d{4})x(\\d{3,4})", "1024x768"));
    }
    @Test
    public void test15() {
        assertTrue(regexExpr.matchToPattern("^I\\slove\\s(cats|dogs)$", "I love cats"));
        assertTrue(regexExpr.matchToPattern("^I\\slove\\s(cats|dogs)$", "I love dogs"));
        assertFalse(regexExpr.matchToPattern("^I\\slove\\s(cats|dogs)$", "I love logs"));
        assertFalse(regexExpr.matchToPattern("^I\\slove\\s(cats|dogs)$", "I love cats cogs"));
    }
    @Test
    public void test16() {
        assertTrue(regexExpr.matchToPattern("^[\\w\\W]*$", "The quick brown fox jumps over the lazy dog."));
        assertTrue(regexExpr.matchToPattern("^[\\w\\W]*$", "There were 614 instances of students getting 90.0% or above."));
        assertTrue(regexExpr.matchToPattern("^[\\w\\W]*$", "The FCC had to censor the network for saying &$#*@!."));
    }
    @Test
    public void test17() {
        assertTrue(regexExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "3.14529"));
        assertTrue(regexExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "-255.34"));
        assertTrue(regexExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "128"));
        assertTrue(regexExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "1.9e10"));
        assertTrue(regexExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "123,340.00"));
        assertTrue(regexExpr.matchToPattern("[\\-]*[\\d]+[\\.,]*[\\d]+[e\\d.]*", "720p"));
    }

}
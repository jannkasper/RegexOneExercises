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
        assertEquals(true, regexExpr.matchToPattern("abc.*", "abc"));
        assertEquals(true, regexExpr.matchToPattern("abc.*", "abcdefg"));
        assertEquals(true, regexExpr.matchToPattern("abc.*", "abcde"));
    }


}
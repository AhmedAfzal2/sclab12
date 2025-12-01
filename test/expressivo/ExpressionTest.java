package expressivo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {

    // ----------------------------------------------------------
    // Number tests
    // ----------------------------------------------------------

    @Test
    public void testNumberToString() {
        Expression n = new Number(5);
        assertEquals("5", n.toString());
        Expression d = new Number(3.14);
        assertEquals("3.14", d.toString());
    }

    @Test
    public void testNumberEquals() {
        assertEquals(new Number(5), new Number(5));
        assertNotEquals(new Number(5), new Number(6));
    }

    @Test
    public void testNumberHash() {
        assertEquals(new Number(5).hashCode(), new Number(5).hashCode());
    }


    // ----------------------------------------------------------
    // Variable tests
    // ----------------------------------------------------------

    @Test
    public void testVariableToString() {
        Expression v = new Variable("x");
        assertEquals("x", v.toString());
    }

    @Test
    public void testVariableEquals() {
        assertEquals(new Variable("x"), new Variable("x"));
        assertNotEquals(new Variable("x"), new Variable("y"));
    }

    @Test
    public void testVariableHash() {
        assertEquals(new Variable("x").hashCode(), new Variable("x").hashCode());
    }


    // ----------------------------------------------------------
    // Plus tests
    // ----------------------------------------------------------

    @Test
    public void testPlusToString() {
        Expression e = new Plus(new Variable("x"), new Number(3));
        assertEquals("x + 3", e.toString());
    }

    @Test
    public void testPlusEquals() {
        Expression p1 = new Plus(new Variable("x"), new Number(3));
        Expression p2 = new Plus(new Variable("x"), new Number(3));
        Expression p3 = new Plus(new Variable("y"), new Number(3));

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
    }

    @Test
    public void testPlusHash() {
        Expression p1 = new Plus(new Variable("x"), new Number(3));
        Expression p2 = new Plus(new Variable("x"), new Number(3));
        assertEquals(p1.hashCode(), p2.hashCode());
    }


    // ----------------------------------------------------------
    // Times tests
    // ----------------------------------------------------------

    @Test
    public void testTimesToString() {
        Expression e = new Multiply(new Number(2), new Variable("y"));
        assertEquals("2 * y", e.toString());
    }

    @Test
    public void testTimesEquals() {
        Expression t1 = new Multiply(new Number(2), new Variable("y"));
        Expression t2 = new Multiply(new Number(2), new Variable("y"));
        Expression t3 = new Multiply(new Number(2), new Variable("x"));

        assertEquals(t1, t2);
        assertNotEquals(t1, t3);
    }

    @Test
    public void testTimesHash() {
        Expression t1 = new Multiply(new Number(2), new Variable("y"));
        Expression t2 = new Multiply(new Number(2), new Variable("y"));
        assertEquals(t1.hashCode(), t2.hashCode());
    }


    // ----------------------------------------------------------
    // Mixed tests
    // ----------------------------------------------------------

    @Test
    public void testNestedExpressions() {
        Expression e1 = new Multiply(
                new Plus(new Variable("x"), new Number(1)),
                new Number(3)
        );

        Expression e2 = new Multiply(
                new Plus(new Variable("x"), new Number(1)),
                new Number(3)
        );

        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
        assertEquals("(x + 1) * 3".replace("(", "").replace(")", ""), e1.toString());
    }

    @Test
    public void testInequalityByStructure() {
        Expression e1 = new Plus(new Variable("x"), new Plus(new Variable("y"), new Number(1)));
        Expression e2 = new Plus(new Plus(new Variable("x"), new Variable("y")), new Number(1));

        assertNotEquals(e1, e2);
    }
}

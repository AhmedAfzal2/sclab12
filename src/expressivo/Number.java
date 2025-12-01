package expressivo;

public class Number implements Expression {
    private final double value;

    // RI: value is any finite double
    // AF: represents the numeric literal value

    public Number(double value) {
        this.value = value;
        checkRep();
    }

    private void checkRep() {
        assert !Double.isNaN(value);
        assert !Double.isInfinite(value);
    }

    @Override
    public String toString() {
        // remove trailing .0 for integers
        if (value == (long) value) {
            return Long.toString((long) value);
        }
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Number)) return false;
        Number that = (Number) obj;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}

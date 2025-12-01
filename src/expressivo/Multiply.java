package expressivo;

public class Multiply implements Expression {
    private final Expression left;
    private final Expression right;

    // RI: left != null, right != null
    // AF: represents (left * right)

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    private void checkRep() {
        assert left != null;
        assert right != null;
    }

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Multiply)) return false;
        Multiply that = (Multiply) obj;
        return left.equals(that.left) && right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return 37 * left.hashCode() + right.hashCode();
    }
}

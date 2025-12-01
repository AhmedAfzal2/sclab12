package expressivo;

public class Variable implements Expression {
    private final String name;

    // RI: name must be nonempty and [A-Za-z]+
    // AF: represents the variable with that name

    public Variable(String name) {
        this.name = name;
        checkRep();
    }

    private void checkRep() {
        assert name != null;
        assert name.matches("[A-Za-z]+");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Variable)) return false;
        Variable that = (Variable) obj;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

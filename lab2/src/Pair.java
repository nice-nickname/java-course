public abstract class Pair {
    
    protected int a;
    protected int b;

    protected Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract void add(Pair other);

    public abstract void subtract(Pair other);

    public abstract void multiply(Pair other);

    public abstract void divide(Pair other);
}

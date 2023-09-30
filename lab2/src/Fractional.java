public class Fractional extends Pair {

    public Fractional(int numerator, int denominator) {
        super(numerator, Fractional.validateDenominator(denominator));
    }

    @Override
    public void add(Pair other) {
        if (this.b == other.b) {
            this.a += other.a;
            return;
        }

        int commonDenominator = this.b * other.b;
        this.a = this.a * other.b + other.a * this.b;
        this.b = commonDenominator;
    }

    @Override
    public void subtract(Pair other) {
        this.add(new Fractional(-other.a, other.b));
    }

    @Override
    public void multiply(Pair fractional) {
        this.a *= fractional.a;
        this.b *= fractional.b;
    }

    @Override
    public void divide(Pair other) {
        if (other.a == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        this.a *= other.b;
        this.b *= other.a;
    }

    @Override
    public String toString() {
        return a + "/" + b;
    }

    public static int validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return denominator;
    }
}

public class Complex extends Pair {

    public Complex(int real, int imaginary) {
        super(real, imaginary);
    }

    @Override
    public void add(Pair complex) {
        this.a += complex.a;
        this.b += complex.b;
    }

    @Override
    public void subtract(Pair complex) {
        this.a -= complex.a;
        this.b -= complex.b;
    }

    @Override
    public void multiply(Pair complex) {
        int newReal = (this.a * complex.a) - (this.b * complex.b);
        int newImaginary = (this.a * complex.b) + (this.b * complex.a);
        this.a = newReal;
        this.b = newImaginary;
    }

    @Override
    public void divide(Pair complex) {
        int denominator = (complex.a * complex.a) + (complex.b * complex.b);
        int newReal = ((this.a * complex.a) + (this.b * complex.b)) / denominator;
        int newImaginary = ((this.b * complex.a) - (this.a * complex.b)) / denominator;
        
        this.a = newReal;
        this.b = newImaginary;
    }

    @Override
    public String toString() {
        return "(" + a + " + " + b + "i)";
    }
}

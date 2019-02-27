package Complex;

class Complex implements Cloneable, Comparable<Complex> {
    private double a, b;

    public Complex() {
        this(0);
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex add(Complex complex) {
        return new Complex((a + complex.a), (b + complex.b));
    }
    public Complex subtract(Complex complex) {
        return new Complex((a - complex.a), (b - complex.b));

    }
    public Complex multiply(Complex complex) {
        return new Complex((a * complex.a - b * complex.b), (b * complex.a + a * complex.b));

    }
    public Complex divide(Complex complex) {
        return new Complex( (a*complex.a+b*complex.b) / ((Math.pow(complex.a, 2) + Math.pow(complex.b, 2))),
                (b * complex.a - a * complex.b) / ((Math.pow(complex.a, 2) + Math.pow(complex.b, 2))));
    }

    public double abs() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart(){
        return b;
    }

    @Override
    public String toString() {
        if (b == 0) {
            return a + "";
        }
        return  a + " + " + b + "i";
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public int compareTo(Complex o) {
        if (this.abs() > o.abs())
            return 1;
        else if (this.abs() < o.abs())
            return -1;
        else
            return 0;
    }
}
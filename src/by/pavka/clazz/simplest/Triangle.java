package by.pavka.clazz.simplest;
/*
* Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления площади, периметра и точки пересечения медиан
 */
import static java.lang.Math.*;

public class Triangle {

    private double a;
    private double b;
    private double c;

    private double alpha;
    private double beta;
    private double gamma;

    private Triangle() {

        a = 1;
        b = 1;
        c = 1;
        alpha = PI / 3;
        beta = PI / 3;
        gamma = PI / 3;
    }

    public static Triangle byThreeSides(double a, double b, double c) {

        Triangle triangle = new Triangle();

        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Wrond data! Created the default triangle");
            return triangle;
        }

        triangle.a = a;
        triangle.b = b;
        triangle.c = c;

        triangle.alpha = acos((b * b + c * c - a * a) / (2 * b * c));
        triangle.beta = acos((a * a + c * c - b * b) / (2 * a * c));
        triangle.gamma = PI - (triangle.alpha + triangle.beta);

        return triangle;


    }

    public static Triangle byTwoSidesAndAngle(double a, double b, double gamma) {

        gamma = abs(gamma);
        Triangle triangle = new Triangle();

        if(gamma == 0 || gamma >= PI) {
            System.out.println("Wrond data! Created the default triangle");
            return triangle;
        }

        triangle.a = a;
        triangle.b = b;
        triangle.gamma = gamma;

        triangle.c = sqrt(a * a + b * b - 2 * a * b * cos(gamma));
        triangle.alpha = acos((b * b + triangle.c * triangle.c - a * a) / (2 * b * triangle.c));
        triangle.beta = PI - gamma - triangle.alpha;

        return triangle;
    }

    public static Triangle bySideAndTwoAngles(double a, double beta, double gamma) {

        Triangle triangle = new Triangle();

        if(beta + gamma >= PI) {
            System.out.println("Wrond data! Created the default triangle");
            return triangle;
        }

        triangle.a = a;
        triangle.beta = beta;
        triangle.gamma = gamma;

        triangle.alpha = PI - beta - gamma;
        triangle.b = a * sin(beta) / sin(triangle.alpha);
        triangle.c = a * sin(gamma) / sin(triangle.alpha);

        return triangle;
    }

    public double getSquare() {
        return a * b * sin(gamma) / 2;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    //The 3 methods below return distance between a top (with the relevant angle) and the centroid
    public double fromAlpha() {
        return sqrt(2 * b * b + 2 * c * c - a * a) / 3;
    }

    public double fromBeta() {
        return sqrt(2 * a * a + 2 * c * c - a * a) / 3;
    }

    public double fromGamma() {
        return sqrt(2 * a * a + 2 * b * b - c * c) / 3;
    }

    public static void main(String[] args) {
        Triangle triangle = bySideAndTwoAngles(4, 2, 2);
        System.out.println("Side a = " + triangle.a);
        System.out.println("Angle gamma = " + triangle.gamma);
        System.out.println("Square = " + triangle.getSquare());
        System.out.println("Perimeter = " + triangle.getPerimeter());
        System.out.println("Distance from top with angle beta to centroid is " + triangle.fromBeta());
    }
}

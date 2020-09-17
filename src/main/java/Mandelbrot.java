import java.util.Scanner;

public class Mandelbrot {
    private static final int LIMIT = 255;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        int canvasWidth = Integer.parseInt(scanner.nextLine());
        int canvasHeight = Integer.parseInt(scanner.nextLine());

        double stepX = width / n;
        double stepY = height / n;

        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(x, x + width);
        StdDraw.setYscale(y, y + height);

        for (int i = 0; i < n; i++) {
            double xCoordinate = x + stepX * i;

            for (int j = 0; j < n; j++) {
                double yCoordinate = y + stepY * j;

                int result = mandelbrot(xCoordinate, yCoordinate);
                int color = 255 - result;

                StdDraw.setPenRadius(0.002);
                StdDraw.setPenColor(color, color, color);
                StdDraw.point(xCoordinate, yCoordinate);
            }
        }
    }

    private static int mandelbrot(double x, double y) {
        double r = x;
        double s = y;

        for (int i = 0; i <= LIMIT; i++) {
            if (r * r + s * s > 4) {
                return i;
            }

            double newR = r * r - s * s + x;
            double newS = 2 * r * s + y;

            r = newR;
            s = newS;
        }

        return LIMIT;
    }
}

package CS05;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Line line = new Line();
        view.requestInputCoordinate();
        List<Coordinate> coordinates = View.getCoordinate(view.requestInput());
        view.printBorad(coordinates);
        view.printDistacne(line.getResult(coordinates));

        Triangle triangle = new Triangle();
        view.printDistacne(triangle.getResult(coordinates));

        Square square = new Square();
        view.printDistacne(square.getResult(coordinates));


    }
}

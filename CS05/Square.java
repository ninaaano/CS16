package CS05;

import java.util.List;

/**
 * 사각형 클래스
 */
public class Square {

    double getArea(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        Line line = new Line();
        double width = line.getDistance(a, b);
        double height = line.getDistance(b, c);
        return width * height;
    }

    public double getValue(List<Coordinate> coordinates) {
        return getArea(coordinates.get(0), coordinates.get(1), coordinates.get(2), coordinates.get(3));
    }

    public String getResult(List<Coordinate> coordinates) {
        double value = getValue(coordinates);
        return "사각형 넓이는 " + value;
    }
}











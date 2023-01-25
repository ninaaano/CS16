package CS05;

import java.util.List;

/**
 * 삼각형 클래스
 */

public class Triangle {

    double getArea(Coordinate X, Coordinate Y, Coordinate Z) {
        Line line = new Line();
        double line1 = line.getDistance(X,Y);
        double line2 = line.getDistance(Y,Z);
        double line3 = line.getDistance(Z,X);
        double S = (line1+line2+line3)/2;
        return Double.parseDouble(String.format("%.1f", Math.sqrt(S * (S-line1) * (S-line2) * (S-line3))));
    }

    public double getValue(List<Coordinate> coordinates) {
        return getArea(coordinates.get(0), coordinates.get(1), coordinates.get(2));
    }

    public String getResult(List<Coordinate> coordinates) {
        double value = getValue(coordinates);
        return "삼각형의 넓이는 " + value;
    }


}





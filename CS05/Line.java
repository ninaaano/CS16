package CS05;

import java.util.List;

/**
 * 직선 클래스
 */
public class Line {

     double getDistance(Coordinate X, Coordinate Y){
        double distance = Math.sqrt(Math.pow(X.getX() - Y.getX(), 2) + Math.pow(X.getY() - Y.getY(), 2));
        return Double.parseDouble(String.format("%.6f" , distance));
    }

    public double getValue(List<Coordinate> coordinates){
         return getDistance(coordinates.get(0),coordinates.get(1));
    }

    public String getResult(List<Coordinate> coordinates){
         double value = getValue(coordinates);
         return "두 점 사이의 거리는 " + value;
    }



}

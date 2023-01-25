package CS05;

import java.util.Objects;

public class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            isRange(x,y);
            this.x = x;
            this.y = y;
        }

        // 범위 내에 있는지 확인
        private void isRange(int x, int y) {
            if (x > 24 || y > 24) {
                throw new IllegalArgumentException("[ERROR] 좌표는 최대 24까지만 입력할 수 있습니다");
            }
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

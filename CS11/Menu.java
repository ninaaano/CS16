package CS11;

import java.util.Arrays;

public enum Menu {
    아메리카노(1,3), 라떼(2,5), 프라푸치노(3,10);

    private static final Menu[] menus = Menu.values();
    private int menuNumber;
    private int time;

    Menu(int menuNumber, int time) {
        this.menuNumber = menuNumber;
        this.time = time;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public int getTime() {
        return time;
    }

    public static Menu of(int menuNumber) {
        return Arrays.stream(values())
                .filter(m -> m.menuNumber == menuNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("다시 골라라"));
    }

}

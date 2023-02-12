package CS11;

/**
 * 아메리카노 3, 라떼 5, 프라푸치노 10이였나?
 */
public class Coffee implements Comparable<Coffee>{

    // 변하는 현상을 저장하는
    private final String name;
    private final int coffeeNumber;
    private final int totalCount;
    private int count;

    public Coffee(int coffeeNumber) {
        Menu menu = Menu.of(coffeeNumber);

        this.name = menu.toString();
        this.coffeeNumber = coffeeNumber;
        this.totalCount = menu.getTime();
        this.count = 0;
    }

    public boolean brewing(){
        count++;
        if(count >= totalCount){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCoffeeNumber() {
        return coffeeNumber;
    }

    @Override
    public int compareTo(Coffee o) {
        return this.coffeeNumber - o.coffeeNumber;
    }
}

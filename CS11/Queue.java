package CS11;

import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 주문 대기
 */
public class Queue{
    private final PriorityQueue<Coffee> order;

    public Queue() {
        this.order = new PriorityQueue<>();
    }

    public void addQueue(int coffee){
        order.offer(new Coffee(coffee));
    }

    public Coffee getOrder() {
        return order.poll();
    }

    public boolean isOrderQuantity(){ // 큐 사이즈 확인하기
        return order.isEmpty();
    }

    public void printOrderQueue(){
        String collect = order.stream()
                .map(c -> String.valueOf(c.getCoffeeNumber()))
                .collect(Collectors.joining(",","/","/"));

        System.out.println(collect);
    }
}

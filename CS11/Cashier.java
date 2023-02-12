package CS11;

/**
 * 주문받아라
 */
public class Cashier {

    private final Queue queue;

    public Cashier(Queue queue) {
        this.queue = queue;
    }

    public void takeOrder(String order){
        int menu = Integer.parseInt(order.split(":")[0]);
        int count = Integer.parseInt(order.split(":")[1]);

        for(int i=0; i<count; i++){
            queue.addQueue(menu);
        }
    }

    // 1:3 queue -> 1 1 1


}

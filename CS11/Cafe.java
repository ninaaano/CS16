package CS11;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class Cafe {
    private final Queue orderQueue = new Queue();
    private final Barista barista = new Barista();
    private final Manager manager = new Manager(orderQueue, barista);
    private final Cashier cashier = new Cashier(orderQueue);
    private final Input input = new Input();



    public Cafe() {
    }

    public void run() {

        CompletableFuture.runAsync(()-> {
            while(true){
                try {
                    requestManageOrder();
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture.runAsync(()-> {
            while(true){
                try {
                    workingBari();
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        printMenu();

        while(true){
            try {
                requestOrder();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printMenu(){
        Input.printMenu();
    }

    public void requestOrder() throws IOException { // 넘겨준다는 메소드명으로 수정
        String order = input.userInput();
        cashier.takeOrder(order);
        orderQueue.printOrderQueue();
    }

    public void requestManageOrder(){
        manager.requestOrder();
    }

    public void workingBari(){
        barista.endMakeCoffee();
    }
}

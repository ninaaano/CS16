package CS11;

/**
 * 주문대기표(Queue)를 1초마다 확인
 * 주문이 있을 경우 사용가능한 바리한테 이벤트 전달
 * 바리가 보낸 완료 이벤트를 받으면 결과 출력
 */
public class Manager {
    private final Queue order;
    private final Barista barista;

    public Manager(Queue order, Barista barista) {
        this.order = order;
        this.barista = barista;
    }

//    void orderCheck(){
//        CompletableFuture.runAsync(()->{
//                try{
//                    Thread.sleep(1000);
//                }catch (InterruptedException e){
//                    throw new RuntimeException(e);
//                }
//            });
//    }

//    public Menu requestOrder(){
//        Menu pick = order.getOrder(); // 바리스타한테 보내야함.
//        return pick;
//    }

    public void requestOrder(){
        if(barista.isMakeCoffee() && !order.isOrderQuantity()){
            barista.startMakeCoffee(order.getOrder());
            order.printOrderQueue();
        }
    }

}

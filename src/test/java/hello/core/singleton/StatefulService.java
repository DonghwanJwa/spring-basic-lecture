package hello.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드

//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price); //10000 -> 20000
//        this.price = price; //여기가 문제
//    }
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price; //여기가 문제
    }

//    public int getPrice() {
//        return price;
//    }
}

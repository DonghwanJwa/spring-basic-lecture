package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //class level unique

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        //private -> new 로 생성 불가
    }

    public void logic() {
        System.out.println("싱클톤 객체 로직 호출");
    }
}

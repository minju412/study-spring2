package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() { // 외부에서 new 키워드로 객체 인스턴스를 생성할 수 없도록 private 선언
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

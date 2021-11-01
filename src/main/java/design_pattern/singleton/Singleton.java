package design_pattern.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }

    // Serialize에 대한 방어 코드, 내부에서 해당 코드를 사용한다
    // protected Object readResolve() {
    //    return getInstance();
    // }
}
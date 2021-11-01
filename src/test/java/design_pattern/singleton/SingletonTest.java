package design_pattern.singleton;

import org.junit.jupiter.api.Test;
import sun.reflect.Reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void equals() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        assertThat(singleton1 == singleton2).isTrue();
    }

    @Test
    void reflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton instance = Singleton.getInstance();

        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton singleton = declaredConstructor.newInstance();

        assertThat(instance == singleton).isFalse();
    }

    @Test
    void serialize() throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();
        Singleton singleton = null;

        // 직렬화 (클래스 -> 파일)
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.obj"))) {
            out.writeObject(instance);
        }

        // 역직렬화 (파일 -> 클래스)
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.obj"))) {
            singleton = (Singleton) in.readObject();
        }

        assertThat(instance == singleton).isFalse();
    }
}
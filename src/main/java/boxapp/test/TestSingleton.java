package boxapp.test;

public class TestSingleton {

    private String name;
    private static TestSingleton instance;

    private TestSingleton() {
    }

    private TestSingleton(String f) {
        this.name = f;
    }

    public synchronized static TestSingleton getInstance(String t) {
        if (instance == null)
            instance = new TestSingleton(t);
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

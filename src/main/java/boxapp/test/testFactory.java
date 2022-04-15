package boxapp.test;

public class testFactory implements testInterface {

public testFactory(){};

    public testFactory(String s, String s1) {
    }

    @Override
    public String pp(String a, String b) {
        return a+b;
    }
}

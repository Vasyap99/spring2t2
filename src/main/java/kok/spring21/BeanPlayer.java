package kok.spring21;

public class BeanPlayer {
    public Ibean getB() {
        return b;
    }

    private Ibean b;

    public BeanPlayer(Ibean b) {
        this.b = b;
    }
    void playBean(){
        System.out.println("Playing: "+b.getName());
    }
}

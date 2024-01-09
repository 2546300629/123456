package cn.com.offcn.day04;

public class Player {
    private String name;
    private int local;

    public Player(String name, int local) {
        this.name = name;
        this.local = local;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", local=" + local +
                '}';
    }
}

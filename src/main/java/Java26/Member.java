package Java26;

public class Member {

    private int id;
    private String name;
    private int activeLoans;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.activeLoans = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }

    public boolean canBorrow() {
        return activeLoans < 3;
    }
}
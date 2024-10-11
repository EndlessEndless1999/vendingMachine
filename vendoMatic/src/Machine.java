public class Machine {

    private Float money;
    private User currentUser;

    public Machine(Float _money, User _currentUser) {
        money = _money;
        currentUser = _currentUser;
    }

    public String getGreeting() {
        return "Hello, the machine is on!";
    }

    public Float getMoney() {
        return money;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

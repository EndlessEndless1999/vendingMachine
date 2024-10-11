public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Customer user = new Customer();

        Machine machine = new Machine(7.50F, user);

        System.out.println(machine.getGreeting());
        System.out.println(machine.getCurrentUser());
        System.out.println(machine.getMoney());



    }
}

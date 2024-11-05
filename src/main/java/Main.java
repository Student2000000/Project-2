public class Main {
public static void main (String[] args) {
    System.out.println("Hello world");


    NameHold nameHold = new NameHold(1000, 10000, 5);

    System.out.println("Set 1000 size for testing purposes: " + nameHold.getNames1000().size());
    System.out.println("Set 10,000 size for testing also: " + nameHold.getNames10000().size());
}
}

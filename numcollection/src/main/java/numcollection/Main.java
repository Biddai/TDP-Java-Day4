package numcollection;

public class Main {
    public static void main(String[] args) {
        String input = "2-4, 5, 7-9";
        IO.println("Creating a new NumCollection with range: " + input);
        NumCollection numbers = new NumCollection(input);

        System.out.println("Contains 0: " + numbers.contains(0));
        System.out.println("Contains 4: " + numbers.contains(4));

        System.out.println("Numbers in order:");
        for (int number : numbers) {
            System.out.println(number);
        }

        // A large span is stored as ranges, without a large array.
        String largerRange = "1-3, 1000000-1000002";
        IO.println("Creating a new NumCollection with a larger range: " + largerRange);
        NumCollection largeNumbers = new NumCollection(largerRange);
        System.out.println("Contains 1000001: " + largeNumbers.contains(1000001));
        System.out.println("Contains 500000: " + largeNumbers.contains(500000));
    }
}

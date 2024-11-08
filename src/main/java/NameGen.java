import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Generates two disjointed lists of size 1000, and 10,000
 * for use in experiment
 */
public class NameGen {
    private static final String CharForUse = "abcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();

    /**
     * Generares random "names" with specified length
     * @param length   The length of the names
     * @return   The random names
     */
    public static String generateRandomNames(int length) {
        StringBuilder names = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            names.append(CharForUse.charAt(RANDOM.nextInt(CharForUse.length())));
        }
        return names.toString();
    }

    /**
     * Creates a set of "names"
     * @param amt   How many unique names to be generated
     * @param lengthOfName   used to make a name of spcefied length
     * @return   The new set of names
     */
    public static Set<String> nameSetCreate (int amt, int lengthOfName) {
        Set<String> name = new HashSet<>();
        while (name.size() < amt) {
            String newNames = generateRandomNames(lengthOfName);
            name.add(newNames);
        }
        return name;
    }

}

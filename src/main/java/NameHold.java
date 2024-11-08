import java.util.Set;

/**
 * This class takes the data from NameGen and holds it for later use
 */

public class NameHold {
    private Set<String> names1000;
    private Set<String> names10000;

    /**
     * Constuctor
     * @param amt1   amount of names to be genorated
     * @param amt2   amount of names to be genorated
     * @param lengthOfName   length of the specific name
     */
    public NameHold(int amt1, int amt2, int lengthOfName) {
        this.names1000 = NameGen.nameSetCreate(amt1, lengthOfName);
        this.names10000 = NameGen.nameSetCreate(amt2, lengthOfName);
    }

    /**
     * Contrcutor
     * @return   the 1000 name populated list
     */
    public Set<String> getNames1000() {
        return names1000;
    }

    /**
     * Contuctor
     * @return   the 10,000 name populated list
     */
    public Set<String> getNames10000() {
        return names10000;
    }
}

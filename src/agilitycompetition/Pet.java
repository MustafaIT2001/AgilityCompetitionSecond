package agilitycompetition;

public class Pet extends Dog {
    private final String name;
    private final String owner;


    /**
     * Parameterized Constructor for the Dog class.
     *
     * @param dob    the dog’s date of birth (Date)
     * @param breed  the dog’s breed
     * @param weight the dog’s weight
     */

    public Pet(Date dob, String breed, double weight,
               String name, String owner) {
        super(dob, breed, weight); // call Dog’s constructor
        this.name = name;
        this.owner = owner;
    }


    public String getName() {
        return name;
    }

    /**
     * Accessor for the owner attribute
     *
     * @return the value of owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * toString allows an object to be directly printed by returning a String
     * that can be printed to the console or to a file. This one is
     * written in the input file format.
     *
     * @return a formatted string representing the values of the attributes for
     * a dog object.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // end of line for this OS
        str.append(super.toString());
        str.append(String.format(" %-15s%-12s", name, owner));

        return str.toString();

    }

    /**
     * compareTo (abstract method of the Comparable Interface) is implemented
     * to impose a natural ordering on a group of objects. compareTo is used
     * by the Collections.sort routine to allow us to sort the competitors
     * belonging to some Java collection. Conditions are checked in
     * decreasing importance and as soon as a criteria fits we are
     * finished looking at the comparison.
     *
     * @param that is the Dog object we are comparing this one to
     * @return a negative integer, zero, or a positive integer if this object
     * comes before, is equal to, or comes after the specified object.
     */
    @Override
    public int compareTo(Object that) {
        int comparison = 0;
        // shouldn't be any null objects, but if there are
        // put them after this one
        if (that == null) {
            comparison = 1;
            // if the addresses are the same... they are equal
        } else if (this == that) {
            comparison = 0;
        } else { // compare elapsed times
            comparison = this.birthDate.compareTo(((Dog) that).getBirthDate());
        }
        return comparison;
    }

    /**
     * Unit Test for the dog class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // tests Dog class only. to run, right-click
        // and choose Run File
        Date date1 = new Date(7, 26, 2006);
        Date date2 = new Date(10, 17, 2017);

        Pet dog1 = new Pet(date1, "Toy Poodle", 10.2, "Eudora",
                "Anne");
        Pet dog2 = new Pet(date2, "Bulldog", 20.4, "Bubba",
                "Jesse");
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println("testing compareTo() ");
        System.out.println("dog1.compareTo(dog2) " + dog1.compareTo(dog1));
        System.out.println("dog1.compareTo(dog1) " + dog1.compareTo(dog1));
        System.out.println("dog2.compareTo(dog1) " + dog2.compareTo(dog1));
    }


}

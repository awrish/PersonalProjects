package cs1302.p2;

import cs1302.adt.StringList;

/**
 * Base abstract class for which helps the other two files with methods.
 *
 */
public abstract class BaseStringList implements StringList {

    protected int size;

    /**
     * Constructor for class.
     *
     */
    BaseStringList() {
        size = 0;
    } //constructor

    /**
     * Overrides appends method from StringList.
     *
     */
    @Override
    public boolean append(String plus) {
        if (plus == null) {
            throw new NullPointerException("String is null!");
        } else if (plus.length() == 0) {
            throw new IllegalArgumentException("String is empty!");
        } else {
            add(size(),plus);  //used to be size()
            return true;
        } //else
    } //append

        /**
        try{
            //comment out
               for (int i = 0; i <= size(); i++) {
               if (i == size()) {
               add(plus);
               }
               } //for
            //comment out
            add(size(),plus);
            return true;
        } catch (NullPointerException npe) {
            System.err.println();
            System.err.println("item is null " + npe.getMessage());
            return false;
        } catch (IllegalArgumentException iae) {
            System.err.println();
            System.err.println("item is empty " + iae.getMessage());
            return false; //just a placeholder for now CHANGE LATER
        } //try-catch

    } //append
*/

    /**
     * Overrides isEmpty method from StringList.
     *
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) { //was size()
            return true;
        } else {
            return false;
        }

    } //isEmpty

    /**
     * Returns size of the list.
     *
     * <p>
     * {{@inheritDoc}
     */
    @Override
    public int size() {
        // return size(); //was size
        return size;
        /**
        int i = 0;
        //maybe do a whole formulo like below
        if (get(i) != null) {
            size++;
            i++;
        }
        return size;
        */
    }

    /**
     *
     *
     */
//    @Override

    /**
     * Helper method used to test if IdexOutofBoundException is thrown.
     * @param list inputted list
     *
     */
    public static void testAddNegative(StringList list) {
        System.out.print("testAddNegative: ");
        try {
            list.add(-5, "hello");
            System.out.println("FAIL: expected IOOB; however, no exception was encountered");
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println("PASS: expected IOOB; IOOB was encountered");
        } catch (Throwable e) {
            System.out.println("FAIL: expected IOOB, but got " + e);
        } // try
    } // testAddNegative

    //append empty tsize


    /**
     * Makes a string.
     * {@inheritDoc}
     *
     */
    @Override
    public String makeString(String start, String sep, String end) {
//        throw new UnsupportedOperationException("not yet implemented");
        String result = start;
        for (int i = 0; i < size(); i++) {
            result += get(i);
            if (i < size() - 1) {
                result += sep;
            } //if
        } //for
        result += end;
        return result;
    } //makeString


    /**
     * Adds to beginning.
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
//        throw new UnsupportedOperationException("not yet implemented");
        if (item == null) {
            throw new NullPointerException("Item is null!");
        } else if (item.length() == 0) {
            throw new IllegalArgumentException("Item is empty!");
        } else {
            add(0,item);
            return true;
        } //else
    } //prepend
        /**
        try{
            if (item != null) {
                add(0,item);
                return true; //maybe add this inside of an if statement to make sure it worked
            }
        } catch (NullPointerException npe) {
            System.err.println();
            System.err.println("item is null " + npe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.err.println();
            System.err.println("item is empty " + iae.getMessage());
        } //try-catch
        return true; //maybe add if statement to check
    } //prepend
        */

    /**
     * Converts to a string.
     * {@inheritDoc}
     *
     */
    @Override
    public String toString() {
//        throw new UnsupportedOperationException("not yet implemented");
        return makeString("[", ", ", "]"); //something like this
    } //toString






} //main

package cs1302.p2;

import cs1302.adt.StringList;


/**
 *  Class that creates a string array object that can be used with
 *  StringList. It extends BaseStringList.
 * {@inheritDoc}
 */
public class ArrayStringList extends BaseStringList {

    private String[] items;

    /**
     * The default constructor.
     *
     */
    public ArrayStringList() {
        items = new String[30];
        for (int i = 0; i < items.length; i++) {
            items[i] = " ";
        }
    } //constructor

    /**
     * Adds a string to inputted index.
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("item is null!");
        } else if (item.length() == 0) {
            throw new IllegalArgumentException("Item is empty!");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index is out of range!");
        } else {
            String [] rep = new String[items.length + 5];
            for (int i = 0; i < index; i++) {
                rep[i] = items[i];
            }
            rep[index] = item;

            for (int i = index + 1; i < items.length; i++) {
                rep[i] = items[i - 1];
            }
            items = rep;

        }
        size++;
        return true;


    } //add



/**
 * Clears array list.
 * {@inheritDoc}
 */
    @Override
    public void clear() {
        size = 0;
    } //clear

/**
 * Gets what is in array at index.
 * {@inheritDoc}
 */
    @Override
    public String get(int index) {
        String result = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        } else {
            return items[index];
        } //else
    } //get

/**
 * Removes item at index.
 * {@inheritDoc}
*/
    @Override
    public String remove(int index) {
        String [] replace = new String[items.length - 1];
        String castAway = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        } else {
            castAway = items[index];
            for (int i = index; i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
        } //else
        size--;
        return castAway;
    } //remove

/**
 * Slices it.
 * {@inheritDoc}
 */
    @Override
    public StringList slice(int start, int stop) {
        StringList sliced = new ArrayStringList();
        String[] temp = new String[items.length];
        //size = 0;
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value!");
        } else {
            size = 0;
            int index = 0;
            for (int i = start; i < stop; i++) {
                sliced.add(index,items[i]);
                index++;
            }
        }
        return sliced;
    } //slice

} //main

package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.Node;

/**
 * Methods for constructing a linked list of {@code Node} objects.
 *
 */
public class LinkedStringList extends BaseStringList {

    private Node head;

    /**
     * Default constructor of LinkedStringList.
     *
     */
    public LinkedStringList() {
        head = null;
    }

    /**
     * Adds a new item to list.
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item.length() == 0) {
            throw new IllegalArgumentException("Item is empty!");
        } else if (item == null) {
            throw new NullPointerException("Item is null!");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        } else {
            int count = 0;
            Node replacement = new Node(item, null);
            Node temp = head;
            if (head == null) {
                head = new Node(item,null);
            } else if (index == 0) {
                Node stand = head;
                head = replacement;
                head.setNext(stand);
            } else {
                for (int i = 0; i < size(); i++) {
                    if (i == index - 1) {
                        replacement.setNext(temp.getNext());
                        temp.setNext(replacement);
                    } //if
                    temp = temp.getNext();
                } //for
                //else
            }
        }
        size++;
        return true;
    } //add

    /**
     * Clears node list, sets head to null.
     * {@inheritDoc}
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns string in node at index.
     * {@inheritDoc}
     */
    public String get(int index) {
        Node seek = head;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        } else {
            for (int i = 0; i < index; i++) {
                seek = seek.getNext();
            } //for
        } //else
        return seek.getItem();
    } //get

    /**
     * Removes string item in node at index.
     * {@inheritDoc}
     */
    public String remove(int index) {
        Node temp = head;
        String removed = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        } else {
            if (index == 0) {
                removed += head.getItem();
                head = head.getNext();
            } else if (index == size()) {
                for (int i = 0; i <= size() - 1; i++) {
                    temp = temp.getNext();
                }
                removed += temp.getNext().getItem();
                temp.setNext(null);
            } else {
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                } //for
                removed += temp.getNext().getItem();
                temp.setNext(temp.getNext().getNext());
            }
            size--;
        } //else
        return removed;
    } //remove

    /**
     * Returns new StringList from start to stop.
     * {@inheritDoc}
     */
    public StringList slice(int start, int stop) {
        StringList sliced = new LinkedStringList();
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("illegal endpoint index value!");
        } else {
            Node temp = head;
            int count = 0;
            size = 0;
            for (int i = 0; i < start; i++) {
                temp = temp.getNext();
            }
            for (int i = 0; i < stop - start; i++) {
                size++;
                sliced.add(i,temp.getItem());
                temp = temp.getNext();
            }
        }

        return sliced;
    } //slice
} //main

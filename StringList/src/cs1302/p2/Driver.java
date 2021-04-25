package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.oracle.OracleStringList;

/**
 * Used to test and debug the Array and Linked StringList classes.
 *
 */
public class Driver {
    public static void main(String[] args) {
        StringList sl;

        StringList s3 = new ArrayStringList();
        StringList nodes = new LinkedStringList();
        StringList test = new OracleStringList();

//        System.out.println(test.size());
//        System.out.println(test.add(0,"Hi"));
//        System.out.println(test.toString());


//        System.out.println(nodes.isEmpty());
        nodes.add(0,"Hello");
//        System.out.println(nodes.isEmpty() + " should be false");
        nodes.add(1,"World");//
        nodes.add(2,"Lorem");
//        nodes.remove(0);
//        nodes.add(0,"Die");
//        nodes.add(1,"a");
        System.out.println(nodes.size());
        nodes.add(2,"Hello World");
        System.out.println(nodes.get(2));
//        nodes.add(1,"Hie");
//        System.out.println("List size " + nodes.size());
        System.out.println(nodes.toString());
//        System.out.println(nodes.get(1));
//        nodes.add(2,null);
//        nodes.slice(0,1).toString();
//
        //      s3.add(0,"a");

//        s3.add(0,"b");
//        s3.add(100,"c");
//        System.out.println(s3.toString());

//        s3.add(1,"b");
//        s3.add(0,"a");
        // s3.add(2,"c");
        //      s3.add(3,"d");
//         s3.toString();

        // System.out.println(s3.slice(0, 4).get(0-3));


        // sl = new OracleStringList(); // uncomment to run the test cases using the oracle.

        // Test isEmpty on an empty list

        if (s3.isEmpty()) {
            System.out.println("isEmpty: Test Passed");
        } else {
            System.out.println("isEmpty: Test Failed");
            System.exit(0);
        } // if



        // more calls to test methods down here...
    } // main

} // Driver

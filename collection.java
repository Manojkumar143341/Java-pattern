// Java program to change Collection to an array

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;

// Or simply add all generic lava libraries
import java.util.*;

public class GFG {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating arrayList list dynamically
        List<String> list = new ArrayList<String>();
        // List is created

        // Adding elements to the list
        list.add("Geeks ");
        list.add("for ");
        list.add("Geeks ");
        list.add("is ");
        list.add("the ");
        list.add("Best.");

        // Converting list to an array
        String[] str = list.toArray(new String[0]);

        // Iterating over elements of array
        for (int i = 0; i < str.length; i++) {
            String data = str[i];

            // Printing elements of an array
            System.out.print(data);
        }
    }
}

// Java program to Reverse String
// Using ByteArray
import java.io.*;

class Main {
  
    public static void main(String[] args) {
      
        String s = "Geeks";

        // getBytes() method to convert string
        // into bytes[].
        byte[] arr = s.getBytes();

        byte[] res = new byte[arr.length];

        // Store reult in reverse order into the
        // res byte[]
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[arr.length - i - 1];

        System.out.println(new String(res));
    }
}

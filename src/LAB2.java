/**
 * Created by daimon on 09/03/2017.
 */

import java.util.*;

class LAB2
{
    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        int c, first, last, middle, n, search;

        int array[] = {1,3,6,55,84,3434};
        Scanner in = new Scanner(System.in);

        System.out.println("Enter value to find");
        search = in.nextInt();

        first  = 0;
        last   = array.length;
        middle = (first + last)/2;

        while( first <= last )
        {
            if ( array[middle] < search )
                first = middle + 1;
            else if ( array[middle] == search )
            {
                System.out.println(search + " found at location " + (middle + 1) + ".");
                break;
            }
            else
                last = middle - 1;

            middle = (first + last)/2;
        }
        if ( first > last )
            System.out.println(search + " is not present in the list.\n");

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println(totalTime);
    }
}
/**
 * Created by y7usuf on 27/02/2017.
 */

import java.util.*;
import java.util.ArrayList;

interface WordBag {
    public void add(String word);

    public void show();
}


class LAB1 implements WordBag {

    ArrayList<String> list = new ArrayList<String>();

    LAB1() {
    }

    public void add(String word) {
        list.add(word);
    }

    public void show() {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    public static void main(String[] args) {
        LAB1 inter = new LAB1();
        Scanner input = new Scanner(System.in);
        int z = 0;
        while (z != -1) {
            String tempStr = input.nextLine();
            if (tempStr.equals("-1")) {
                z = -1;
                break;
            }
            inter.add(tempStr);
        }
        inter.show();
    }
}

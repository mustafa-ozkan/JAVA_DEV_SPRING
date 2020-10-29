package assignments;

import java.util.LinkedList;

public class Assignment_003 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("ali");
        linkedList.add("veli");
        linkedList.add("cem");
        String temp="";

        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.add(2*linkedList.size()-i,linkedList.get(i));
        }
    }
}

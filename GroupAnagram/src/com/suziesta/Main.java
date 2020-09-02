package com.suziesta;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> words=new ArrayList<String>();

        words.add("Rat");
        words.add("Car");
        words.add("Below");
        words.add("Tast");
        words.add("Cried");
        words.add("Study");
        words.add("Thing");
        words.add("Chin");
        words.add("Grab");
        words.add("Act");
        words.add("Robed");
        words.add("Vase");
        words.add("Glean");
        words.add("Desserts");
        words.add("Tar");
        words.add("Arc");
        words.add("Elbow");
        words.add("State");
        words.add("Cider");
        words.add("Dusty");
        words.add("Night");
        words.add("Inch");
        words.add("Brag");
        words.add("Cat");
        words.add("Bored");
        words.add("Save");
        words.add("Angel");
        words.add("Streseed");
        groupAnagrams(words);
    }

    static void groupAnagrams(List<String> words) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word: words){

            char[] arr = word.toLowerCase().toCharArray();
            Arrays.sort(arr);
            String s= new String(arr);

            if(! map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(word);

        }

        for(String s :map.keySet()){
            List<String> list = map.get(s);
            System.out.println("for key: "+s);
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}

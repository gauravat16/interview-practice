package leetcode.string;


import java.util.*;

public class Toys {


    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {
        Map<String, Integer> map = new HashMap<>();

        for(String toy : toys){
            map.put(toy.toLowerCase(), 0);
        }

        for(String phrase : quotes){
            for(String word : phrase.split(" ")){
                if(map.containsKey(word.toLowerCase())){
                    map.put(word.toLowerCase(), map.get(word.toLowerCase())+1);
                }
            }
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.count - a.count);


        for (Map.Entry<String, Integer> e : map.entrySet()){
            q.offer(new Pair(e.getKey(), e.getValue()));
        }

        ArrayList<String> res = new ArrayList<>();

        while (topToys != 0){
            res.add(q.poll().word);
            topToys--;
        }
        return res;
    }

    class Pair{
        String word;
        int count;

        public Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

}

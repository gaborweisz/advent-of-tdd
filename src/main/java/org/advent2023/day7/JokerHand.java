package org.advent2023.day7;

import java.util.HashMap;
import java.util.Map;

public class JokerHand implements Comparable<JokerHand> {

    String hand;
    int bid;
    int strength;

    static Map<Character, Integer> strengthMap = new HashMap<>();

    {
        strengthMap.put('A', 14);
        strengthMap.put('K', 13);
        strengthMap.put('Q', 12);
        strengthMap.put('T', 10);
        strengthMap.put('9', 9);
        strengthMap.put('8', 8);
        strengthMap.put('7', 7);
        strengthMap.put('6', 6);
        strengthMap.put('5', 5);
        strengthMap.put('4', 4);
        strengthMap.put('3', 3);
        strengthMap.put('2', 2);
        strengthMap.put('J', 1);
    }


    public JokerHand(String hand, int bid) {
        this.hand = hand;
        this.bid = bid;
        this.strength = strength();
    }

    /**
     * Applies the joker to the hand
     */
    public String applyJoker(String hand) {
        Map<Character, Integer> map = getHandStrengthMap(hand);

        if (!map.keySet().contains('J')) {
            return hand;
        }

        char largestOrStrongest = getLargestOrStrongest(map);

        if (map.values().size() == 1) {
            //JJJJJ -> AAAAA
            return hand.replace('J', 'A');
        } else if (map.values().size() == 2 && map.values().contains(4)) {
            //JJJJA -> AAAAA
            //AAAAJ -> AAAAA
            return hand.replace('J', largestOrStrongest);
        } else if (map.values().size() == 2 && map.values().contains(3)) {
            //JJJAA -> AAAAA
            //AAAJJ -> AAAAA
            return hand.replace('J', largestOrStrongest);
        } else if (map.values().size() == 3 && map.values().contains(3)) {
            //AAAKJ -> AAAKA
            //JJJKQ -> KKKKQ
            return hand.replace('J', largestOrStrongest);
        } else if (map.values().size() == 3 && map.values().contains(2) && map.values().contains(1)) {
            if (map.get('J') == 2) {
                //JJKKQ - > KKKKQ
                return hand.replace('J', largestOrStrongest);
            } else {
                //AAKKJ - > AAKKA
                return hand.replace('J', getStrongerPair(map));
            }
        } else if (map.values().size() == 4 && map.values().contains(2)) {
            //AAQTJ -> AAQTA
            //JJQTA -> AAQTA
            return hand.replace('J', largestOrStrongest);
        } else {
            //high card (AKQTJ - > AKQTA)
            return hand.replace('J', largestOrStrongest);
        }
    }

    /**
     * Calculates the strength of the hand
     *
     * @return
     */
    int strength() {

        String hand = applyJoker(this.hand);
        Map<Character, Integer> map = getHandStrengthMap(hand);

        if (map.values().size() == 1) {
            //five of a kind (AAAAA)
            return 7;
        } else if (map.values().size() == 2 && map.values().contains(4)) {
            //four of a kind (AAAAB)
            return 6;
        } else if (map.values().size() == 2 && map.values().contains(3)) {
            //full house (AAABB)
            return 5;
        } else if (map.values().size() == 3 && map.values().contains(3)) {
            //three of a kind  (AAABC)
            return 4;
        } else if (map.values().size() == 3 && map.values().contains(2) && map.values().contains(1)) {
            //two pair  (AABBC)
            return 3;
        } else if (map.values().size() == 4 && map.values().contains(2)) {
            //one pair (AABCD)
            return 2;
        } else {
            //high card (ABCDE)
            return 1;
        }
    }

    private Map<Character, Integer> getHandStrengthMap(String hand) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, (map.get(c) + 1));
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public Character getLargestOrStrongest(Map<Character, Integer> map) {
        Character largest = '0';
        Character strongest = '0';
        int value = 0;
        int strength = 0;
        for (Character c : map.keySet()) {
            if (c == 'J') {
                continue;
            }
            if (map.get(c) > value) {
                largest = c;
                value = map.get(c);
            }
            if (strengthMap.get(c) > strength) {
                strongest = c;
                strength = strengthMap.get(c);
            }
        }


        return value > 1 ? largest : strongest;
    }

    public Character getStrongerPair(Map<Character, Integer> map) {

        Character strongest = '0';
        int strength = 0;
        for (Character c : map.keySet()) {
            if (c == 'J') {
                continue;
            }
            if (strengthMap.get(c) > strength) {
                strongest = c;
                strength = strengthMap.get(c);
            }
        }

        return strongest;
    }


    public int compareCards(String hand1, String hand2) {
        for (int i = 0; i < 5; i++) {
            if (strengthMap.get(hand1.charAt(i)) > strengthMap.get(hand2.charAt(i))) {
                return 1;
            } else if (strengthMap.get(hand1.charAt(i)) < strengthMap.get(hand2.charAt(i))) {
                return -1;
            }
        }

        return 0;
    }


    @Override
    public int compareTo(JokerHand o) {
        if (this.strength == o.strength) {
            return compareCards(this.hand, o.hand);
        } else {
            return this.strength - o.strength > 0 ? 1 : -1;
        }
    }
}

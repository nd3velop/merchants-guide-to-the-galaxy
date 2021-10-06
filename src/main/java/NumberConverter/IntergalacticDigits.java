package NumberConverter;

import java.util.HashMap;

public class IntergalacticDigits {
    private HashMap<Character, String> romanToIntergalactic = new HashMap<>();
    private HashMap<String, Character> intergalacticToRoman = new HashMap<>();

    public void put(Character romanValue, String intergalacticValue) {
        this.romanToIntergalactic.putIfAbsent(romanValue, intergalacticValue);
        this.intergalacticToRoman.putIfAbsent(intergalacticValue, romanValue);
    }

    public boolean hasIntergalactic(String intergalacticValue) {
        return intergalacticToRoman.containsKey(intergalacticValue);
    }

    public Character getRoman(String intergalacticValue) {
        return intergalacticToRoman.get(intergalacticValue);
    }

    public String getIntergalactic(Character romanValue) {
        return romanToIntergalactic.get(romanValue);
    }
}

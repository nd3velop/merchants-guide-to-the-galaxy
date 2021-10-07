package NumberConverter;

import java.util.HashMap;

public class IntergalacticDigits {
    private HashMap<Character, String> romanToIntergalactic = new HashMap<>();
    private HashMap<String, Character> intergalacticToRoman = new HashMap<>();

    public void put(Character romanValue, String intergalacticValue) {
        this.romanToIntergalactic.putIfAbsent(Character.toLowerCase(romanValue), intergalacticValue.toLowerCase());
        this.intergalacticToRoman.putIfAbsent(intergalacticValue.toLowerCase(), Character.toLowerCase(romanValue));
    }

    public boolean hasIntergalactic(String intergalacticValue) {
        return intergalacticToRoman.containsKey(intergalacticValue);
    }

    public Character getRoman(String intergalacticValue) {
        return intergalacticToRoman.get(intergalacticValue.toLowerCase());
    }

    public String getIntergalactic(Character romanValue) {
        return romanToIntergalactic.get(Character.toLowerCase(romanValue));
    }
}

package NumberConverter;

import java.util.HashMap;

public class IntergalacticDigits {
    private HashMap<Character, String> romanToIntergalactic = new HashMap<>();
    private HashMap<String, Character> intergalacticToRoman = new HashMap<>();

    public void put(Character romanValue, String intergalacticValue) {
        this.romanToIntergalactic.put(romanValue, intergalacticValue);
        this.intergalacticToRoman.put(intergalacticValue, romanValue);
    }

    public Character getRoman(String intergalacticValue) {
        return intergalacticToRoman.get(intergalacticValue);
    }

    public String getIntergalactic(Character romanValue) {
        return romanToIntergalactic.get(romanValue);
    }
}

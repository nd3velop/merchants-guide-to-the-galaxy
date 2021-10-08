package NumberConverter;

import java.util.HashMap;

public class IntergalacticDigits {
    private HashMap<Character, String> romanToIntergalactic = new HashMap<>();
    private HashMap<String, Character> intergalacticToRoman = new HashMap<>();

    /**
     * Adds an intergalactic/roman key value pair
     * @param romanValue roman digit like I, V, X, L, C, D or M
     * @param intergalacticValue String that represents the corresponding intergalactic digit
     */
    public void put(Character romanValue, String intergalacticValue) {
        this.romanToIntergalactic.put(Character.toLowerCase(romanValue), intergalacticValue.toLowerCase());
        this.intergalacticToRoman.put(intergalacticValue.toLowerCase(), Character.toLowerCase(romanValue));
    }

    /**
     * Checks if the intergalactic digit already exists
     * @param intergalacticValue intergalactic digit
     * @return true if the intergalactic digit already exists
     */
    public boolean hasIntergalactic(String intergalacticValue) {
        return intergalacticToRoman.containsKey(intergalacticValue);
    }

    /**
     * Returns a corresponding roman digit for an intergalactic digit
     * @param intergalacticValue intergalactic digit
     * @return corresponding roman digit
     */
    public Character getRoman(String intergalacticValue) {
        return intergalacticToRoman.get(intergalacticValue.toLowerCase());
    }

    /**
     * Returns a corresponding intergalactic digit for an roman digit
     * @param romanValue roman digit
     * @return corresponding intergalactic digit
     */
    public String getIntergalactic(Character romanValue) {
        return romanToIntergalactic.get(Character.toLowerCase(romanValue));
    }

    /**
     * Checks if an intergalactic digit for the roman digit already exists
     * @param romanValue roman digit
     * @return true if the roman digit already has a mapping to an intergalactic digit
     */
    public boolean hasRoman(Character romanValue) {
        return romanToIntergalactic.containsKey(romanValue);
    }
}

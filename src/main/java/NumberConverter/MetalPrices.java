package NumberConverter;

import java.util.HashMap;
import java.util.Locale;

public class MetalPrices {
    private HashMap<Double, String> creditsToMetal = new HashMap<>();
    private HashMap<String, Double> metalToCredits = new HashMap<>();

    /**
     * Adds an price/metal key value pair
     * @param credits   price of the metal
     * @param metal     name of the metal
     */
    public void put(Double credits, String metal) {
        this.creditsToMetal.put(credits, metal.toLowerCase());
        this.metalToCredits.put(metal.toLowerCase(), credits);
    }

    /**
     * Returns the price of a metal
     * @param metal name of the metal
     * @return price of the metal
     */
    public double getCredits(String metal) {
        return metalToCredits.get(metal.toLowerCase());
    }

    /**
     * Returns the metal that has the given price
     * @param credits price of a metal
     * @return name of the metal
     */
    public String getMetal(Double credits) {
        return creditsToMetal.get(credits);
    }

    /**
     * Checks weather the metal already exists
     * @param metal name of the metal
     * @return true if the metal already exists
     */
    public boolean hasMetal(String metal){
        return metalToCredits.containsKey(metal);
    }
}

package NumberConverter;

import java.util.HashMap;
import java.util.Locale;

public class MetalPrices {
    private HashMap<Double, String> creditsToMetal = new HashMap<>();
    private HashMap<String, Double> metalToCredits = new HashMap<>();

    public void put(Double credits, String metal) {
        this.creditsToMetal.put(credits, metal.toLowerCase());
        this.metalToCredits.put(metal.toLowerCase(), credits);
    }
    public double getCredits(String metal) {
        return metalToCredits.get(metal.toLowerCase());
    }

    public String getMetal(Double credits) {
        return creditsToMetal.get(credits);
    }

    public boolean hasMetal(String metal){
        return metalToCredits.containsKey(metal);
    }
}

package NumberConverter;

public class MetalToCreditsConverter implements INumberConverter<String, Double> {
    private MetalPrices metalPrices;

    public MetalToCreditsConverter(MetalPrices metalPrices){
        this.metalPrices = metalPrices;
    }

    /**
     * Returns the price of a metal
     * @param value name of the metal
     * @return metal price
     */
    @Override
    public Double convert(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException(value + " is not a valid intergalactic metal!");

        return metalPrices.getCredits(value);
    }

    /**
     * Checks if the passed String is defined in metalPrices
     * @param value name of the metal
     * @return true if the metal exists
     */
    @Override
    public boolean isValid(String value) {
        return metalPrices.hasMetal(value.toLowerCase());
    }

}

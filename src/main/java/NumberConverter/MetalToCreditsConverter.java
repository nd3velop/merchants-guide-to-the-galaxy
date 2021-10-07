package NumberConverter;

public class MetalToCreditsConverter implements INumberConverter<String, Double> {
    private MetalPrices metalPrices;

    public MetalToCreditsConverter(MetalPrices metalPrices){
        this.metalPrices = metalPrices;
    }

    @Override
    public Double convert(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException(value + "is not a valid intergalactic metal!");

        return metalPrices.getCredits(value);
    }

    @Override
    public boolean isValid(String value) {
        return metalPrices.hasMetal(value.toLowerCase());
    }

}

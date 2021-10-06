package NumberConverter;

public interface INumberConverter<From, To> {
    To convert(From value);
    boolean isValid(From value);
}

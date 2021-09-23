package NumberConverter;

public interface INumberConverter<From, To> {
    To convert(From value);
}

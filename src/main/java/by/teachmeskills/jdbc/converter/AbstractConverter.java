package by.teachmeskills.jdbc.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<S, T> implements IConverter<S, T>  {

    @Override
    public List<T> convertAll(List<S> s) {
        List<T> result = new ArrayList<>();
        for (S s1 : s) {
            final T convert = convert(s1);
            result.add(convert);
        }
        return result;
    }
}

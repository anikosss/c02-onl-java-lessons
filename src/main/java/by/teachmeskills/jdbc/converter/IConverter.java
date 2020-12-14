package by.teachmeskills.jdbc.converter;

import java.util.List;

public interface IConverter<S, T> {

    T convert(S s);
    List<T> convertAll(List<S> s);

}

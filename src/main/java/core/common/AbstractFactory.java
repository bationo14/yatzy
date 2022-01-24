package core.common;

import core.constant.Category;

public interface AbstractFactory<T> {
    T create(Category category) ;
}

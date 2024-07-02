package factory;

import model.AbstractEntity;
import model.Person;

public interface Creator {
    void create(AbstractEntity abstractEntity);
}

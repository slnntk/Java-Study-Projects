package service;

import factory.Creator;
import factory.CreatorFactory;
import model.AbstractEntity;

public class ModelService {
    public AbstractEntity createModel(AbstractEntity abstractEntity) {
        Creator creator = CreatorFactory.returnCreator(getObjectClassName(abstractEntity));
        creator.create(abstractEntity);
        return abstractEntity;
    }

    public String getObjectClassName(Object object) {
        return object.getClass().getSimpleName();
    }
}

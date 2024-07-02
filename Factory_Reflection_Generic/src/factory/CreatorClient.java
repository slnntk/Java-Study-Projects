package factory;

import model.AbstractEntity;
import model.Client;

public class CreatorClient implements Creator {
    @Override
    public void create(AbstractEntity abstractEntity) {
        Client client = (Client) abstractEntity;
        System.out.println(abstractEntity.toString());
    }
}

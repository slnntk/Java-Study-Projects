package factory;

import model.AbstractEntity;
import model.Employee;
import model.Person;

public class CreatorEmployee implements Creator {
    @Override
    public void create(AbstractEntity abstractEntity) {
        Employee employee = (Employee) abstractEntity;
        System.out.println(employee.toString());
    }
}

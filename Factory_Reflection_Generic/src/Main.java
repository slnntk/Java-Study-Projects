import model.Client;
import model.Employee;
import service.ModelService;

public class Main{
    public static void main(String[] args) {
        ModelService modelService = new ModelService();
        Client client = new Client("1", "John", "Doe", "123");
        Employee employee = new Employee("2", "Jane", "Doe", "456");
        modelService.createModel(client);
        modelService.createModel(employee);
    }
}
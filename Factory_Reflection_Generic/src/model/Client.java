package model;

public class Client extends Person {
    private String code;

    public Client(String id, String name, String lastName, String code) {
        super(id, name, lastName);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code='" + code + '\'' +
                '}';
    }
}

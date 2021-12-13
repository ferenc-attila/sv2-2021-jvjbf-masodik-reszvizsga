package filemanipulation;

public class Human {

    private String name;
    private String identityNumber;

    public Human(String name, String identityNumber) {
        this.name = name;
        this.identityNumber = identityNumber;
    }

    @Override
    public String toString() {
        return name + ";" + identityNumber;
    }

    public String getName() {
        return name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }
}

package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> fileContent = Files.readAllLines(path);
            addToHumans(fileContent);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void addToHumans(List<String> fileContent) {
        for (String row : fileContent) {
            String[] data = row.split(";");
            humans.add(new Human(data[0], data[1]));
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> output = createListOfMales();
        try {
            Files.write(path, output);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<String> createListOfMales() {
        List<String> output = new ArrayList<>();
        for (Human actual : humans) {
            if (isMale(actual)) {
                output.add(actual.toString());
            }
        }
        return output;
    }

    private boolean isMale(Human actual) {
        return Integer.parseInt(actual.getIdentityNumber().substring(0, 1)) % 2 == 1;
    }
}

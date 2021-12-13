package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    List<Building> buildings = new ArrayList<>();
    private String name;
    private long fullArea;

    public City(String name, long area) {
        this.name = name;
        this.fullArea = area;
    }

    public void addBuilding(Building building) {
        checkFullArea(building);
        buildings.add(building);
    }

    private void checkFullArea(Building building) {
        int sum = building.getArea();
        for (Building actual : buildings) {
            sum += actual.getArea();
        }
        if (sum > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    public Building findHighestBuilding() {
        Building highestBuilding = buildings.get(0);
        for (Building actual : buildings) {
            if (actual.getLevels() > highestBuilding.getLevels()) {
                highestBuilding = actual;
            }
        }
        return highestBuilding;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> buildingsInTheStreet = new ArrayList<>();
        for (Building actual : buildings) {
            if (street.equals(actual.getAddress().getStreet())) {
                buildingsInTheStreet.add(actual);
            }
        }
        return buildingsInTheStreet;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building actual : buildings) {
            if (actual.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}

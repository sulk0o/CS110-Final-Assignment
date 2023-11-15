import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ClimateZone {
    private ArrayList<City> cityList = new ArrayList<City>();

    public ClimateZone() {
        cityList = new ArrayList<City>();
    }

    public ClimateZone(String fN) throws IOException {
        cityList = new ArrayList<City>();
        FileInputStream ds = new FileInputStream(fN);
        Scanner sDS = new Scanner(ds);

        while (sDS.hasNext()) {
            String name = sDS.next();
            String state = sDS.next();
            double highTemp = sDS.nextDouble();
            double lowTemp = sDS.nextDouble();

            // Create a new Player object and add it to the playerList
            City city = new City(name, state, highTemp, lowTemp);
            cityList.add(city);
        }
    }

    public void addCity(String n, String s, double hT, double lT) {
        City c = new City(n, s, hT, lT);
        cityList.add(c);
    }

    public int getCityCount() {
        return cityList.size();
    }

    public City getCityByName(String n, String s) {
        for (City city : cityList) {
            if (city.getName().equals(n) && city.getState().equals(s)) {
                return city;
            }
        }
        return null;
    }

    public void printHottestCities() {
        City hotCity1 = null;
        City hotCity2 = null;

        for (City city : cityList) {
            if (hotCity1 == null || city.getHighTemp() > hotCity1.getHighTemp()) {
                // Move the first top player to second place if a new top player is found
                hotCity2 = hotCity1;
                hotCity1 = city;
            } else if (hotCity2 == null || city.getHighTemp() > hotCity2.getHighTemp()) {
                hotCity2 = city;
            }
        }

        // Print info of the top attackers if they exist
        if (hotCity1 != null) {
            hotCity1.printInfo();
            if (hotCity2 != null) {
                hotCity2.printInfo();
            }
        }
    }

    public void printColdestCities() {
        City coldCity1 = null;
        City coldCity2 = null;

        for (City city : cityList) {
            if (coldCity1 == null || city.getLowTemp() < coldCity1.getLowTemp()) {
                // Move the first top blocker to second place if a new top blocker is found
                coldCity2 = coldCity1;
                coldCity1 = city;
            } else if (coldCity2 == null || city.getLowTemp() < coldCity2.getLowTemp()) {
                coldCity2 = city;
            }
        }

        // Print info of the top blockers if they exist
        if (coldCity1 != null) {
            coldCity1.printInfo();
            if (coldCity2 != null) {
                coldCity2.printInfo();
            }
        }
    }

    public void printAllCities() {
        for (City city : cityList) {
            city.printInfo();
        }
    }
}
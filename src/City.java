class City {
    private String name;
    private String state;
    private double highTemp;
    private double lowTemp;

    public City(String c, String s, double hT, double lT) {
        name = c;
        state = s;
        highTemp = hT;
        lowTemp = lT;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public double getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(double hT) {
        highTemp = hT;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(double lT) {
        lowTemp = lT;
    }

    public void printInfo() {
        System.out.print(name + ", " + state + " (High = ");
        System.out.printf("%.2f", highTemp);
        System.out.printf(", Low = %.2f", lowTemp);
        System.out.println(")");
    }
}
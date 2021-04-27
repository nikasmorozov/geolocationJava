package lt.niko;

import java.text.DecimalFormat;
import java.util.Random;

public class GeoLocation {
    Random random = new Random();
    DecimalFormat locationFormater = new DecimalFormat("#0.000000");

    private double lat;
    private double lon;
    static int numLocations = 1;

    GeoLocation() {
        this.setLat(randomInRange(-90, 90));
        this.setLon((randomInRange(-90, 90)));
        numLocations++;
    }

    GeoLocation(double lat, double lon) {
        this.setLat(lat);
        this.setLon(lon);
        numLocations++;
    }

    GeoLocation(GeoLocation geoLocationToCopy) {
        this.setLat(geoLocationToCopy.getLat() + randomInRange(-0.1, 0.1));
        this.setLon(geoLocationToCopy.getLon() + randomInRange(-0.1, 0.1));
    }


    private double randomInRange(double minValue, double maxValue) {
        return minValue + (maxValue - minValue) * random.nextDouble();

    }


    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public static int getNumLocations() {
        return numLocations;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void print() {
        System.out.println("[" + locationFormater.format(lat) + ", " + locationFormater.format(lon) + "]");
    }

    public static String distance(GeoLocation location1, GeoLocation location2) {
        double lat1 = location1.getLat();
        double lat2 = location2.getLat();

        double lon1 = location1.getLon();
        double lon2 = location2.getLon();

        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return String.format("%.1f", rad * c);


    }


}

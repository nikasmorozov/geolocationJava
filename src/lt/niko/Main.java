package lt.niko;

public class Main {

    public static void main(String[] args) {
        GeoLocation someLocation = new GeoLocation();
        GeoLocation vilnius = new GeoLocation(54.683333, 25.283333);
        GeoLocation kaunas = new GeoLocation(54.897222, 23.886111);
        GeoLocation hamilton = new GeoLocation(42.827014, -75.544624);
        GeoLocation nearVilnius = new GeoLocation(vilnius);

        someLocation.print();
        vilnius.print();
        nearVilnius.print();

        System.out.println("Number of locations: " + GeoLocation.getNumLocations());

        System.out.println("From Vilnius to Kaunas: " + GeoLocation.distance(vilnius, kaunas));
        System.out.println("From Vilnius to Hamilton: " + GeoLocation.distance(vilnius, hamilton));
        System.out.println("From Vilnius to random location: " + GeoLocation.distance(vilnius, someLocation));
        System.out.println("From Vilnius to random neighbour: " + GeoLocation.distance(vilnius, nearVilnius));

    }
}

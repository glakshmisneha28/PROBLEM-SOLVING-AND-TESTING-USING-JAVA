import java.util.*;

class UndergroundSystem {

    // Stores check-in info: id -> (station, time)
    private Map<Integer, CheckIn> checkInMap;

    // Stores route data: "start->end" -> (totalTime, count)
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String routeKey = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Route route = routeMap.getOrDefault(routeKey, new Route(0, 0));
        route.totalTime += travelTime;
        route.count += 1;

        routeMap.put(routeKey, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        Route route = routeMap.get(routeKey);

        return (double) route.totalTime / route.count;
    }

    // Helper class for check-in
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route stats
    class Route {
        int totalTime;
        int count;

        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}

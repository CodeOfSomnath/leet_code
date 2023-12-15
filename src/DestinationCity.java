import java.util.*;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * Example 2:
 * <p>
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 * Example 3:
 * <p>
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * All strings consist of lowercase and uppercase English letters and the space character.
 */
public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        String currentCity = paths.getFirst().getFirst();
        HashMap<String, String> mapToDestination = new HashMap<>();
        for (var cityList : paths) {
            mapToDestination.put(cityList.get(0), cityList.get(1));
        }

        while (mapToDestination.containsKey(currentCity)) {
            currentCity = mapToDestination.get(currentCity);
        }

        return currentCity;
    }

    public static void addValuesToList(List<List<String>> paths, String ... values) {
        List<String> cityList = new ArrayList<>(Arrays.asList(values));
        paths.add(cityList);
    }

    public static void main(String[] args) {
//        paths = [["B","C"],["D","B"],["C","A"]]
        List<List<String>> paths = new ArrayList<>();
        addValuesToList(paths, "B","C");
        addValuesToList(paths, "D","B");
        addValuesToList(paths, "C","A");
        var result = new DestinationCity().destCity(paths);
        System.out.println(result);
    }
}

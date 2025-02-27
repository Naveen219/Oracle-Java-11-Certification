package methodreferences;

import java.util.*;


class BicycleComparator implements Comparator<Bicycle> {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}

public class InstanceMethodParticularDemo {
    public static void main(String[] args) {
        BicycleComparator bikeFrameSizeComparator = new BicycleComparator();


        List<Bicycle> bicycleList = Arrays.asList(new Bicycle("Suzuki", 42),
                new Bicycle("Royal Enfield", 44),
                new Bicycle("Yamaha", 40),
                new Bicycle("TVS", 38));

        List<Bicycle> bicycleList1 = new ArrayList<>(bicycleList);
        Collections.sort(bicycleList1, bikeFrameSizeComparator);

        List<Bicycle> bicycleList2 = new ArrayList<>(bicycleList);

        // prints false
        System.out.println(bicycleList1.equals(bicycleList2));

        Collections.sort(bicycleList2, bikeFrameSizeComparator::compare);

        // prints true
        System.out.println(bicycleList1.equals(bicycleList2));
    }
}

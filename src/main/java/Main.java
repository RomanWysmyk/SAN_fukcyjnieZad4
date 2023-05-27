import java.util.*;

public class Main {

    public static <T> Set<Set<T>> powerSet(Collection<T> firstSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (firstSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(firstSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));

        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }

        return sets;
    }

    public static void main(String[] args) {

        List<Integer> testList = new ArrayList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);

        Set<Set<Integer>> finalSet = powerSet(testList);
        System.out.println("Wszystkie możliwe zbiory: "+finalSet);
        System.out.println("Ilość wszystkich zbiorów = "+finalSet.size());
    }
}
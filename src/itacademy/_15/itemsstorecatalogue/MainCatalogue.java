package itacademy._15.itemsstorecatalogue;

import com.sun.source.tree.Tree;

import java.util.*;

public class MainCatalogue {
    public static void main(String[] args) {
        getMenu(populateList());
    }

    private static void getMenu(Map<String, Item> itemList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            System.out.println("To sort item list, please press on keyboard:");
            System.out.println("\t0 - to quit" +
                    "\n\t1 - to sort by name in ascending order" +
                    "\n\t2 - to sort by name in reverse order" +
                    "\n\t3 - to sort by price in ascending order" +
                    "\n\t4 - to sort by price in descending order");
            int chose = scanner.nextInt();
            scanner.nextLine();

            switch(chose) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    TreeMap<String, Item> ascendingKeys = new TreeMap<>(itemList);
                    System.out.println("List sorted by name: " + ascendingKeys);
                    break;
                case 2:
                    TreeMap<String, Item> descendingKeys = new TreeMap<>(itemList);
                    System.out.println("List sorted by name descending:" + descendingKeys.descendingMap());
                    break;
                case 3:
                    System.out.println("List sorted by price:" + getSortedMapByValue(itemList, Order.ASCENDING));
                    break;
                case 4:
                    System.out.println("List sorted by price descending:" + getSortedMapByValue(itemList, Order.DESCENDING));
                    break;
            }
        }
    }

    private static LinkedHashMap<String, Item> getSortedMapByValue(Map<String, Item> mapToSort, Order sortingType) {
        List<Map.Entry<String, Item>> entryList = new ArrayList<>(mapToSort.entrySet());
        entryList.sort(new ItemByPriceComparator());
        if(sortingType == Order.DESCENDING) {
            Collections.reverse(entryList);
        }

        LinkedHashMap<String, Item> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Item> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private static Map<String, Item> populateList() {
        Map<String, Item> itemList = new HashMap<>();

        Item newItem = new Item("Pierogi", 2.4);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Herring", 4.5);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Flour", 1.25);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Pasta", 1.9);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Sausages", 1.3);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Salomon", 6.48);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Tuna", 8.2);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Frankfurters", 1.75);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Neapolitan sauce", 5.5);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Cheese", 3.69);
        itemList.put(newItem.getName(), newItem);

        return itemList;
    }
}

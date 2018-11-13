package com.amydegregorio.javabasics.maps;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Runner class for demonstrating TreeMap functionality.
 * 
 * @author AMD
 *
 */
public class TreeMapExample {

   public static void main(String[] args) {
      TreeMapExample ex = new TreeMapExample();
      ex.demoSimpleTreeMap();
      ex.demoComparatorTreeMap();
   }
   
   /**
    * Creates and exercises a TreeMap using the default constructor.
    */
   public void demoSimpleTreeMap() {
      TreeMap<Integer, String> exampleMap = new TreeMap<Integer, String>();
      System.out.println(String.format("Is the map empty? %b", exampleMap.isEmpty()));
      System.out.println(String.format("Starting Map Size: %d", exampleMap.size()));
      exampleMap.put(new Integer(1), "One");
      exampleMap.put(new Integer(5), "Five");
      exampleMap.put(new Integer(6), "Six");
      exampleMap.put(new Integer(11), "eleven");
      exampleMap.put(new Integer(20), "Twenty");
      System.out.println(String.format("Map Size: %d", exampleMap.size()));
      System.out.println();
      
      System.out.println("--Iterating using the Key Set");
      for (Iterator<Integer> it = exampleMap.keySet().iterator(); it.hasNext();) {
         Integer key = it.next();
         String value = exampleMap.get(key);
         System.out.println(String.format("   Key/Value Pair: %d = '%s'", key, value));
      }
      System.out.println();
      
      System.out.println("--Iterating in reverse order using the  Descending Key Set");
      for (Iterator<Integer> it = exampleMap.descendingKeySet().iterator(); it.hasNext();) {
         Integer key = it.next();
         String value = exampleMap.get(key);
         System.out.println(String.format("   Key/Value Pair: %d = '%s'", key, value));
      }
      System.out.println();
      
      Map.Entry<Integer, String> ceiling5 = exampleMap.ceilingEntry(new Integer(5));
      System.out.println(String.format("Ceiling entry for key %d: %d = %s", new Integer(5), ceiling5.getKey(), ceiling5.getValue()));
      
      Map.Entry<Integer, String> ceiling4 = exampleMap.ceilingEntry(new Integer(4));
      System.out.println(String.format("Ceiling entry for key %d: %d = %s", new Integer(4), ceiling4.getKey(), ceiling4.getValue()));
   }
   
   /**
    * Demonstrates creating a TreeMap with a custom Comparator.
    */
   public void demoComparatorTreeMap() {
      TreeMap<String, String> colorMap = new TreeMap<String, String>(new Comparator<String>() {

         @Override
         public int compare(String o1, String o2) {
            String lastTwo1 = o1.substring(o1.length() - 2);
            String lastTwo2 = o2.substring(o2.length() - 2);
            int compareLast2 = lastTwo1.compareToIgnoreCase(lastTwo2);
            if (compareLast2 == 0) {
               String middle2o1 = o1.substring(o1.length() - 4, o1.length() - 2);
               String middle2o2 = o2.substring(o2.length() - 4, o2.length() - 2);
               int compareMiddle2 = middle2o1.compareToIgnoreCase(middle2o2);
               if (compareMiddle2 == 0) {
                  String first2o1 = o1.substring(o1.length() - 6, o1.length() - 4);
                  String first2o2 = o2.substring(o2.length() - 6, o2.length() - 4);
                  return first2o1.compareToIgnoreCase(first2o2);
               } else {
                  return compareMiddle2;
               }
            } else {
               return compareLast2;
            }
         }
      });
         
      colorMap.putIfAbsent("#000000", "Black");
      colorMap.putIfAbsent("000000", "Black");
      colorMap.putIfAbsent("#FFFFFF", "White");
      colorMap.putIfAbsent("#FF0000", "Red");
      colorMap.putIfAbsent("#00FF00", "Lime");
      colorMap.putIfAbsent("#0000FF", "Blue");
      colorMap.putIfAbsent("#FFFF00", "Yellow");
      colorMap.putIfAbsent("#00FFFF", "Cyan");
      colorMap.putIfAbsent("#FF00FF", "Magenta");
      colorMap.putIfAbsent("#C0C0C0", "Silver");
      colorMap.putIfAbsent("#808080", "Gray");
      colorMap.putIfAbsent("#00FFFF", "Cyan");
      colorMap.putIfAbsent("#800000", "Maroon");
      colorMap.putIfAbsent("#808000", "Olive");
      colorMap.putIfAbsent("#008000", "Green");
      colorMap.putIfAbsent("#800080", "Purple");
      colorMap.putIfAbsent("#008080", "Teal");
      colorMap.putIfAbsent("#000080", "Navy");
      colorMap.putIfAbsent("#B22222", "Firebrick");
      colorMap.putIfAbsent("#8FBC8F", "Dark Sea Green");
      colorMap.putIfAbsent("#BA55D3", "Medium Orchid");
      colorMap.putIfAbsent("#FFEFD5", "Papaya Whip");
      colorMap.putIfAbsent("#E6E6FA", "Lavender");
      
      System.out.println("--Iterating using the Key Set");
      for (Iterator<String> it = colorMap.keySet().iterator(); it.hasNext();) {
         String key = it.next();
         String value = colorMap.get(key);
         System.out.println(String.format("   Key/Value Pair: %s = '%s'", key, value));
      }
      System.out.println();
   }
   
}

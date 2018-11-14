package com.amydegregorio.javabasics.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Main runner for a simple HashMap demonstration.
 * 
 * @author AMD
 *
 */
public class BasicMapExample {
   
   public static void main(String[] args) {
      BasicMapExample ex = new BasicMapExample();
      ex.demoHashMap();
   }
   
   /**
    * Creates and exercises a HashMap.
    */
   public void demoHashMap() {
      Map<Integer, String> exampleMap = new HashMap<Integer, String>();
      System.out.println(String.format("Is the map empty? %b", exampleMap.isEmpty()));
      System.out.println(String.format("Starting Map Size: %d", exampleMap.size()));
      exampleMap.put(new Integer(1), "One");
      exampleMap.put(new Integer(5), "Five");
      exampleMap.put(new Integer(6), "Six");
      exampleMap.put(new Integer(11), "eleven");
      exampleMap.put(new Integer(20), "Twenty");
      System.out.println(String.format("Map Size: %d", exampleMap.size()));
      System.out.println();
      
      boolean containsTwenty = exampleMap.containsKey(new Integer(20));
      System.out.println(String.format("Contains key '%d'? %b", new Integer(20), containsTwenty));
      System.out.println();
      
      boolean containsOne = exampleMap.containsValue("One");
      System.out.println(String.format("Contains value '%s'? %b", "One", containsOne));
      System.out.println();
      
      String eleven = exampleMap.get(new Integer(11));
      System.out.println(String.format("Value '%s' found at key %d.", eleven, new Integer(11)));
      exampleMap.replace(new Integer(11), "Eleven");
      eleven = exampleMap.get(new Integer(11));
      System.out.println(String.format("After replace, value '%s' found at key %d.", eleven, new Integer(11)));
      System.out.println();
      
      exampleMap.putIfAbsent(new Integer(7), "Seven");
      System.out.println(String.format("After 'putIfAbsent' key %d, Map Size: %d", new Integer(7), exampleMap.size()));
      exampleMap.putIfAbsent(new Integer(5), "five");
      System.out.println(String.format("After 'putIfAbsent' key %d, Map Size: %d", new Integer(5), exampleMap.size()));
      System.out.println();
      
      System.out.println("--Iterating using the Key Set");
      for (Iterator<Integer> it = exampleMap.keySet().iterator(); it.hasNext();) {
         Integer key = it.next();
         String value = exampleMap.get(key);
         System.out.println(String.format("   Key/Value Pair: %d = '%s'", key, value));
      }
      System.out.println();
      
      exampleMap.remove(new Integer(7));
      
      System.out.println("--Iterating using Map.Entry");
      for (Iterator<Map.Entry<Integer, String>> it = exampleMap.entrySet().iterator(); it.hasNext();) {
         Map.Entry<Integer, String> entry = it.next();
         System.out.println(String.format("   Key/Value Pair: %d = '%s'", entry.getKey(), entry.getValue()));
      }
      System.out.println();
      
      System.out.println("--Iterating using forEach with Lambdas");
      exampleMap.forEach((key, value) -> System.out.println(String.format("   Key/Value Pair: %d = '%s'", key, value)));
      System.out.println();
      
      System.out.println("--Iterating the values");
      for (Iterator<String> it = exampleMap.values().iterator(); it.hasNext();) {
         String value = it.next();
         System.out.println(String.format("   Value: %s", value));
      }
      System.out.println();
   }
}

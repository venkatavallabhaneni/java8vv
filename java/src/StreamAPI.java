
/**
 * A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

  public static void main(String args[]) {

    Predicate<Integer> even = number -> number % 2 == 0;

    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    List<Integer> filteredList = list.stream().filter(even).collect(Collectors.toList());

    System.out.println("filetered list ; " + filteredList);

    List<Integer> mapList = list.stream().map(a -> a + 10).collect(Collectors.toList());

    System.out.println("map list ; " + mapList);

    List<Integer> all = list.stream().filter(even).map(a -> a + 3).sorted().collect(Collectors.toList());

    System.out.println("All " + all);

    List<Integer> odd = list.stream().reduce(new ArrayList<Integer>(),
        (a, b) -> {
          if (b % 2 == 1)
            a.add(b);
          return a;
        },
        (a, b) -> {
          a.addAll(b);
          return a;
        });

    System.out.println(odd);



      System.out.println("-----------------Parallel stream ------------");

      List<Integer> parallelStreamList = list.stream().filter(even).parallel().collect(Collectors.toList());

      List<Integer> parallelStreamOther = list.parallelStream().filter(even).collect(Collectors.toList());

      System.out.println("Parallel process of stream "+ parallelStreamList);
      System.out.println("Parallel process of stream "+ parallelStreamOther);


      System.out.println("--------------MAp vs FlatMap----------------");

      List<List<Integer>> listofLists = new ArrayList<>(10);
      listofLists.add(parallelStreamList);
      listofLists.add(list);

      List<Integer> flatList = listofLists.stream().flatMap(listx->listx.stream()).collect(Collectors.toList());

      System.out.println(flatList);




  }





}

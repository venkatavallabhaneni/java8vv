import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesUsage {

    public static void main(String rags[]) {

        Consumer<List<Integer>> consumerList = list->list.stream().forEach(a->System.out.println(a));

        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);

        List<Integer> list = new ArrayList<>(10);
        list.add(1); list.add(2); list.add(3);

        consumerList.accept(list);

        Consumer<List<Integer>> modifyList = mlist-> {
      
            for (Integer index =0;index<mlist.size();index++) {
                
                mlist.set(index,mlist.get(0)*2);
            }
        };

        System.out.println("------------------Consumer and Then ----");
        Consumer<List<Integer>> displayList = dList-> dList.stream().forEach(anItem->System.out.println(anItem));


        List<Integer> materials = new ArrayList<>(10);
        materials.add(1);
        materials.add(2);

        modifyList.andThen(displayList).accept(materials);


        System.out.println("-----------------------------BI Consumer---------------");

        BiConsumer<List<Integer>,List<Integer>> displayb = (list1,list2)->{

            System.out.println(list1.size()==list2.size());
        };

        displayb.accept(list, materials);


        System.out.println("--------------------Predicate -------------");

        Predicate<Integer> predicate = element-> element<19;

        System.out.println(predicate.negate().test(29));
        System.out.println(predicate.test(29));


        System.out.println("---------------Supplier-----------------------");

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        


    }

}
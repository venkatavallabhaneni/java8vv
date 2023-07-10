import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaces {

    public static void main(String rags[]) {

        Consumer<List<Integer>> consumerList = list->list.stream().forEach(a->System.out.println(a));

        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);

        List<Integer> list = new ArrayList<>(10);
        list.add(1); list.add(2); list.add(3);

        consumerList.accept(list);

    }

}
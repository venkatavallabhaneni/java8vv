import java.util.ArrayList;
import java.util.List;

class LambdaExpressions {

    interface FunctionalInterfaceAnother {
        public Integer operate(int a, int b);
    }

    public static void main(String args[]) {

        FunctionalInterface aFunctionalInterface = (int aNumber) -> System.out
                .println("I am from functional Interface :" + aNumber);
        aFunctionalInterface.anAbstractFunction(200);

        List<Integer> aList = new ArrayList<Integer>();
        aList.add(200);
        aList.add(300);

        aList.forEach(aNumber -> System.out.println(aNumber));

        FunctionalInterfaceAnother add = (x, y) -> x + y;
        FunctionalInterfaceAnother multiply = (x, y) -> x * y;

        System.out.println("add: " + add.operate(2, 30) + " multiply:" + multiply.operate(45, 34));

        new Thread(() -> {
            System.out.println("Hello thread");
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                {
                    System.out.println("Without lambda , its an functional interface");
                }
            }

        }).start();

    }
}
/**
 * An interface that contains only one abstract method is known as a functional interface, 
 * but there is no restriction,
 *  you can have n number of default and static methods inside a functional interface
 * Functional Interface is additionally recognized as Single Abstract Method Interfaces.
 *  In short, they are also known as SAM interfaces
 */
public interface FunctionalInterface {

    public abstract void anAbstractFunction(int aNumber);

    public default void myDefaultMethod(){
        System.out.println("DEfault");
    }

    public  static void myStaticMethod(){
        System.out.println("I am a static method");
    }
    
}

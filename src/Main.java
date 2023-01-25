import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
}
    public static void main(String[] args) {

        //Task5
        Predicate<Object> condition = p -> 2 > 4;
        Function<Object, Integer> ifTrue = s -> 1;
        Function<Object, Integer> ifFalse = s -> 3;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply("123"));

        System.out.println("==================");
        //Task1
        int a = -17;
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (a < 0) {
                    return false;
                } else return true;
            }
        };
        System.out.println(predicate.test(a));



        Predicate<Integer> predicate1 = integer -> {
            if (a < 0) {
                return false;
            } else return true;
        };
        System.out.println(predicate.test(a));

        System.out.println("==================");
        //Task2
        String b = "Vova";
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String b) {
                System.out.println("Привет " + b);

            }
        };
        consumer.accept(b);


        Consumer<String> consumer1 = b1 -> System.out.println("Привет " + b1);
        consumer.accept(b);

        System.out.println("==================");
        //Task3
        double c = 10.5555555;

        Function<Double,Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(c);
            }
        };
        System.out.println(function.apply(c));



        Function<Double,Long> function1 = aDouble -> Math.round(c);
        System.out.println(function.apply(c));

        System.out.println("==================");
        //Task4

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(supplier.get());



        Supplier<Integer> supplier1 = () -> {
            Random random1 = new Random();
            return random1.nextInt(100);
        };

        System.out.println(supplier1.get());
    }
}
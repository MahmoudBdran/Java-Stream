import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> myNumbers = Arrays.asList(1,12,13,112,14,112,143,15,162,12);
        System.out.println("original : "+ myNumbers);
        streamFilter(myNumbers);
        streamMap(myNumbers);
        streamFilterMap(myNumbers);
        streamMapUppercase();
        streamFlatMap();
        streamDistinct(myNumbers);
        streamsSorted(myNumbers);
        streamsMinElement(myNumbers);
        streamsCountElements(myNumbers);
        streamsAnyMatch(myNumbers);
        streamsAllMatch(myNumbers);
        streamsNoneMatch(myNumbers);

    }

    public static void streamFilter(List<Integer> numbers){
        //filters even numbers in the original list
        List<Integer> evenNumbers = numbers.stream()
                .filter(n-> n%2==0)
                .collect(Collectors.toList());
        System.out.println("even numbers: "+evenNumbers);

    }
    public static void streamMap(List<Integer> numbers){
        //map numbers to be squared in the new list.
        List<Integer> squaredNumbers = numbers.stream()
                .map(number-> number * number)
                .collect(Collectors.toList());
        System.out.println("squared numbers: "+squaredNumbers);
    }
    public static void streamFilterMap(List<Integer> numbers){
        //filters even numbers then get them as an input to map then square them.
        List<Integer> squaredEvenNumbers = numbers.stream()
                .filter(n->n%2==0)
                .map(number ->number*number)
                .collect(Collectors.toList());
        System.out.println("even squared numbers: "+squaredEvenNumbers);

    }

    public static void streamMapUppercase( ){
        List<String> myStrings=Arrays.asList("ahmed","hussien");
        //map numbers to be squared in the new list.
     myStrings.stream()
                .map(s ->s.toUpperCase())
                .forEach(System.out::println);
    }

    public static void streamFlatMap(){
        //make nested streams in a single stream.
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList("Item 1", "Item 2")),
                new Order(Arrays.asList("Item 3")),
                new Order(Arrays.asList("Item 4", "Item 5", "Item 6"))
        );
        List<String> allOrders = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.toList());
        System.out.println("Flat Map stream "+allOrders);
    }
    public static void streamDistinct(List<Integer> numbers){
        //get distinct (a list without duplicated values)
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct numbers: "+distinctNumbers);

    }
    public static void streamsSorted(List<Integer> numbers){
        //sorting elements
        //ascending from lower to higher
        List<Integer> sortedAscending=numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("stream ascending sorted : "+sortedAscending);
        //descending from higher to lower
        List<Integer> sortedDescending=numbers.stream()
                .sorted((a,b)->b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println("stream descending sorted : "+sortedDescending);

    }

    public static void streamsMinElement(List<Integer> numbers){
        // get the minimum element
        //ascending from lower to higher
        Optional<Integer> MinElement=numbers.stream()
                .min(Integer::compareTo);
        System.out.println("stream min element : "+MinElement.get());
    }
    public static void streamsCountElements(List<Integer> numbers){
        //count stream elements
        System.out.println("stream min element : "
                +numbers.stream()
                .count());
    }

    public static void streamsAnyMatch(List<Integer> numbers){
        //check if there is any item match the condition or not
        System.out.println("stream any match > 7 : "+numbers.stream().anyMatch(number->number>7));
    }
    public static void streamsAllMatch(List<Integer> numbers){
        //check if there is all items match the condition or not
        System.out.println("stream all match > 7 : "+numbers.stream().allMatch(number->number>7));
    }
    public static void streamsNoneMatch(List<Integer> numbers){
        //check if there is no item match the condition or not
        System.out.println("stream none match = 7 : "+numbers.stream().noneMatch(number->number==7));
    }


}


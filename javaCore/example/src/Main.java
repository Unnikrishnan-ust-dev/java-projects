import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Like","Subscribe","","Javafreshers","\n\n");

        List<String> withoutBlanks = list.stream().filter(Predicate.not(String::isBlank)).map(String::toUpperCase).toList();
        System.out.println(withoutBlanks);
    }
}
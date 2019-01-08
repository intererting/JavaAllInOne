import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Java8 {

    private volatile AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            test.add(String.valueOf(i));
        }
        List<String> result = test.stream()
                .filter(s -> (Integer.parseInt(s) & 1) != 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }

}

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class PersonMain {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("Juan Cardona", false),
                                          new Person("Diego Gaviria", true),
                                          new Person("Diego Cardona", true),
                                          new Person("Amelia Muñoz", true),
                                          new Person("Juan Colorado", true));

        Comparator<Person> compareIsNice = (p1, p2) -> ((Boolean) p2.getIsNice()).compareTo((Boolean) p1.getIsNice());

        System.out.println("List: " + list);
        List<Person> newlist = list
            .stream()
            .sorted(compareIsNice.thenComparing((p1,p2) -> p1.getName().compareTo(p2.getName())))
            .collect(toList());
        System.out.println("List: " + newlist);
        System.out.println("" +Thread.currentThread());

    }
}

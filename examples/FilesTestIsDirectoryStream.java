import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class FilesTestIsDirectoryStream {

    public static void main(String[] args) {
        List<Path> paths = Arrays.asList(Paths.get(".."),
                                         Paths.get("FileTestIsDirectoryStream.java"),
                                         Paths.get("."),
                                         Paths.get("FileTestIsDirectoryStream.class"));

        System.out.println("paths: " + paths);
        Comparator<Path> cmp = (Comparator.comparing(Files::isDirectory)).reversed().thenComparing(Path::compareTo);
        List<Path> orderPaths = paths
            .stream()
            .sorted(cmp.reversed().thenComparing(Path::compareTo))
            .collect(toList());

        System.out.println("paths: " + orderPaths);
    }
}

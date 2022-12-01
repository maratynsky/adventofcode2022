import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class Day {

    protected abstract long resolve(Stream<String> input);

    public long resolve() {
        try {
            final var className = this.getClass().getSimpleName();
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(className + ".in")).toURI());
            return resolve(Files.lines(path));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}

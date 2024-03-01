import java.util.Optional;

public interface Check {
    public Optional<Error> lint();
}

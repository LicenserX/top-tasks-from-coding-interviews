import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable {
    private final List<Consumer<Object>> listeners = new ArrayList<>();

    public void addListener(Consumer<Object> listener) {
        listeners.add(listener);
    }

    public void executeListeners(Object obj) {
        for (Consumer<Object> listener : listeners) {
            try {
                listener.accept(obj);
            } catch (Exception e) {
                System.out.println("Fail");
            }
        }
    }

    public static void main(String[] args) {
//        assertEquals(System.in.read(), "Fail");
    }
}

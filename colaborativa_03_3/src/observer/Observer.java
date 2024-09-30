package observer;

import java.util.List;

public interface Observer {
    void update(int currentFloor, String status, List<Integer> queue);
}

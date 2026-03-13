package io.github.some_example_name;

import java.util.List;

public interface PathSearching {
    void computePaths(long start, long end);

    List<Long> getPath(long target);

    double getDistance(long target);
}

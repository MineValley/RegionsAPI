package minevalley.regions.api.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Direction {

    NORTH(180),
    EAST(-90),
    SOUTH(0),
    WEST(90);

    private final int yaw;
}

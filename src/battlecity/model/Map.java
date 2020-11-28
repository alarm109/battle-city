package battlecity.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    // Level 1
    private final HashMap<String, ArrayList<Coordinates>> levelOneBlocks = new HashMap<String, ArrayList<Coordinates>>() {{
        put("wall", new ArrayList<Coordinates>() {{
            add(new Coordinates(1, 1));
            add(new Coordinates(1, 2));
            add(new Coordinates(1, 6));
            add(new Coordinates(1, 8));
            add(new Coordinates(1, 9));
            add(new Coordinates(1, 10));
            add(new Coordinates(1, 11));
            add(new Coordinates(1, 12));
            add(new Coordinates(2, 6));
            add(new Coordinates(3, 3));
            add(new Coordinates(3, 4));
            add(new Coordinates(3, 6));
            add(new Coordinates(3, 9));
            add(new Coordinates(3, 10));
            add(new Coordinates(3, 12));
            add(new Coordinates(5, 5));
            add(new Coordinates(5, 7));
            add(new Coordinates(5, 8));
            add(new Coordinates(5, 9));
            add(new Coordinates(5, 10));
            add(new Coordinates(6, 2));
            add(new Coordinates(6, 9));
            add(new Coordinates(6, 10));
            add(new Coordinates(7, 1));
            add(new Coordinates(7, 2));
            add(new Coordinates(7, 7));
            add(new Coordinates(7, 8));
            add(new Coordinates(7, 9));
            add(new Coordinates(7, 10));
            add(new Coordinates(9, 1));
            add(new Coordinates(9, 2));
            add(new Coordinates(9, 4));
            add(new Coordinates(9, 7));
            add(new Coordinates(9, 9));
            add(new Coordinates(9, 11));
            add(new Coordinates(9, 12));
            add(new Coordinates(10, 12));
            add(new Coordinates(11, 1));
            add(new Coordinates(11, 2));
            add(new Coordinates(11, 4));
            add(new Coordinates(11, 6));
            add(new Coordinates(11, 7));
            add(new Coordinates(11, 8));
            add(new Coordinates(11, 9));
            add(new Coordinates(11, 11));
            add(new Coordinates(11, 12));
        }});
        put("bush", new ArrayList<Coordinates>() {{
            add(new Coordinates(0, 4));
            add(new Coordinates(0, 5));
            add(new Coordinates(1, 5));
            add(new Coordinates(4, 6));
            add(new Coordinates(4, 7));
            add(new Coordinates(5, 6));
            add(new Coordinates(6, 6));
            add(new Coordinates(10, 4));
            add(new Coordinates(10, 5));
            add(new Coordinates(10, 6));
        }});
        put("metalWall", new ArrayList<Coordinates>() {{
            add(new Coordinates(0, 8));
            add(new Coordinates(3, 0));
            add(new Coordinates(3, 1));
            add(new Coordinates(3, 7));
            add(new Coordinates(3, 8));
            add(new Coordinates(6, 4));
            add(new Coordinates(7, 0));
            add(new Coordinates(7, 6));
            add(new Coordinates(8, 5));
            add(new Coordinates(9, 3));
            add(new Coordinates(10, 2));
            add(new Coordinates(11, 9));
            add(new Coordinates(12, 4));
        }});
        put("player", new ArrayList<Coordinates>() {{
            add(new Coordinates(4, 12));
        }});
        put("enemy", new ArrayList<Coordinates>() {{
            add(new Coordinates(0, 0));
            add(new Coordinates(1, 0));
            add(new Coordinates(2, 0));
        }});
        put("bird", new ArrayList<Coordinates>() {{
            add(new Coordinates(6, 12));
        }});
    }};

    public Tank loadLevelOne(Pane root) {
        Tank player = new Tank(levelOneBlocks.get("player").get(0), "player");
        root.getChildren().add(player);
        levelOneBlocks.forEach((String type, ArrayList<Coordinates> coordinates) -> {
            if (!type.equals("player") && !type.equals("enemy")) {
                for (Coordinates c : coordinates) {
                    root.getChildren().add(new Block(c, type));
                }
            } else if (type.equals("enemy")) {
                for (Coordinates c : coordinates) {
                    Tank t = new Tank(c, type);
                    root.getChildren().add(t);
                }
            }
        });
        return player;
    }
}

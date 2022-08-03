package ADVANCED.EXAMS.Exam_10_22_Feb_2020.P3_Guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> toRemoveList = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                toRemoveList.add(player);
            }
        }
        roster.removeIf(p -> p.getClazz().equals(clazz));
        Player[] array = new Player[toRemoveList.size()];
        return toRemoveList.toArray(array);

    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:", name)).append(System.lineSeparator());
        for (Player player : roster) {
            builder.append(player.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}

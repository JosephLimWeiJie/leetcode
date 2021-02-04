import java.util.*;

class Solution {

    public static boolean isPathCrossing(String path) {
        char[] charArray = path.toCharArray();
        Set<Pair> map = new HashSet<>();
        map.add(new Pair(0, 0));
        int newX = 0;
        int newY = 0;

        for (int i = 0; i < charArray.length; i++) {
            char currDir = charArray[i];

            if (currDir == 'N') {
                newX = newX;
                newY += 1;
            } else if (currDir == 'S') {
                newX = newX;
                newY -= 1;
            } else if (currDir == 'E') {
                newX += 1;
                newY = newY;
            } else {
                newX -= 1;
                newY = newY;
            }

            Pair p = new Pair(newX, newY);
            if (map.contains(p)) {
                return true;
            }
            //System.out.println(newX + ", " + newY);
            map.add(new Pair(newX, newY));
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPathCrossing("NESWW"));
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Pair)) {
                return false;
            }

            Pair p = (Pair) obj;

            return (p.first == this.first) && (p.second == this.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.first, this.second);
        }

        @Override
        public String toString() {
            return "(" + this.first + "," + this.second + ")";
        }
    }
}


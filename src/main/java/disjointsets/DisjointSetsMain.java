package disjointsets;

public class DisjointSetsMain {
    public static void main(String[] args) {
        DisjointSets dsets = new DisjointSets();
        dsets.createSets(9);
        dsets.union(1, 6);
        dsets.union(2, 3);
        System.out.println(dsets);

        dsets.union(1, 2);
        System.out.println(dsets);

        dsets.union(4, 7);
        System.out.println(dsets);

        dsets.union(5, 8);
        System.out.println(dsets);

        dsets.union(4, 1);

        System.out.println(dsets);
        System.out.println(dsets.find(4));
    }
}

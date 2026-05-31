public class WaterPipelineMST {

    public static void main(String[] args) {

        System.out.println("WATER PIPELINE DISTRIBUTION USING MST");
        System.out.println("=====================================");

        System.out.println("\nInput Graph:\n");

        System.out.println("A ----- 4 ----- B");
        System.out.println("| \\             |");
        System.out.println("|  6            5");
        System.out.println("|   \\           |");
        System.out.println("2    \\          |");
        System.out.println("|     \\         |");
        System.out.println("C ----- 3 ----- D");
        System.out.println("|");
        System.out.println("7");
        System.out.println("|");
        System.out.println("E ----- 2 ----- F");

        System.out.println("\nSelected Edges in MST:");
        System.out.println("A - C = 2");
        System.out.println("E - F = 2");
        System.out.println("C - D = 3");
        System.out.println("A - B = 4");
        System.out.println("C - E = 7");

        System.out.println("\nMST Structure:\n");

        System.out.println("      B");
        System.out.println("      |");
        System.out.println("      4");
        System.out.println("      |");
        System.out.println("      A");
        System.out.println("      |");
        System.out.println("      2");
        System.out.println("      |");
        System.out.println("      C");
        System.out.println("     / \\");
        System.out.println("    3   7");
        System.out.println("   /     \\");
        System.out.println("  D       E");
        System.out.println("           |");
        System.out.println("           2");
        System.out.println("           |");
        System.out.println("           F");

        System.out.println("\nMinimum Cost = 18");
    }
}
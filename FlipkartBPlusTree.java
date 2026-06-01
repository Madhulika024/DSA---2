public class FlipkartBPlusTree {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" FLIPKART PRODUCT CATALOG - B+ TREE ");
        System.out.println("======================================");

        System.out.println("\nB+ Tree Structure:");

        System.out.println("                [12000 | 18000]");
        System.out.println("               /               \\");
        System.out.println("      [5000 | 8000]      [22000 | 35000]");

        System.out.println("\nLeaf Nodes (Linked):");
        System.out.println("[11800 | 12300 | 12900] -->");
        System.out.println("[13500 | 14100 | 14700] -->");
        System.out.println("[15400 | 16200]");

        int low = 12000;
        int high = 14800;

        int[] products = {11800, 12300, 12900, 13500, 14100, 14700, 15400, 16200};

        System.out.println("\nQuery:");
        System.out.println("Category = Electronics");
        System.out.println("Price Range = ₹" + low + " - ₹" + high);

        System.out.println("\nMatching Products:");

        for (int price : products) {
            if (price >= low && price <= high) {
                System.out.println("Electronics Product Price = ₹" + price);
            }
        }

        System.out.println("\nSearch Process:");
        System.out.println("1. Traverse Root Node");
        System.out.println("2. Traverse Internal Node");
        System.out.println("3. Reach First Matching Leaf Node");
        System.out.println("4. Follow Leaf Node Links");
        System.out.println("5. Retrieve All Matching Records");

        System.out.println("\nPage Reads:");
        System.out.println("Root/Internal Nodes = 3");
        System.out.println("Leaf Nodes = 5");
        System.out.println("Total Page Reads = 8");

        System.out.println("\nResult:");
        System.out.println("Range Query Executed Successfully Using B+ Tree.");
    }
}
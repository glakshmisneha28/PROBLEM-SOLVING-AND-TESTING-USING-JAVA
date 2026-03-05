import java.util.*;

class CategorySalesAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedHashMap<String, Long> total = new LinkedHashMap<>();
        HashMap<String, Long> max = new HashMap<>();
        HashMap<String, String> item = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            String category = sc.next();
            String name = sc.next();
            long amount = sc.nextLong();
            
            total.put(category, total.getOrDefault(category, 0L) + amount);
            
            if(!max.containsKey(category) || amount > max.get(category)) {
                max.put(category, amount);
                item.put(category, name);
            }
        }
        
        for(String c : total.keySet()) {
            System.out.println(c + " " + total.get(c) + " " + item.get(c));
        }
    }
}

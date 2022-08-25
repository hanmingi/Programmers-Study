import java.util.*;

public class Main_4358{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> trees = new HashMap<>();
        int count = 0;

        while(sc.hasNextLine()){
            String temp = sc.nextLine();

            // 종료
            if(temp == null || temp.length() == 0) break;

            trees.put(temp, trees.getOrDefault(temp, 0) + 1);
            count++;
        }

        List<String> treeName = new ArrayList<>(trees.keySet());
        treeName.sort((s1, s2) -> s1.compareTo(s2));

        for(String name : treeName){
            System.out.println(name + " " + String.format("%.4f", (float)trees.get(name) / count * 100));
        }
    }
}


/*
Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow
 */
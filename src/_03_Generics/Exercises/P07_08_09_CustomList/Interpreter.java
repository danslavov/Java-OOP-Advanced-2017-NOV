package _03_Generics.Exercises.P07_08_09_CustomList;

public class Interpreter {
    public static <T extends Comparable> void interpret(
            String[] params, CustomList list) {
        String command = params[0];
        switch (command) {
            case "Add":
                T element = (T) params[1];
                list.add(element);
                break;
            case "Remove":
                int index = Integer.parseInt(params[1]);
                list.remove(index);
                break;
            case "Contains":
                element = (T) params[1];
                System.out.println(list.contains(element));
                break;
            case "Swap":
                int from = Integer.parseInt(params[1]);
                int to = Integer.parseInt(params[2]);
                list.swap(from, to);
                break;
            case "Greater":
                element = (T) params[1];
                System.out.println(list.countGreaterThan(element));
                break;
            case "Max":
                System.out.println(list.getMax());
                break;
            case "Min":
                System.out.println(list.getMin());
                break;
            case "Sort":
                Sorter.sort(list);
                break;
            case "Print":
                System.out.print(list);
                break;
            default:
                break;
        }
    }
}

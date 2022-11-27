public class Main {

    public Main() {
    }

    public void run() {
        List firstList = new SortedList();
        List secondList = new SortedList();
        List mergedList = new SortedList();

        System.out.println("EXERCÍCIO 2:\nIntercalando elementos de duas listas encadeadas ordenadas");

        System.out.println("\n\nLista 1: Preenchimento\n");
        firstList.fill();

        System.out.println("\n\nLista 2: Preenchimento\n");
        secondList.fill();

        mergedList = mergedList.mergeLists(firstList, secondList);

        System.out.println("\n\nLista 3: Resultado da intercalação");
        mergedList.print();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
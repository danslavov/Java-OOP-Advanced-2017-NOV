package _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy;

import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.interfaces.AddCollection;
import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.interfaces.AddRemoveCollection;
import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.interfaces.MyList;
import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.models.AddCollectionImpl;
import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.models.AddRemoveCollectionImpl;
import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.models.MyListImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollectionImpl();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImpl();
        MyList myList = new MyListImpl();
        StringBuilder indexesOfAdded1 = new StringBuilder();
        StringBuilder indexesOfAdded2 = new StringBuilder();
        StringBuilder indexesOfAdded3 = new StringBuilder();
        StringBuilder removed1 = new StringBuilder();
        StringBuilder removed2 = new StringBuilder();
        String[] elementsToAdd = scanner.nextLine().split(" ");
        int removeCount = scanner.nextInt();

        for (int i = 0; i < elementsToAdd.length; i++) {

            if (i != 0) {
                indexesOfAdded1.append(" ");
                indexesOfAdded2.append(" ");
                indexesOfAdded3.append(" ");
            }

            String element = elementsToAdd[i];
            indexesOfAdded1.append(String.valueOf(addCollection.add(element)));
            indexesOfAdded2.append(String.valueOf(addRemoveCollection.add(element)));
            indexesOfAdded3.append(String.valueOf(myList.add(element)));
        }

        for (int i = 0; i < removeCount; i++) {

            if (i != 0) {
                removed1.append(" ");
                removed2.append(" ");
            }

            removed1.append(addRemoveCollection.remove());
            removed2.append(myList.remove());
        }

        System.out.printf("%s%n%s%n%s%n%s%n%s%n",
                indexesOfAdded1, indexesOfAdded2, indexesOfAdded3,
                removed1, removed2);
    }
}

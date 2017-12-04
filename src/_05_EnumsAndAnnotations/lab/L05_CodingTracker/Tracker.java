package _05_EnumsAndAnnotations.lab.L05_CodingTracker;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tracker {
    @Author(name = "Pesho")
    private static void printMethodsByAuthor(Class<?> cl) {
        Map<String, Set<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Author authorAnnotation = m.getAnnotation(Author.class);
            if (authorAnnotation != null) {
                if (!methodsByAuthor.containsKey(authorAnnotation.name())) {    // putIfAbsent()
                    methodsByAuthor.put(authorAnnotation.name(), new HashSet<>());
                }
                methodsByAuthor.get(authorAnnotation.name()).add(m.getName() + "()");
            }
        }

        for (Map.Entry<String, Set<String>> author : methodsByAuthor.entrySet()) {
            System.out.print(author.getKey() + ": ");
            System.out.println(author.getValue().toString()
                    .replace("[", "")
                    .replace("]", ""));
        }
    }

    @Author(name = "Gosho")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);
    }
}

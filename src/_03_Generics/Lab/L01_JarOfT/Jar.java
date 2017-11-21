package _03_Generics.Lab.L01_JarOfT;

import java.util.Stack;

public class Jar <T> {

    private Stack<T> container = new Stack<>();

    public void add(T element) {
        this.container.push(element);
    }

    public T remove() {
        return this.container.pop();
    }
}

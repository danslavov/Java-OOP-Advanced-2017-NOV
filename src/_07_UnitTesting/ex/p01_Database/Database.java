package _07_UnitTesting.ex.p01_Database;

import javax.naming.OperationNotSupportedException;

public class Database {
    private Integer[] structure;

    public Database(Integer... values) throws OperationNotSupportedException {
        this.structure = new Integer[16];
        this.addAll(values);
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }
        for (int i = 0; i < this.structure.length; i++) {
            if (this.structure[i] == null) {
                this.structure[i] = element;
            }
        }
    }

    public void remove() throws OperationNotSupportedException {
        if (this.structureIsEmpty()) {
            throw new OperationNotSupportedException();
        }

        for (int i = this.structure.length - 1; i >= 0 ; i--) {
            if (this.structure[i] != null) {
                this.structure[i] = null;
            }
        }
    }

    public Integer[] fetch() {
        return this.structure;
    }

    private boolean structureIsEmpty() {
        for (Integer cell : this.structure) {
            if (cell != null) {
                return false;
            }
        }
        return true;
    }

    private void addAll(Integer[] values) throws OperationNotSupportedException {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                throw new OperationNotSupportedException();
            }
            this.structure[i] = values[i];
        }
    }
}

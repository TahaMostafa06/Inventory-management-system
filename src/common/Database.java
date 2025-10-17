package common;

import java.util.ArrayList;

public abstract class Database<RecordType extends Record> {

    // Fields - remember to make them private when subclassing
    protected ArrayList<RecordType> records;
    protected final String filename;

    // Constructor blueprint
    public Database(String filename) {
        this.filename = filename;
        this.readFromFile();
    }

    abstract public void readFromFile(); // TODO: make concrete

    abstract public void saveToFile(); // TODO: make concrete

    abstract public RecordType createRecordFrom(String line);

    abstract public boolean contains(String key);

    public RecordType getRecord(String key) {
        for (var r : this.records) {
            if (r.getSearchKey().equals(key))
                return r;
        }
        return null;
    }
}

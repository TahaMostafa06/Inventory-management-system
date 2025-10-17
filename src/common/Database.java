package common;

import java.util.ArrayList;

public abstract class Database<RecordType extends Record> {

    // A] Fields - remember to turn protected -> private when subclassing
    protected ArrayList<RecordType> records;
    protected final String filename;

    // B] Constructor blueprint
    public Database(String filename) {
        this.filename = filename;
        this.readFromFile();
    }

    // C] Methods

    // Getters
    public ArrayList<RecordType> returnAllRecords() {
        // discuss whether returning a deep clone is better
        return this.records;
    }

    public RecordType getRecord(String key) {
        for (var r : this.records) {
            if (r.getSearchKey().equals(key)) {
                return r;
            }
        }
        return null;
    }

    // Setters
    public void insertRecord(RecordType record) {
        this.records.add(record);
    }

    public void deleteRecord(String key) {
        var query = getRecord(key);
        if (query != null) {
            this.records.remove(query);
        }
    }

    // Concrete methods
    public boolean contains(String key) {
        for (var r : this.records) {
            if (r.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Abstract methods

    abstract public void readFromFile() throws RuntimeException{
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                RecordType record=createRecordFrom(line)
                this.records.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    abstract public void saveToFile(){

    }

    abstract public RecordType createRecordFrom(String line);

}

package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Database<RecordType extends Record> {

    // A] Fields - remember to turn protected -> private when subclassing
    protected ArrayList<RecordType> records;
    protected final String filename;

    // B] Constructor blueprint
    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<RecordType>(0);
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

    public void readFromFile() throws RuntimeException {
        try (var br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                var record = createRecordFrom(line);
                this.records.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveToFile() {
        try (var writer = new BufferedWriter(new FileWriter(this.filename, false))) {
            writer.write(""); // clear and rewrite each emplyee user seperately on each line
            for (var r : this.records) {
                writer.write(r.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Abstract methods
    abstract public RecordType createRecordFrom(String line);

}

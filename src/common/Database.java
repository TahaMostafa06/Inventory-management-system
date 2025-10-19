package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Database<RecordType extends Record> {

    // A] Fields
    private ArrayList<RecordType> records;
    private final String filename;

    // B] Constructor blueprint
    public Database(String filename) throws IOException {
        this.filename = filename;
        this.readFromFile();
    }

    // C] Methods

    // Getters
    public final ArrayList<RecordType> returnAllRecords() {
        // discuss whether returning a deep clone is better
        return this.records;
    }

    public final RecordType getRecord(String key) {
        for (var r : this.records) {
            if (r.getSearchKey().equals(key)) {
                return r;
            }
        }
        return null;
    }

    // Setters
    public final void insertRecord(RecordType record) {
        this.records.add(record);
    }

    public final void deleteRecord(String key) {
        var query = getRecord(key);
        if (query != null) {
            this.records.remove(query);
        }
    }

    // Concrete methods
    public final boolean contains(String key) {
        for (var r : this.records) {
            if (r.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public final void readFromFile() throws IOException {
        var tempRecords = new ArrayList<RecordType>(0);
        if (this.records == null)
            this.records = tempRecords;
        // Context manager to automagically close resources
        try (var br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                var record = createRecordFrom(line);
                tempRecords.add(record);
            }
        } catch (IOException e) {
            // RuntimeException is bad, also we only use try-catch here for the context
            // manager
            throw new IOException(e);
        }
        this.records = tempRecords;
    }

    public final void saveToFile() throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(this.filename, false))) {
            writer.write(""); // clear and rewrite each emplyee user seperately on each line
            for (var r : this.records) {
                writer.write(r.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    // Abstract methods
    abstract public RecordType createRecordFrom(String line);

}
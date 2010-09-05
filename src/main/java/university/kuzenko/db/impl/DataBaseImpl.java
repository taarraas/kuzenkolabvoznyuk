/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package university.kuzenko.db.impl;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import university.kuzenko.db.AttributeType;
import university.kuzenko.db.DataBase;
import university.kuzenko.db.Row;
import university.kuzenko.db.Table;
import university.kuzenko.db.TableHeader;

/**
 *
 * @author taras
 */
public class DataBaseImpl implements DataBase {

    public static String EXTENSION = ".ser";
    Map<String, TableImpl> tables = new HashMap<String, TableImpl>();
    File path;

    public DataBaseImpl(String path, boolean create) {
        this.path = new File(path+EXTENSION);
        if (!create) {
            loadDB();
        }
    }

    @Override
    public Table createTable(String name, TableHeader header) {
        if (tables.containsKey(name)) {
            return null;
        }
        tables.put(name, new TableImpl(name, header));
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getTable(name);
    }

    @Override
    public Table getTable(String name) {
        return tables.get(name);
    }

    @Override
    public void deleteTable(String name) {
        tables.remove(name);
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Table projection(Table a, Collection<String> headerNames) {
        ArrayList<String> names = new ArrayList<String>(headerNames);
        ArrayList<AttributeType> types = new ArrayList<AttributeType>();
        for (String string : names) {
            types.add(a.getHeader().getForName(string));
        }
        TableHeader header = new TableHeader(names, types);
        TableImpl table = new TableImpl(a+"_proj", header);
        for (Row row : ((TableImpl)a).rows) {
            Row rownew = new Row(header);
            for (String string : headerNames) {
                rownew.set(string, row.get(string));
            }
            table.addRow(rownew);
        }
        return table;
    }   

    public void loadDB() {
        try {
            //use buffering
            InputStream file = new FileInputStream(path);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                tables = (Map<String, TableImpl>) input.readObject();
            } finally {
                input.close();
            }
        } catch (ClassNotFoundException ex) {
            throw new Error("cannot load");
        } catch (IOException ex) {
            throw new Error("cannot load");
        }
    }

    @Override
    public void save() throws IOException {
            OutputStream file = new FileOutputStream(path);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(tables);
            } finally {
                output.close();
            }
    }

    @Override
    public String getPath() {
        return path.toString();
    }

    @Override
    public String[] getTableNames() {
        return tables.keySet().toArray(new String[0]);
    }

   
}

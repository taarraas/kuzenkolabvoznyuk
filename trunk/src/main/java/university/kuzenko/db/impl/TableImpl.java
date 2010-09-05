/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db.impl;

import java.io.*;
import java.util.ArrayList;
import university.kuzenko.db.Row;
import university.kuzenko.db.Table;
import university.kuzenko.db.TableHeader;

/**
 *
 * @author taras
 */
public class TableImpl implements Table, Serializable{
    String name;
    TableHeader header;
    ArrayList<Row> rows= new ArrayList<Row>();

    public TableImpl(String name, TableHeader header) {
        this.name = name;
        this.header = header;
    }
    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TableHeader getHeader() {
        return header;
    }

    @Override
    public Row getRow(int no) {
        return rows.get(no);
    }

    @Override
    public Row[] getRows(int from, int to) {
        Row[] rows = new Row[to - from];
        for (int i=from; i<to; i++) {
            rows[i - from] = getRow(i);
        }
        return rows;
    }

    @Override
    public void setRow(int pos, Row row) {
        rows.set(pos, row);
    }

    @Override
    public void removeRow(int pos) {
        rows.remove(pos);
    }

    @Override
    public void addRow(Row row) {
        rows.add(row);
    }

    @Override
    public int size() {
        return rows.size();
    }
}

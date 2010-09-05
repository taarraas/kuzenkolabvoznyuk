/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author taras
 */
public interface Table{
    public String getName();
    public TableHeader getHeader();
    public Row getRow(int no);
    public Row[] getRows(int from, int to);
    public void setRow(int pos, Row row);
    public void removeRow(int pos);
    public void addRow(Row row);
    public int size();
}

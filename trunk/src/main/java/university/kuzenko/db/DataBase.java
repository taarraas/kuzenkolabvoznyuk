/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db;

import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author taras
 */
public interface DataBase {
    public String[] getTableNames();
    public Table createTable(String name, TableHeader header);
    public Table getTable(String name);
    public void deleteTable(String name);    
    public Table projection(Table a, Collection<String> names);
    public void save() throws IOException;
    public String getPath();
}

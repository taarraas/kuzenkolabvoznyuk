/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author taras
 */
public class TableHeader implements Serializable {
    ArrayList<String> names;
    ArrayList<AttributeType> types;

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<AttributeType> getTypes() {
        return types;
    }
    public AttributeType getForName(String name) {
        for (int i = 0; i < names.size(); i++) {
            String string = names.get(i);
            if (string.equals(name)) {
                return types.get(i);
            }
        }
        return null;
    }
    
    public TableHeader(ArrayList<String> names, ArrayList<AttributeType> types) {
        this.names = names;
        this.types = types;
    }
    
    public int size() {
        return names.size();
    }
}

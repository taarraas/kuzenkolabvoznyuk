/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.client;

import university.kuzenko.db.DataBase;
import university.kuzenko.db.DataBases;
import university.kuzenko.db.impl.DataBaseImpl;
import university.kuzenko.db.impl.DatabasesImpl;

/**
 *
 * @author taras
 */
public class DatabaseFactory {
    public static enum Type {
        DIRECT
    };
    public static DataBase getDatabase(Type type, String name) {
        switch (type) {
            case DIRECT: {
                return new DataBaseImpl(name, false);
            }
        }
        return null;
    }
    public static DataBases getDatabases(Type type) {
        switch (type) {
            case DIRECT: {
                return new DatabasesImpl();
            }
        }
        return null;
    }
}

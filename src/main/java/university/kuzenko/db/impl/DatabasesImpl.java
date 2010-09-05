/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package university.kuzenko.db.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import university.kuzenko.db.DataBases;

/**
 *
 * @author taras
 */
public class DatabasesImpl implements DataBases {

    @Override
    public String[] getNames() {
        File file = new File(".");
        String ret[]=file.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(DataBaseImpl.EXTENSION);
            }
        });
        for (int i = 0; i < ret.length; i++) {
            String string = ret[i];
            ret[i]=string.substring(0, string.length()-DataBaseImpl.EXTENSION.length());
        }
        return ret;
    }

    @Override
    public void delete(String name) {
        File file = new File(name + DataBaseImpl.EXTENSION);
        file.delete();
    }

    @Override
    public void create(String name) {
        DataBaseImpl impl = new DataBaseImpl(name, true);
        try {
            impl.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

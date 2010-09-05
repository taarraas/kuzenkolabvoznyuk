/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db;

/**
 *
 * @author taras
 */
public interface DataBases {
        public String[] getNames();
        public void delete(String name);
        public void create(String name);
}

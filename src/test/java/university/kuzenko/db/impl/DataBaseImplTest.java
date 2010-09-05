/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import junit.framework.TestCase;
import university.kuzenko.db.AttributeType;
import university.kuzenko.db.Row;
import university.kuzenko.db.Table;
import university.kuzenko.db.TableHeader;

/**
 *
 * @author taras
 */
public class DataBaseImplTest extends TestCase {
    
    public DataBaseImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of createTable method, of class DataBaseImpl.
     */
    public void testCreateTable() {
        System.out.println("createTable");
        String name = "experimental";
        TableHeader header = new TableHeader(new ArrayList(Arrays.asList("int")),
                new ArrayList(Arrays.asList(AttributeType.INTEGER)));
        DataBaseImpl instance = new DataBaseImpl("testing", true);
        Table result = instance.createTable(name, header);
        assertTrue(instance.getTable(name) != null);
       
    }
    /**
     * Test of getTables method, of class DataBaseImpl.
     */
    public void testProjection() {
        String name = "experimental";
        TableHeader header = new TableHeader(new ArrayList(Arrays.asList("1", "2")),
                new ArrayList(Arrays.asList(AttributeType.INTEGER, AttributeType.INTEGER)));
        DataBaseImpl instance = new DataBaseImpl("testing", true);
        Table result = instance.createTable(name, header);
        result.addRow(new Row(header));
        result.getRow(0).set(0, 1);
        result.addRow(new Row(header));
        result.getRow(1).set(0, 2);
        result.addRow(new Row(header));
        result.getRow(2).set(0, 3);
        Table proj = instance.projection(result, Arrays.asList("1"));
        assertEquals(proj.getHeader().size(), 1);
        assertEquals(proj.getRow(0).get(0), 1);

    }



    /**
     * Test of save method, of class DataBaseImpl.
     */
    public void testLoadAndSave() throws IOException{
        System.out.println("LoadAndSave");
                System.out.println("createTable");
        String name = "experimental";
        TableHeader header = new TableHeader(new ArrayList(Arrays.asList("int")),
                new ArrayList(Arrays.asList(AttributeType.INTEGER)));
        DataBaseImpl instance = new DataBaseImpl("testing", true);
        instance.createTable(name, header);
        instance.save();
        DataBaseImpl loaded = new DataBaseImpl("testing", false);
        assertTrue(loaded.getTable(name) != null);
    }

}

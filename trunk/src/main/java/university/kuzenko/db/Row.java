/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author taras
 */
public class Row implements Serializable{
    TableHeader header;
    ArrayList<Object> data;
    public TableHeader getHeader() {
        return header;
    }
    public Row(TableHeader header) {
        this.header = header;
        data = new ArrayList<Object>(header.size());
        for (AttributeType attributeType : header.types) {
           switch (attributeType) {
               case CHAR: {
                    data.add(new Character(' '));
                    break;
                }
               case INTEGER: {
                    data.add(new Integer(0));
                    break;
                }
               case PICTURE: {
                    data.add("");
                    break;
                }
               case REAL: {
                   data.add(new Double(0));
                   break;
               }
               case REALINVL: {
                   data.add(new DoubleInterval(0., 0.));
                   break;
               }
           }
        }        
    }
    public Object get(int no) {
        return data.get(no);
    }
    public int size() {
        return data.size();
    }
    public boolean set(int no, Object data) {
        if (data == null) {
            return false;
        }
        switch (header.getTypes().get(no)) {
            case CHAR: {
                if (!(data instanceof Character)) {
                    return false;
                }
                break;
            }
            case INTEGER: {
                if (!(data instanceof Integer)) {
                    return false;
                }
                break;
            }
            case PICTURE: {
                if (!(data instanceof String)) {
                    return false;
                }
                break;
            }
            case REAL: {
                if (!(data instanceof Double)) {
                    return false;
                }
                break;
            }
            case REALINVL: {
                if (!(data instanceof DoubleInterval)) {
                    return false;
                }
                break;
            }
        }
        this.data.set(no, data);
        return true;
    }
    public boolean set(String name, Object data) {
        return set(header.getNames().indexOf(name), data);
    }

    public Object get(String name) {
        return get(header.getNames().indexOf(name));
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package university.kuzenko.db;

import java.io.Serializable;

/**
 *
 * @author taras
 */
public class DoubleInterval  implements Serializable {
    Double a, b;

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public DoubleInterval(Double a, Double b) {
        this.a = a;
        this.b = b;
    }
    public String toString() {
        return a+"-"+b;
    }
    public static DoubleInterval valueOf(String s) {
        String[] p = s.split("-");
        if (p.length!=2) {
            throw new IllegalArgumentException("Can't parse");
        }
        return new DoubleInterval(Double.valueOf(p[0]), Double.valueOf(p[1]));
    }
    
}

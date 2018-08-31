
package com.haruhi.sos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>add complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="add">
 *   &lt;complexContent>
 *     &lt;restriction basedao="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "a",
    "b"
})
public class Add {

    protected int a;
    protected int b;

    /**
     * ��ȡa���Ե�ֵ��
     * 
     */
    public int getA() {
        return a;
    }

    /**
     * ����a���Ե�ֵ��
     * 
     */
    public void setA(int value) {
        this.a = value;
    }

    /**
     * ��ȡb���Ե�ֵ��
     * 
     */
    public int getB() {
        return b;
    }

    /**
     * ����b���Ե�ֵ��
     * 
     */
    public void setB(int value) {
        this.b = value;
    }

}

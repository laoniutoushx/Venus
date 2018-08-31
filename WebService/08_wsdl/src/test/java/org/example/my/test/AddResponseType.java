
package org.example.my.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addResponseType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="addResponseType">
 *   &lt;complexContent>
 *     &lt;restriction basedao="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addResponseType", propOrder = {
    "addResult"
})
public class AddResponseType {

    protected int addResult;

    /**
     * ��ȡaddResult���Ե�ֵ��
     * 
     */
    public int getAddResult() {
        return addResult;
    }

    /**
     * ����addResult���Ե�ֵ��
     * 
     */
    public void setAddResult(int value) {
        this.addResult = value;
    }

}

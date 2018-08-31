
package sos.haruhi.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>license complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="license">
 *   &lt;complexContent>
 *     &lt;restriction basedao="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registerUser" type="{http://sos.haruhi.ws/test/}user"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "license", propOrder = {
    "registerUser"
})
public class License {

    @XmlElement(required = true)
    protected User registerUser;

    /**
     * ��ȡregisterUser���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getRegisterUser() {
        return registerUser;
    }

    /**
     * ����registerUser���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setRegisterUser(User value) {
        this.registerUser = value;
    }

}

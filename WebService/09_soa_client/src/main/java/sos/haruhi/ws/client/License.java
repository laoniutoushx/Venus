
package sos.haruhi.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>license complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="license">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
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
     * 获取registerUser属性的值。
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
     * 设置registerUser属性的值。
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

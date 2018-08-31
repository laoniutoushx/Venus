
package com.haruhi.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>loginResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="loginResponse">
 *   &lt;complexContent>
 *     &lt;restriction basedao="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loginResult" type="{http://ws.haruhi.com/}service" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginResponse", propOrder = {
    "loginResult"
})
public class LoginResponse {

    protected User loginResult;

    /**
     * ��ȡloginResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getLoginResult() {
        return loginResult;
    }

    /**
     * ����loginResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setLoginResult(User value) {
        this.loginResult = value;
    }

}

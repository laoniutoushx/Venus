
package sos.haruhi.ws.webservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UserException", targetNamespace = "http://sos.haruhi.ws/test/")
public class UserException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UserException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UserException_Exception(String message, UserException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UserException_Exception(String message, UserException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: sos.haruhi.ws.webservice.UserException
     */
    public UserException getFaultInfo() {
        return faultInfo;
    }

}

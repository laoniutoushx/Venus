package sos.haruhi.soap.handler;

import com.haruhi.UserException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.Set;

public class LicenseHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("handler");
        Boolean out = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(!out){
            SOAPMessage message = context.getMessage();
            try {
                SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                SOAPBody body = envelope.getBody();
                SOAPHeader header = envelope.getHeader();

                // 判断方法名称
                Node bnode = body.getChildNodes().item(0);
                String partname = bnode.getLocalName();


                if("list".equals(partname) || "addUser".equals(partname)){
                    // 处理头信息
                    if(header == null || header.getFirstChild() == null){
                        SOAPFault fault = body.addFault();
                        fault.setFaultString("头信息为空");
                        throw new SOAPFaultException(fault);
                    }

                    if(header != null){
                        NodeList nodeList = header.getElementsByTagName("ws:licenseInfo");
                        System.out.println(nodeList.getLength());
                        Node node = nodeList.item(0);
                        System.out.println(node.getTextContent());
                    }
                }


            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}

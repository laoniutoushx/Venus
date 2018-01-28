package sos.haruhi.test;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.IOException;
import java.util.Set;

/**
 * SOAP handler  创建类，实现接口，配置 Handler
 */
// 对 SOAP handler 进行处理 SOAPMessage
public class HeadHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("handler");
        // 客户端 请求 服务端
        Boolean out = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(out){
            SOAPMessage message = context.getMessage();
            // 判断 message 是否有 header
            try {
                SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                if(header == null){
                    envelope.addHeader();
                }
                QName qName = new QName("http://haruhi.com/", "licenseInfo", "ws");
                header.addHeaderElement(qName).setValue("123123");
                message.writeTo(System.out);
                System.out.println();

            } catch (SOAPException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("error");
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}

package sos.haruhi.com;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@WebService(name = "sos.haruhi.com.IMyService")
@MTOM
public class MyServiceImpl implements IMyService {

    @Override
    @WebMethod(operationName = "upload")
    public void upload(@WebParam(name = "file") byte[] file) {

    }

}

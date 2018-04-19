package Service;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class TestClient {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://localhost:8888/ns?wsdl");
            QName qName = new QName("http://Service/","MyServiceDaoImplService");
            Service service = Service.create(url,qName);

            MyServiceDao myServiceDao = service.getPort(MyServiceDao.class);
            System.out.println(myServiceDao.add(11,22));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

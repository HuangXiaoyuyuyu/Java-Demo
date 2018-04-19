package Service;

import javax.xml.ws.Endpoint;

public class MyService {
    public static void main(String[] args) {
        String address = "http://localhost:8888/ns";
        Endpoint.publish(address,new MyServiceDaoImpl());
    }
}

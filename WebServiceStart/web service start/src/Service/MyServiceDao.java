package Service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface MyServiceDao {
    @WebResult(name = "addResult")
    public int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b);
    @WebResult(name = "minusResult")
    public int minus(@WebParam(name = "a") int a,@WebParam(name = "b") int b);
    @WebResult(name = "loginUser")
    public User login(@WebParam(name = "username") String username,@WebParam(name = "password") String password);
}

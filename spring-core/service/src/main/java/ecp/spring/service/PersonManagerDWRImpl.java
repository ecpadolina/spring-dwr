package ecp.spring.service;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personDWR")
@RemoteProxy(name="dwrService")
@Transactional
public class PersonManagerDWRImpl {

    @RemoteMethod
    public Integer add(Integer a, Integer b){
        return a+b;
    }
}

package ecp.spring.service;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import ecp.spring.dao.PersonDaoImpl;
import ecp.spring.dao.RoleDaoImpl;
import ecp.spring.model.Person;
import java.util.List;

@Service("dwrService")
@RemoteProxy(name="personDWRService")
@Transactional
public class DWRService {

	@Autowired
	PersonDaoImpl personDaoImpl;

	@Autowired
	RoleDaoImpl roleDaoImpl;

  	@RemoteMethod
  	public List listRolesWithPerson(){
    	return roleDaoImpl.listRolesWithPerson();
  	}

  	@RemoteMethod
  	public List listPerson(int roleId, int order, String column){
  		return personDaoImpl.listPerson(roleId, order, column);
  	}

    @RemoteMethod
    public String deletePerson(int personId){
      personDaoImpl.deletePerson(personDaoImpl.getPerson(personId));
      return "";
    }

}

package ecp.spring.service;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import ecp.spring.dao.PersonDaoImpl;
import ecp.spring.dao.RoleDaoImpl;
import ecp.spring.dao.ProjectDaoImpl;
import ecp.spring.model.Person;
import ecp.spring.model.Tickets;
import ecp.spring.model.Project;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service("dwrService")
@RemoteProxy(name="DWRService")
@Transactional
public class DWRService {

	@Autowired
	private PersonDaoImpl personDaoImpl;

	@Autowired
	private RoleDaoImpl roleDaoImpl;

  @Autowired
  private ProjectDaoImpl projectDao;

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

    @RemoteMethod
    public boolean deleteTicket(int projectId, int ticketId){
      Project project = projectDao.getProject(projectId);
      Set<Tickets> tickets = project.getTickets();
      for(Tickets ticket : tickets){
        if(ticketId == ticket.getId()){
            tickets.remove(ticket);
            project.setTickets(tickets);
            projectDao.updateProject(project);
            return true;
        }
      }
      return false;
    }

    @RemoteMethod
    public Set<Tickets> listProjectTicket(int projectId){
      Set<Tickets> tickets = projectDao.getProject(projectId).getTickets();
      if(tickets != null){
        return tickets;
      }
      return new HashSet();
    }
}

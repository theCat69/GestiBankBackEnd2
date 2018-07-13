import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wha.config.AppConfig;
import com.wha.config.JpaConfiguration;
import com.wha.model.Client;
import com.wha.service.ServiceClient;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, JpaConfiguration.class})
public class ServiceClientsTest {
	
	@Autowired
	ServiceClient serviceClient;
	
//	void saveClient(Client client);
	
	@Test
	@Transactional
	@Rollback(true)
	public void saveClientTest() {
		//récupération du nombre de clent avant ajout
		int nbInitial = serviceClient.findAllClients().size();
		//ajout d'un Client
		Client c = new Client(0,"Toto","Tata", null, null, null, null, null, 0, null, 0);
		serviceClient.saveClient(c);
		
		// comparaison finale pour validation du test
		int nbFinal = serviceClient.findAllClients().size();
		assertEquals(nbInitial+1, nbFinal);
	}
	
	@Test
	public void findAllClientsTest() {
		assertNotNull(serviceClient.findAllClients());
	}
	public ServiceClientsTest() {
		// TODO Auto-generated constructor stub
	}

}

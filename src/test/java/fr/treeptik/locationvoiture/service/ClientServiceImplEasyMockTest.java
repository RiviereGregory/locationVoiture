package fr.treeptik.locationvoiture.service;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.impl.ClientServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/dispatcher-servlet.xml" })
public class ClientServiceImplEasyMockTest {

	@Autowired
	private ClientService clientService;

	@Before
	public void premiereMethode() {
		System.out.println("******* Test Service Client *******");
	}

	@Test
	public void testfindall() {
		try {
			clientService = new ClientServiceImpl();

			Client client = new Client();
			client.setNom("Nom");
			client.setPrenom("Prenom");
			client.setMail("mail@mail.com");
			Client client1 = new Client();
			client1.setNom("Nom1");
			client1.setPrenom("Prenom1");
			client1.setMail("mail1@mail.com");
			Client client2 = new Client();
			client2.setNom("Nom2");
			client2.setPrenom("Prenom2");
			client2.setMail("mail2@mail.com");
			Client client3 = new Client();
			client3.setNom("Nom3");
			client3.setPrenom("Prenom3");
			client3.setMail("mail3@mail.com");

			List<Client> list = Arrays.asList(client, client1, client2, client3);

			// Création du Mock
			ClientDAO clientDAOMock = EasyMock.createMock(ClientDAO.class);

			// On retourne la list que l'on a crée
			EasyMock.expect(clientDAOMock.findAll()).andReturn(list);

			// On finit le mock pour l'utiliser
			EasyMock.replay(clientDAOMock);

			// clientDAO c'est le dao utilisé dans le service Impl
			ReflectionTestUtils.setField(clientService, "clientDAO", clientDAOMock);

			List<Client> clients = clientService.findAll();

			Assert.assertTrue(clients.size() == 4);

		} catch (ServiceException | DAOException e) {
			Assert.fail(e.getMessage());
		}
	}
}

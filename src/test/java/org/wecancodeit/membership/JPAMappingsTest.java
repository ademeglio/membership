package org.wecancodeit.membership;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	UserRepository userRepo;
	
	@Resource
	TestEntityManager entityManager;
	
	@Test
	public void shouldSaveAndLoadUsers() {
		User user = userRepo.save(new User("agent", "secret"));
		long userId = user.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<User> result = userRepo.findById(userId);
		User resultUser = result.get();
		assertThat(resultUser.getUsername(), is ("agent"));
	}
}

package tw.c3p0cy.practice.springboot.springbootprofiles;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("production") // <-- Set an active profile via @ActiveProfiles
public class WhoAmITest {

  @Autowired
  private WhoAmI whoAmI;

  @Test
  public void about() {
    String output = whoAmI.about();
    String expected = ProdService.class.getSimpleName();
    assertThat(output).contains(expected);
  }
}
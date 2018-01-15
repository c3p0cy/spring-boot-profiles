package tw.c3p0cy.practice.springboot.springbootprofiles;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class SpringBootProfilesApplicationTest {

  @Rule
  public OutputCapture outputCapture = new OutputCapture();

  private String profiles;

  @Before
  public void before() {
    this.profiles = System.getProperty("spring.profiles.active");
  }

  @After
  public void after() {
    if (this.profiles != null) {
      System.setProperty("spring.profiles.active", this.profiles);
    }
    else {
      System.clearProperty("spring.profiles.active");
    }
  }

  @Test
  public void testDefaultProfile() throws Exception {
    SpringBootProfilesApplication.main(new String[0]);
    verify(this.outputCapture.toString(), DevService.class.getSimpleName());
  }

  @Test
  public void testDevelopmentProfile() throws Exception {
    System.setProperty("spring.profiles.active", "development");
    SpringBootProfilesApplication.main(new String[0]);
    verify(this.outputCapture.toString(), DevService.class.getSimpleName());
  }

  @Test
  public void testProductionProfile() throws Exception {
    System.setProperty("spring.profiles.active", "production");
    SpringBootProfilesApplication.main(new String[0]);
    verify(this.outputCapture.toString(), ProdService.class.getSimpleName());
  }

  @Test
  public void testProductionProfileFromCommandline() throws Exception {
    SpringBootProfilesApplication.main(new String[] { "--spring.profiles.active=production" });
    verify(this.outputCapture.toString(), ProdService.class.getSimpleName());
  }

  private void verify(String result, String expect) {
    assertThat(result).contains(expect);
  }
}
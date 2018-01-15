package tw.c3p0cy.practice.springboot.springbootprofiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"development", "default"})
public class DevService implements WhoAmI {

  @Override
  public String about() {
    return this.getClass().getSimpleName();
  }
}

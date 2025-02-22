package test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ServiceLoader;
import java.util.Set;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestEngine;
import test.base.PrependModuleName;

@DisplayNameGeneration(PrependModuleName.class)
class IntegrationTests {

  @Test
  void loadLoomingEngineAndCheckItsModuleAPI() {
    var module =
        ServiceLoader.load(TestEngine.class).stream()
            .map(ServiceLoader.Provider::get)
            .filter(engine -> engine.getId().equals("looming"))
            .findFirst()
            .orElseThrow()
            .getClass()
            .getModule();
    assertEquals("de.sormuras.junit.looming", module.getName());
    assertEquals(Set.of(), module.getDescriptor().exports());
    assertEquals(
        "[org.junit.platform.engine.TestEngine with [de.sormuras.junit.looming.LoomTestEngine]]",
        module.getDescriptor().provides().toString());
  }
}

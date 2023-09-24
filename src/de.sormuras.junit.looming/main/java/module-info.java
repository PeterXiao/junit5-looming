module de.sormuras.junit.looming {
  //exports de.sormuras.junit.looming;
  requires org.junit.platform.engine;
    requires org.junit.jupiter.api;
    provides org.junit.platform.engine.TestEngine with
      de.sormuras.junit.looming.LoomTestEngine;
}

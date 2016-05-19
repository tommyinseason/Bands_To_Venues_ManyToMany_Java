import org.sql2o.*;
import org.junit.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.junit.Assert.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Bands");
  }

  @Test
  public void bandIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Bands"));
    fill("#name").with("ACDC");
    submit(".btn");
    assertThat(pageSource()).contains("ACDC");
  }

  @Test
  public void venueIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Venues"));
    fill("#name").with("CBGB");
    submit(".btn");
    assertThat(pageSource()).contains("CBGB");
  }

  @Test
  public void bandIsDeleted() {
    Band testBand = new Band("ACDC");
    testBand.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    submit("#delete");
    goTo(url);
    assertThat(pageSource()).contains("$band.getName()");
  }

  @Test
  public void bandShowPageDisplaysName() {
    Band testBands = new Band("ACDC");
    testBands.save();
    String url = String.format("http://localhost:4567/bands/%d", testBands.getId());
    goTo(url);
    assertThat(pageSource()).contains("ACDC");
  }

  @Test
  public void venueShowPageDisplaysName() {
    Venue testVenue = new Venue("CBGB");
    testVenue.save();
    String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
    goTo(url);
    assertThat(pageSource()).contains("CBGB");
  }

  @Test
  public void venueIsAddedToBand() {
    Band testBand = new Band("ACDC");
    testBand.save();
    Venue testVenue = new Venue("CBGB");
    testVenue.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    fillSelect("#venue_id").withText("CBGB");
    submit(".btn");
    assertThat(pageSource()).contains("<li>");
    assertThat(pageSource()).contains("CBGB");
  }
}

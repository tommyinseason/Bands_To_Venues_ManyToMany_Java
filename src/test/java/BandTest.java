import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void band_instatiatesCorrectly_true() {
    Band myBand = new Band("ACDC");
    assertEquals(true, myBand instanceof Band);
  }

}

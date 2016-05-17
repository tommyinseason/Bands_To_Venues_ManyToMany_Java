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

  @Test
  public void getName_bandInstantiatesWithName_String() {
    Band myBand = new Band("ACDC");
    assertEquals("ACDC", myBand.getName());
  }

  // @Test
  // public void all_emptyAtFirst_0() {
  //   assertEquals(0, Band.all().size());
  // }
  // @Test
  // public void equals_returnsTrueIfNamesAretheSame_true() {
  //   Band firstBand = new Band ("ACDC");
  //   Band secondBand = new Band("ACDC");
  //   assertEquals(firstBand.equals(secondBand));
  // }
  // @Test
  // public void save_savesObjectIntoDatabase_true() {
  //   Band myBand = new Band("ACDC");
  //   myBand.save();
  //   assertTrue(Band.all().get(0).equals(myBand));
  // }

}

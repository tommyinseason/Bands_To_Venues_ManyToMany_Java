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

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Band.all().size());
  }
  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Band firstBand = new Band ("ACDC");
    Band secondBand = new Band("ACDC");
    assertTrue(firstBand.equals(secondBand));
  }
  @Test
  public void save_savesObjectIntoDatabase_true() {
    Band myBand = new Band("ACDC");
    myBand.save();
    assertTrue(Band.all().get(0).equals(myBand));
  }

  @Test
  public void save_assignsIdToObject_int() {
    Band myBand = new Band("ACDC");
    myBand.save();
    Band savedBand = Band.all().get(0);
    assertEquals(myBand.getId(), savedBand.getId());
  }
  @Test
  public void find_findBandInDatabase_true() {
    Band myBand = new Band("ACDC");
    myBand.save();
    Band savedBand = Band.find(myBand.getId());
    assertTrue(myBand.equals(savedBand));
  }
  @Test
  public void update_updatesBands_true() {
    Band myBand = new Band("ACDC");
    myBand.save();
    myBand.update("ACDC");
    assertEquals("ACDC", Band.find(myBand.getId()).getName());
  }
  // @Test
  // public void delete_deletesBand_true() {
  //   Band myBand = new Band("ACDC");
  //   myBand.save();
  //   int myId = myBand.getId();
  //   myBand.delete();
  //   assertEquals(null, Band.find(myId));
  // }
  // @Test
  // public void addVenue_addsVenueToBand() {
  //   Band myBand = new Band("ACDC");
  //   myBand.save();
  //   Venue myVenue = new Venue("CBGB");
  //   myVenue.save();
  //   myBand.addVenue(myVenue);
  //   Band savedBand = myVenue.getBands().get(0);
  //   assertTrue(myBand.equals(savedBand));
  // }
  //
  // @Test
  // public void getVenues_returnsAllVenues_List() {
  //   Band myBand = new Band("ACDC");
  //   myBand.save();
  //   Venue myVenue = new Venue("CBGB");
  //   myVenue.save();
  //   myBand.addVenue(myVenue);
  //   List savedVenues = myBand.getVenues();
  //   assertEquals(1, savedVenues.size());
  // }
  //
  // @Test
  // public void delete_deletesAllBandAndVenueAssociations() {
  //   Venue myVenue = new Venue("ACDC");
  //   myVenue.save();
  //   Band myBand = new Band("CBGB");
  //   myBand.save();
  //   myBand.addVenue(myVenue);
  //   myBand.delete();
  //   assertEquals(0, myVenue.getBands().size());
  // }


}

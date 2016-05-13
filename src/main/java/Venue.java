// import org.sql2o.*;
// import java.util.List;
// import java.util.ArrayList;
//
// public class Venue {
//   private int id;
//   private String name;
//
//   public Venue(String name) {
//     this.name = name;
//   }
//
//   public String getName() {
//     return name;
//   }
//
//   public int getId() {
//     return id;
//   }
//
//   public static List<Venue> all() {
//     String sql = "SELECT id, name FROM venues";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Venue.class);
//     }
//   }
//
//   @Override
//   public boolean equals(Object otherVenue) {
//     if (!(otherVenue instanceof Venue)) {
//       return false;
//     } else {
//       Venue newVenue = (Venue) otherVenue;
//       return this.getName().equals(newVenue.getName()) &&
//       this.getId() == newVenue.getId();
//     }
//   }
//
//   public void save() {
//     try(Connection con = DB.sql2o()) {
//       String sql = "INSERT INTO venues(name) VALUES (:name)";
//       this.id = (int) con.createQuery(sql, true)
//         .addParameter("name", this.name)
//         .executeUpdate()
//         .getKey();
//     }
//   }
//
//   public static Venue find(int id) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM venues where id=:id";
//       Venue venue = con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetchFirst(Venue.class);
//       return venue;
//     }
//   }
//
//   public void update(String newName) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "UPDATE venues SET name = :name WHERE id = :id";
//       con.createQuery(sql)
//         .addParameter("name", newName)
//         .addParameter("id", this.id)
//         .executeUpdate();
//     }
//   }
//
//   public void addBand(Band band) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "INSERT INTO bands_venues (bandid, venueid) VALUES (:bandid, :venueid)";
//       con.createQuery(sql)
//         .addParameter("bandid", band.getId())
//         .addParameter("venueid", this.getId())
//         .executeUpdate();
//     }
//   }
//
//   public List<Band> getBands() {
//     try(Connection con = DB.sql2o.open()) {
//       String joinQuery = "SELECT bandid FROM bands_venues WHERE venueid = :venueid";
//       List<Integer> bandIds = con.createQuery(joinQuery)
//         .addParameter("venueid", this.getId())
//         .executeAndFetch(Integer.class);
//
//       List<Band> bands = new ArrayList<Band>();
//
//       for (Integer bandId : bandIds) {
//         String venueQuery = "SELECT * FROM bands WHERE id = :bandId";
//         Band band = con.createQuery(venueQuery)
//           .addParameter("bandId", bandId)
//           .executeAndFetchFirst(Band.class);
//         bands.add(band);
//       }
//       return bands;
//     }
//   }
//   public void delete() {
//     try(Connection con = DB.sql2o.open()) {
//       String deleteQuery = "DELETE FROM venues WHERE id = :id;";
//         con.createQuery(deleteQuery)
//           .addParameter("id", this.getId());
//           executeUpdate();
//
//       String joinDeleteQuery = "DELETE FROM bands_venues WHERE venueid = :venueid";
//
//       con.createQuery(joinDeleteQuery)
//       .addParameter("venueid", this.getId())
//       .executeUpdate();
//     }
//   }
// }

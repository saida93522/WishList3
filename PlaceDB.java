import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceDB {
    private static final String DB = "jdbc:sqlite:wishlist:sqlite";
    private static final String PLACE_ = "place";
    private static final String REASON_ = "reason";


    static final String GOOD = "ok";

    PlaceDB() {
        try (Connection connection = DriverManager.getConnection(DB);
             Statement statement = connection.createStatement()) {

            String TableSql = "CREATE TABLE IF NOT EXISTS wishlist" +
                    "(Place TEXT PRIMARY KEY, Reason TEXT PRIMARY KEY)";
            statement.executeUpdate(TableSql);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }

    }


    public List<Place> getAllList() {
        List<Place> allData = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB);
             Statement statement = conn.createStatement()) {
            String selectTable = "SELECT * FROM wishlist";
            ResultSet resultSet = statement.executeQuery(selectTable);

            while (resultSet.next()) {
                String name = resultSet.getString(PLACE_);
                String reason = resultSet.getString(REASON_);

                Place placedata = new Place(name, reason);
            }
            return allData;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public String addPlace(Place travel){
        String addSql = "INSERT INTO wishlist VALUES(?,?)";
        try(Connection conn = DriverManager.getConnection(DB);
        PreparedStatement preparedStatement = conn.prepareStatement(addSql)) {

            preparedStatement.setString(1,travel.getName());
            preparedStatement.setString(1,travel.getReason());
            return GOOD;


        }catch (SQLException sql){

            throw new RuntimeException(sql);

        }
    }


    public void Delete(Place location){
        String deleteTable = "DELETE FROM wishlist Where Place = ?";
        try(Connection connection = DriverManager.getConnection(DB);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteTable)) {

            preparedStatement.setString(1,location.getName());
            preparedStatement.execute();

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }
    }

    public void updateList(Place edit){
        String sql = "UPDATE wishlist SET = ?, Place = ? WHERE Reason = ? ";
        try (Connection conn = DriverManager.getConnection(DB);
        PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,edit.getName());
            preparedStatement.setString(2,edit.getReason());

            preparedStatement.executeUpdate();

        }catch (SQLException sqle){
            System.err.println("Error updating list" + sqle);
        }
    }
}

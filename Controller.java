import java.util.List;

public class Controller {
    private PlaceGui gui;
    private PlaceDB db;

    public static void main(String[] args) {
        new Controller().getList();
    }

    private void getList(){
        db = new PlaceDB();

        List<Place> allList = db.getAllList();

        gui = new PlaceGui(this);
        gui.setListData(allList);
    }

    List<Place> getAllListData(){
        return db.getAllList();
    }

    String addPlace(Place travel){
        return db.addPlace(travel);
    }

    void Delete(Place location){
         db.Delete(location);
    }

    void updateList(Place edit){
        db.updateList(edit);
    }
}

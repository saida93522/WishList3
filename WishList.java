import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static input.InputUtils.stringInput;
import static input.InputUtils.yesNoInput;

public class WishList {
    public static void main(String[] args) {
        List<Place> wishList = new ArrayList<Place>(); /// Arraylist of object

        do {

            String name = stringInput("Enter the name of the place");
            String reason = stringInput("Why do you want to visit " + name + "?");

            // The Place object's constructor should calculate the date created and store that.

            wishList.add(newPlace(name,reason));
            // Collections.sort(wishList);

            //newPlace(name,reason);

        } while (yesNoInput("More places to add to your wish list?"));
        Collections.sort(wishList); //collection and sorts through wish list
        displayPlacesInNameOrder(wishList);



    }

    public static Place newPlace(String placeName, String reason) {
        Place PlaceLocation = new Place(placeName,reason); //placelocation new object


        return PlaceLocation;

    }

    public static void displayPlacesInNameOrder(List<Place> places) {
        Collections.sort(places); ///sorts through places alphabetically from PLace comparable
        for(Place place: places){
            System.out.println(place);  /// prints line by line
        }






    }
}
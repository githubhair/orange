package pages;

import java.util.UUID;

public class NewUserPage {
    public String nameGenerator(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();




        //System.out.println("Random UUID(1): " +uuidStr);
    }
}

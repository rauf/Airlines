package models.UnrelatedEntity;


/**
 * Created by randomlocks on 10/20/2015.
 */

/* A thankyou window is open which after sometime redirect you to home page */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Entity
public class Feedback extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String email;   //optional , no constraints

    @Constraints.Required
    @Constraints.MinLength(20)
    public String message;

    //optional
    public String rating; //rating out of 10


    public static Finder<Long,Feedback> find = new Finder<>(Feedback.class);

    public Feedback(){
        // left blank
    }


    public static PagedList<Feedback> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size);

    }


}

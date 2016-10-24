package mytime.android.mytime.Structure;

/**
 * Created by DongJu on 10/23/16.
 */

public class Yelp {

    String yelp_rating;String yelp_rating_image_url;
    String yelp_review_count;String yelp_url;

    public Yelp(String yelp_rating, String yelp_rating_image_url, String yelp_review_count, String yelp_url){
        this.yelp_rating=yelp_rating;this.yelp_rating_image_url=yelp_rating_image_url;
        this.yelp_review_count=yelp_review_count;this.yelp_url=yelp_url;
    }
    public String getYelp_rating_image_url() {
        return yelp_rating_image_url;
    }

    public String getYelp_review_count() {
        return yelp_review_count;
    }

    public String getYelp_url() {
        return yelp_url;
    }
    public String getYelp_rating() {
        return yelp_rating;
    }

}

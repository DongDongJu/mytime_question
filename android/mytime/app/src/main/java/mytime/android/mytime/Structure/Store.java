package mytime.android.mytime.Structure;

/**
 * Created by DongJu on 10/23/16.
 */

public class Store {
    String name;String city;String location;
    String mytime_rating;String mytime_review_count;
    String photo_url;String max_price;String min_price;
    String next_appointment_times;String service_name;
    String sort_order;String state;String street_address;
    String website;String phone_number;String id;


    public Store(String id, String name, String city, String location, String mytime_rating, String mytime_review_count,
                 String photo_url, String max_price, String min_price, String next_appointment_times, String phone_number,
                 String service_name, String sort_order, String state, String street_address, String website) {
        this.id = id;

        this.name=name;this.city=city;this.location=location;
        this.mytime_rating=mytime_rating;this.mytime_review_count=mytime_review_count;
        this.photo_url=photo_url;this.max_price=max_price;this.min_price=min_price;
        this.next_appointment_times=next_appointment_times;this.service_name=service_name;
        this.sort_order=sort_order;this.state=state;this.street_address=street_address;
        this.phone_number=phone_number;this.website=website;
    }
    public String getId() {
        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public String getMytime_rating() {
        return mytime_rating;
    }

    public String getMytime_review_count() {
        return mytime_review_count;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public String getMax_price() {
        return max_price;
    }

    public String getMin_price() {
        return min_price;
    }

    public String getNext_appointment_times() {
        return next_appointment_times;
    }

    public String getService_name() {
        return service_name;
    }

    public String getSort_order() {
        return sort_order;
    }

    public String getState() {
        return state;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getWebsite() {
        return website;
    }

}

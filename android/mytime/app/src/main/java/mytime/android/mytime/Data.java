package mytime.android.mytime;

import org.json.JSONException;
import org.json.JSONObject;

import mytime.android.mytime.Structure.Company;
import mytime.android.mytime.Structure.IntakeForm;
import mytime.android.mytime.Structure.ModifiersValues;
import mytime.android.mytime.Structure.Store;
import mytime.android.mytime.Structure.Yelp;

/**
 * Created by DongJu on 10/23/16.
 */

public class Data {
    public static final String TAG_BITLY_URL="bitly_url";
    public static final String TAG_CITY="city";
    public static final String TAG_COMPANY="company";
    public static final String TAG_CONNECTED_CALENDAR="connected_calendar";
    public static final String TAG_DEAL_ID="deal_id";
    public static final String TAG_DEFAULT_PHOTO_SLATE_BLACK="photo_slate_black";
    public static final String TAG_DEFAULT_PHOTO_THUMB="default_photo_thumb";
    public static final String TAG_GOOGLE_REVIEWS="google_reviews";
    public static final String TAG_ID="id";
    public static final String TAG_INTAKE_FROMS="intake_forms";
    public static final String TAG_LOCATION="location";
    public static final String TAG_LOCATION_ID="location_id";
    public static final String TAG_LOCATION_COUNT="location_count";
    public static final String TAG_MAX_PRICE="max_price";
    public static final String TAG_MERCHANT_TIME_ZONE="merchant_time_zone";
    public static final String TAG_MIN_PRICE="min_price";
    public static final String TAG_MOBILITY="mobility";
    public static final String TAG_MODIFIERS_VALUES="modifiers_value";
    public static final String TAG_NAME="name";
    public static final String TAG_NEIGHBORHOODS="neighborhoods";
    public static final String TAG_NEXT_APPOINTMENT_TIMES="next_appointment_times";
    public static final String TAG_PHONE_NUMBER="phone_number";
    public static final String TAG_PHOTO_URL="photo_url";
    public static final String TAG_PHOTO_URLS="photo_urls";
    public static final String TAG_REQUIRE_MERCHANT_CONFIRMATION="require_merchant_confirmation";
    public static final String TAG_SERVICE_NAME="service_name";
    public static final String TAG_SERVICE_COUNT="services_count";
    public static final String TAG_SLUG_PATH="slug_path";
    public static final String TAG_SORT_ORDER="sort_order";
    public static final String TAG_STATE="state";
    public static final String TAG_ZIP="zip";
    public static final String TAG_STREET_ADDRESS="street_address";
    public static final String TAG_WEBSITE="website";
    public static final String TAG_YELP_RATING="yelp_rating";
    public static final String TAG_YELP_RATING_IMAGE_URL="yelp_rating_image_url";
    public static final String TAG_YELP_REVIEW_COUNT="yelp_review_count";
    public static final String TAG_YELP_URL="yelp_url";
    public static final String TAG_MYTIME_RATING="mytime_rating";
    public static final String TAG_MYTIME_REVIEW_COUNT="mytime_review_count";
    // json parsing tags
    Company company;
    IntakeForm intakeForm;
    ModifiersValues modifiersValues;
    Store store;
    Yelp yelp;

    public Data(JSONObject data) throws JSONException {
        JSONObject company_data = data.getJSONObject(TAG_COMPANY);
        this.company = new Company(company_data);
        // init company datas

//        JSONObject intakeform_data=data.getJSONObject(TAG_INTAKE_FROMS);
//        this.intakeForm = new IntakeForm(intakeform_data);
        // init intakeform datas

//        JSONObject modifiers_values_data=data.getJSONObject(TAG_MODIFIERS_VALUES);
//        this.modifiersValues=new ModifiersValues(modifiers_values_data);
        // init modifiersValues datas
        try {
            String yelp_rating = data.getString(TAG_YELP_RATING);
            String yelp_rating_image_url = data.getString(TAG_YELP_RATING_IMAGE_URL);
            String yelp_review_count = data.getString(TAG_YELP_REVIEW_COUNT);
            String yelp_url = data.getString(TAG_YELP_URL);
            this.yelp = new Yelp(yelp_rating, yelp_rating_image_url, yelp_review_count, yelp_url);
            // init yelp datas
        }catch(JSONException e){
            String yelp_rating = "";
            String yelp_rating_image_url = "";
            String yelp_review_count = "";
            String yelp_url = "";
            this.yelp = new Yelp(yelp_rating, yelp_rating_image_url, yelp_review_count, yelp_url);

        }
        try {
            String mytime_rating = data.getString(TAG_MYTIME_RATING);
            String mytime_review_count = data.getString(TAG_MYTIME_REVIEW_COUNT);
            String name = data.getString(TAG_NAME);
            String city = data.getString(TAG_CITY);
            String location = data.getString(TAG_LOCATION);
            String photo_url = data.getString(TAG_PHOTO_URL);
            String max_price = data.getString(TAG_MAX_PRICE);
            String min_price = data.getString(TAG_MIN_PRICE);
            String next_appointment_times = data.getString(TAG_NEXT_APPOINTMENT_TIMES);
            String service_name = data.getString(TAG_SERVICE_NAME);
            String sort_order = data.getString(TAG_SORT_ORDER);
            String state = data.getString(TAG_STATE);
            String street_address = data.getString(TAG_STREET_ADDRESS);
            String website = data.getString(TAG_WEBSITE);
            String phone_number = data.getString(TAG_PHONE_NUMBER);
            String id = data.getString(TAG_ID);
            //init store datas
            this.store = new Store(id, name, city, location, mytime_rating, mytime_review_count, photo_url, max_price
                    , min_price, next_appointment_times, phone_number, service_name, sort_order, state, street_address, website);
        }catch (JSONException e){
            String mytime_rating = "";
            String mytime_review_count = "";
            String name = data.getString(TAG_NAME);
            String city = data.getString(TAG_CITY);
            String location = data.getString(TAG_LOCATION);
            String photo_url = data.getString(TAG_PHOTO_URL);
            String max_price = data.getString(TAG_MAX_PRICE);
            String min_price = data.getString(TAG_MIN_PRICE);
            String next_appointment_times = data.getString(TAG_NEXT_APPOINTMENT_TIMES);
            String service_name = data.getString(TAG_SERVICE_NAME);
            String sort_order = data.getString(TAG_SORT_ORDER);
            String state = data.getString(TAG_STATE);
            String street_address = data.getString(TAG_STREET_ADDRESS);
            String website = data.getString(TAG_WEBSITE);
            String phone_number = data.getString(TAG_PHONE_NUMBER);
            String id = data.getString(TAG_ID);
            //init store datas
            this.store = new Store(id, name, city, location, mytime_rating, mytime_review_count, photo_url, max_price
                    , min_price, next_appointment_times, phone_number, service_name, sort_order, state, street_address, website);
        }

//        String photo_slate_black=data.getString(TAG_DEFAULT_PHOTO_SLATE_BLACK);
//        String default_photo_thumb=data.getString(TAG_DEFAULT_PHOTO_THUMB);
//        String photo_urls=data.getString(TAG_PHOTO_URLS);
//        // photo
//
//        String location_id = data.getString(TAG_LOCATION_ID);
//        String location_count = data.getString(TAG_LOCATION_COUNT);
//        String bitly_url=data.getString(TAG_BITLY_URL);
//        String deal_id=data.getString(TAG_DEAL_ID);
//        String google_reviews = data.getString(TAG_GOOGLE_REVIEWS);
//
//        String connected_calendar=data.getString(TAG_CONNECTED_CALENDAR);
//        String merchant_time_zone=data.getString(TAG_MERCHANT_TIME_ZONE);
//        String mobility=data.getString(TAG_MOBILITY);
//        String neighborhoods = data.getString(TAG_NEIGHBORHOODS);
//        String service_count=data.getString(TAG_SERVICE_COUNT);
//        String slug_path= data.getString(TAG_SLUG_PATH);
//        String zip = data.getString(TAG_ZIP);
//        // check later
    }
}

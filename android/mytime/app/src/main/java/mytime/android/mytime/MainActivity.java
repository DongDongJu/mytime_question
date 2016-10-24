package mytime.android.mytime;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView place_view;
    ArrayList<HashMap<String,String>> store_list;
    Util data_util;
    JSONArray places = null;

    final String url = "http://www.mytime.com/api/v1/deals.json?what=Massage&when=Anytime&where=34.052200,-118.242800";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        place_view=(ListView)findViewById(R.id.placeview);
        store_list= new ArrayList<HashMap<String,String>>();
        data_util=new Util();
        data_util.getData(url);
        //get data from url
    }
    protected void showList() {
        ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, store_list, R.layout.place_view_item,
                new String[]{Data.TAG_DEAL_ID, Data.TAG_NAME, Data.TAG_PHOTO_URL},
                new int[]{R.id.id, R.id.name, R.id.photo_url}
        );
        place_view.setAdapter(adapter);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        };
        place_view.setOnItemClickListener(listener);

    }
    public class Util {
        String JSON_data;
        public String[] JSON_datas;
        private ArrayList<Data> datas;

        //method : getData ( String url )
        //get data from url
        public void getData(String url){
            class GetDataJSON extends AsyncTask<String, Void, String> {
                ProgressDialog loading;

                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(MainActivity.this, "wait", null, true, true);
                }

                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    JSON_data = s;
                    JSON_datas=SplitData(JSON_data);
                    MakeDataFromJSON();
                    store_list=data_util.getStroeList();
                    showList();
                }

                @Override
                protected String doInBackground(String... params) {

                    String uri = params[0];

                    BufferedReader bufferedReader = null;
                    try {
                        URL url = new URL(uri);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        StringBuilder sb = new StringBuilder();

                        bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                        String json;
                        while ((json = bufferedReader.readLine()) != null) {
                            sb.append(json + "\n");
                        }
                        JSON_data = sb.toString().trim();
                        return JSON_data;
                    } catch (java.net.MalformedURLException e) {
                        return null;

                    } catch (java.io.IOException e) {
                        return null;
                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute(url);
        }

        //method : SplitData ( String JSON_data )
        // data split because of data is not clear
        private String[] SplitData(String JSON_data){
            String[] JSON_datas;
            JSON_datas = JSON_data.split("\\,\\{\"photo_url\"");
            for(int i=1;i<JSON_datas.length;i++)
            {
                int size=JSON_datas[i].length();
                JSON_datas[i]="\\{\"photo_url\"".concat(JSON_datas[i]).replace("\\","");
                System.out.println(JSON_datas[i]);
            }

            return JSON_datas;
        }
        public String removeCharAt(String s, int pos) {
            return s.substring(0,pos)+s.substring(pos+1);
        }
        //method : MakeDataFromJSON ()
        // make Data from JSON strings
        private void MakeDataFromJSON(){
            datas= new ArrayList<Data>();
            for(int i=1;i<this.JSON_datas.length-1;i++)
            {
                try{
                    JSONObject temp = new JSONObject(this.JSON_datas[i]);
                    Data data=new Data(temp);
                    datas.add(data);
                }catch (org.json.JSONException e)
                {

                }
            }
        }

        //method : MakeDataFromJSON ()
        //make instance for view from Datas
        public ArrayList<HashMap<String,String>> getStroeList(){
            ArrayList<HashMap<String,String>> stores = new ArrayList<HashMap<String,String>>();;

            for(int i=0;i<this.datas.size();i++)
            // for each data
            // select data what we want to display
            {
                HashMap<String,String> store = new HashMap<String,String>();
                Data data=datas.get(i);
                store.put(Data.TAG_NAME,data.store.getName());
                store.put(Data.TAG_PHOTO_URL,data.store.getPhoto_url());
                store.put(Data.TAG_CITY,data.store.getCity());
                store.put(Data.TAG_STATE,data.store.getState());
                store.put(Data.TAG_SERVICE_NAME,data.store.getService_name());
                store.put(Data.TAG_MIN_PRICE,data.store.getMin_price());
                store.put(Data.TAG_MAX_PRICE,data.store.getMax_price());
                store.put(Data.TAG_MYTIME_RATING,data.store.getMytime_rating());
                store.put(Data.TAG_MYTIME_REVIEW_COUNT,data.store.getMytime_review_count());
                store.put(Data.TAG_YELP_RATING,data.yelp.getYelp_rating());
                store.put(Data.TAG_YELP_REVIEW_COUNT,data.yelp.getYelp_review_count());
                store.put(Data.TAG_NEXT_APPOINTMENT_TIMES,data.store.getNext_appointment_times());
                stores.add(store);
            }
            return stores;
        }
    }
}

package au.com.scottellis.instagramclient;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import au.com.scottellis.instagramclient.model.Photo;
import au.com.scottellis.instagramclient.model.PhotoList;
import cz.msebera.android.httpclient.Header;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_photos)
public class PhotosActivity extends RoboActivity {
    private static final String API_URL = "https://api.instagram.com/v1/media/popular?client_id=5530a802b23648a0891aa812cbf033b4";
    private static final AsyncHttpClient client = new AsyncHttpClient();
    private static final String TAG = "PhotosActivity";

    @InjectView(R.id.lvPhotos) ListView lvPhotos;
    @InjectView(R.id.swipeContainer) SwipeRefreshLayout swipeContainer;

    private ArrayList<Photo> photos = new ArrayList<>();
    private PhotosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        adapter = new PhotosAdapter(this, photos);
        lvPhotos.setAdapter(adapter);

        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPhotos();
                swipeContainer.setRefreshing(false);
            }
        });
        getPhotos();
    }

    private void getPhotos() {
        client.get(this, API_URL, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    PhotoList photoList = mapper.readValue(response.toString().getBytes(), PhotoList.class);
                    photos.clear();
                    for(Photo photo: photoList.getData()) {
                        if(photo.getType().equalsIgnoreCase("image")) {
                            photos.add(photo);
                        }
                    }
                    adapter.notifyDataSetChanged();
                } catch(JsonParseException ex) {
                    Log.d(TAG, ex.toString());
                } catch(IOException ex) {
                    Log.d(TAG, ex.toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

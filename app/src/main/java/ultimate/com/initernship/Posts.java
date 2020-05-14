package ultimate.com.initernship;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Posts#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Posts extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<updatingClass> postList;
    private RequestQueue rq;
    private ProgressBar progressBar;
    private MyOwnAdapter myOA;
    View rootView;

    public Posts() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Posts newInstance() {
        Posts fragment = new Posts();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_posts, container, false);

        postList = new ArrayList<>();
        progressBar = (ProgressBar)rootView.findViewById(R.id.progressBar);

        final SwipeRefreshLayout pullToRefresh = rootView.findViewById(R.id.pullToRefreshPosts);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                jsonParse();
                pullToRefresh.setRefreshing(false);
            }
        });


        recyclerView = rootView.findViewById(R.id.recyclerVeiw);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myOA = new MyOwnAdapter(getContext(), postList);
        recyclerView.setAdapter(myOA);
        jsonParse();

        return rootView;
    }


    private void jsonParse() {
//        String url = "http://192.168.0.3:8000/";


        try {
            HashMap<String,String> r = new HashMap<>();
            r.put("title", "Mahakaleshwar Jyotirlingam Lord Of Time And Death");
            r.put( "purl", "https,//aastik.in/mahakaleshwar-jyotirlingam-lord-of-time-and-death/");
            r.put( "topic", "HINDUISM");
            r.put( "author", "Aastikin");
            r.put( "date", "May 21 2017");
            r.put( "des", " According to the Hindu Mythology Kaliyuga  (the time in which we are right now) will come to an end God have decided the judgment... ");
            r.put( "imgurl", "R.id.img.jpg");


            for (int i = 0; i < 10; i++) {
                JSONObject postDetail = new JSONObject(r);
                updatingClass post = new updatingClass();

                String imtUrl = postDetail.getString("imgurl");
                String title = postDetail.getString("title");
                String author = postDetail.getString("author");
                String postUrl = postDetail.getString("purl");
                String content = postDetail.getString("des");
                String topic = postDetail.getString("topic");
                String date = postDetail.getString("date");

//                Log.d("details",i+" "+title);
                post.setImage(imtUrl);
                post.setTitle(title);
                post.setAuthor(author);
                post.setNewsUrl(postUrl);
                post.setContent(content);
                post.setNewsUrl(postUrl);
                post.setTopic(topic);
                post.setTimeOfPost(date);

                postList.add(post);
//                        Log.d("data",i+" "+postList.get(i).getTitle());

            }
        } catch (JSONException e) {
            Log.d("excep",""+e);
            e.printStackTrace();
        }

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        try {
//            rq.add(request);
//
//        }catch (Exception e){
//            Log.d("k",""+e);
//        }

    }


}

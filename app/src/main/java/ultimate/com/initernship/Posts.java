package ultimate.com.initernship;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Posts#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Posts extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
    private RecyclerView recyclerView;
    private ArrayList<updatingClass> details;

    public Posts() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Posts newInstance() {
        Posts fragment = new Posts();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_posts, container, false);
        details = new ArrayList<>();
        final SwipeRefreshLayout pullToRefresh = rootView.findViewById(R.id.pullToRefreshPosts);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetch(); // your code
//                runLayoutAnimation(recyclerView);
                pullToRefresh.setRefreshing(false);
            }
        });

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerVeiw);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fetch();

        return rootView;
    }

    private void fetch(){
//        updatingClass c = new updatingClass("First Post", "Maneesh", "nothing", 23, "nothing... to");
//        details.add(c);
        for(int i=0 ;i<10;i++) {
            updatingClass c = new updatingClass("Post" +(i+1), "Maneesh", "nothing", 23, "nothing... to",R.drawable.img);
            details.add(c);
        }


        MyOwnAdapter myOA = new MyOwnAdapter(getContext(), details);
        recyclerView.setAdapter(myOA);

    }
}

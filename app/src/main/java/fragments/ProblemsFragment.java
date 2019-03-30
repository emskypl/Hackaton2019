package fragments;

import android.app.Notification;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hackaton2019.JsonRESTApi;
import com.example.hackaton2019.R;

import java.util.ArrayList;
import java.util.List;

import connect_model.ZgloszeniaAdapter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import testing.Post;
import testing.PostAdapter;
import connect_model.Zgloszenia;


public class ProblemsFragment extends Fragment {

    Retrofit retrofit;
    OkHttpClient okHttpClient;
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    JsonRESTApi jsonRESTApi;
    private static final String TAG = "ProblemsFragment";
    TabLayout tabLayout;
    TextView text;
    RecyclerView recyclerView;
    List<Post> postList;
    List<Zgloszenia> zgloszeniaList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.problems_tab_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {

        //test = (TextView) getView().findViewById(R.id.testText);
        tabLayout = (TabLayout) getView().findViewById(R.id.problemsTabs);
        InitServer();
        postList = new ArrayList<>();
        zgloszeniaList = new ArrayList<>();
        text = (TextView) getView().findViewById(R.id.asd);
        //getPosts();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getText().equals("Nowe")){
                    getAllNotifications();
                    //getPosts();
                }else if(tab.getText().equals("Hot")){
                    getHots();
                }else if(tab.getText().equals("Top")){
                    try {
                        recyclerView.setAdapter(null);
                    }catch (NullPointerException e){}


                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

    public void InitServer(){
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl("http://192.168.43.5:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        jsonRESTApi = retrofit.create(JsonRESTApi.class);
    }
/*
    public void getPosts(){
        Call<List<Post>> call = jsonRESTApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    postList.add(new Post(
                            post.getUserId(),
                            post.getId(),
                            String.format("|%10.10s|",post.getTitle()),
                            post.getText()
                    ));
                    recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    //creating recyclerview adapter
                    PostAdapter adapter = new PostAdapter(getContext(), postList);
                    //setting adapter to recyclerview
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //test.setText(t.getMessage());
            }
        });


    }
*/
    public void getHots(){
        Call<List<Zgloszenia>> call = jsonRESTApi.getReadBest25Scored();

        call.enqueue(new Callback<List<Zgloszenia>>() {
            @Override
            public void onResponse(Call<List<Zgloszenia>> call, Response<List<Zgloszenia>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                List<Zgloszenia> notifs = response.body();

                for(Zgloszenia notif : notifs){
                    zgloszeniaList.add(new Zgloszenia(
                            notif.getIdNotification(),
                            notif.getNotificationName(),
                            notif.getNotificationType(),
                            notif.getDescription(),
                            notif.getLocalization(),
                            notif.getIdStatus(),
                            notif.getStatusdescription(),
                            notif.getScore(),
                            notif.getNotificationTime()
                    ));
                    recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    ZgloszeniaAdapter adapter = new ZgloszeniaAdapter(getContext(), zgloszeniaList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Zgloszenia>> call, Throwable t) {

            }
        });
    }
    public void getAllNotifications(){
        Call<List<Zgloszenia>> call = jsonRESTApi.getAllNotifications();

        call.enqueue(new Callback<List<Zgloszenia>>() {
            @Override
            public void onResponse(Call<List<Zgloszenia>> call, Response<List<Zgloszenia>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                List<Zgloszenia> notifs = response.body();

                for(Zgloszenia notif : notifs){
                    zgloszeniaList.add(new Zgloszenia(
                            notif.getIdNotification(),
                            notif.getNotificationName(),
                            notif.getNotificationType(),
                            notif.getDescription(),
                            notif.getLocalization(),
                            notif.getIdStatus(),
                            notif.getStatusdescription(),
                            notif.getScore(),
                            notif.getNotificationTime()
                    ));
                    recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    //creating recyclerview adapter
                    ZgloszeniaAdapter adapter = new ZgloszeniaAdapter(getContext(), zgloszeniaList);
                    //setting adapter to recyclerview
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Zgloszenia>> call, Throwable t) {

            }
        });




    }

}
package com.example.phoneshop.Fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.phoneshop.AdapterMain;
import com.example.phoneshop.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

public class FragmentMain extends Fragment implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{

    Toolbar toolbar;
    SliderLayout sliderLayout;
    HashMap<String, String> HashMapForURL;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterMain adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        recyclerView = view.findViewById(R.id.recyclerViewMain);

        Toolbar toolbar = view.findViewById(R.id.toolbarMain);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        AddImagesUrlOnline();

        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(getContext());

            textSliderView
                    .description(name)
                    .image(HashMapForURL.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);

        layoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterMain();
        recyclerView.setAdapter(adapter);
//        adapter.setClick(this);

        RequestQueue queue = Volley.newRequestQueue(getContext());

        //create request
        String url = "https://api.myjson.com/bins/b772b";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //phone names
                String[] phoneNames = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneNames[i] = jsonObject.getString("name");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneNames(phoneNames);
                //phone prices
                String[] phonePrices = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phonePrices[i] = jsonObject.getString("price");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhonePrices(phonePrices);
                //phone image url
                String[] phoneImageUrl = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneImageUrl[i] = jsonObject.getString("image");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneImageUrls(phoneImageUrl);
                //phone battery
                String[] phoneBattery = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneBattery[i] = jsonObject.getString("battery");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneBattery(phoneBattery);
                //phone brand
                String[] phoneBrand = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneBrand[i] = jsonObject.getString("brand");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneBrand(phoneBrand);
                //phone memory
                String[] phoneMemory = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneMemory[i] = jsonObject.getString("memory");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneMemory(phoneMemory);
                //phone weight
                String[] phoneWeight = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneWeight[i] = jsonObject.getString("weight");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneWeight(phoneWeight);
                //phone screenSize
                String[] phoneScreenSize = new String[response.length()];
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        phoneScreenSize[i] = jsonObject.getString("screensize");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.setPhoneScreenSize(phoneScreenSize);

                Log.d("test0", "data :" + Arrays.toString(phoneImageUrl));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("bug", "load data error" + error.getMessage());
            }
        });
        queue.add(request);

        return view;
    }


    public void AddImagesUrlOnline() {

        HashMapForURL = new HashMap<>();

        HashMapForURL.put("iphone x", "https://drop.ndtv.com/TECH/product_database/images/913201720152AM_635_iphone_x.jpeg");
        HashMapForURL.put("iphone xr", "http://d176tvmxv7v9ww.cloudfront.net/product/cache/12/image/9df78eab33525d08d6e5fb8d27136e95/i/m/img-_0000s_0002_iphone-xr-red-select-201809_av2_geo_emea_1_6.jpg");
        HashMapForURL.put("iphone x1", "https://assets.pcmag.com/media/images/608623-iphone-xs-max.jpg?thumb=y");
        HashMapForURL.put("iphone x2", "https://assets.pcmag.com/media/images/608709-comparison.jpg?thumb=y&width=980&height=456");
        HashMapForURL.put("iphone x3", "https://amp.businessinsider.com/images/5a00bd8258a0c1776f8b4aff-750-500.jpg");
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

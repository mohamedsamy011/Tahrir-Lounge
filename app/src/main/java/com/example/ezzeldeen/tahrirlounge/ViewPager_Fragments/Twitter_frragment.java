package com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ezzeldeen.tahrirlounge.MantenerDominioWeb;
import com.example.ezzeldeen.tahrirlounge.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Twitter_frragment extends Fragment {
    private WebView webView;
    private static final String TAG = "Main";
    private ProgressDialog progress;


    public Twitter_frragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View rootView1=inflater.inflate(R.layout.fragment_twitter_frragment, container, false);

        webView = (WebView)rootView1.findViewById(R.id.webview_twitter);
        webView.setWebViewClient(new MantenerDominioWeb());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.canGoBack();
        webView.goBack();
        webView.loadUrl("https://twitter.com/Tahrirlounge");

        progress = ProgressDialog.show(getActivity(), "loading...",
                "loading your webpage.", true);
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                if (progress != null)
                    progress.dismiss();
            }
        });






        return rootView1;
    }

}

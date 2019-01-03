package com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.ezzeldeen.tahrirlounge.MantenerDominioWeb;
import com.example.ezzeldeen.tahrirlounge.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class facebook_fragment extends Fragment {
    private WebView webView;
    private static final String TAG = "Main";
    private ProgressDialog progress;



    public facebook_fragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


         View rootview =inflater.inflate(R.layout.fragment_facebook, container, false);


        webView = (WebView)rootview.findViewById(R.id.webview_facebook);
        webView.setWebViewClient(new MantenerDominioWeb());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.canGoBack();
        webView.goBack();
        webView.loadUrl("https://www.facebook.com/TahrirLounge/");

        progress = ProgressDialog.show(getActivity(), "loading...",
                "loading your webpage.", true);
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                if (progress != null)
                    progress.dismiss();
            }
        });





        return rootview;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();}





    }

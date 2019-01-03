package com.example.ezzeldeen.tahrirlounge;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by ezzeldeen on 28/09/2017.
 */

public class MantenerDominioWeb extends WebViewClient {





    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

}


package me.haloboy777.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeStandalonePlayer;


/**
 * Created by haloboy777 on 6/26/17.
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Button btnPlayVideos = (Button) findViewById(R.id.btnPlayVideo);
        Button btnPlaylist  = (Button) findViewById(R.id.btnPlaylist);

        btnPlayVideos.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, true);
                break;
            default:

        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}

package wallpapers.cactustree.pc.ultimatesoundboard;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main soundboard app activity screen
 */
public class MainActivity extends AppCompatActivity {

    private List<SoundObject> soundObjectList = new ArrayList<>();

    private Toolbar toolbar;

    private RecyclerView soundView;
    private SoundboardRecyclerAdapter soundAdapter;
    private RecyclerView.LayoutManager soundLayoutManager;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_activity_layout);

        toolbar = findViewById(R.id.soundboard_toolbar);
        setSupportActionBar(toolbar);

        soundObjectList = getFilledSoundObjectsList();
        soundAdapter = new SoundboardRecyclerAdapter(soundObjectList);

        soundView = findViewById(R.id.soundboard_recycler_view);
        soundLayoutManager = new GridLayoutManager(this, 3);
        soundView.setLayoutManager(soundLayoutManager);
        soundView.setAdapter(soundAdapter);
    }

    /**
     * Sound items adder and filler
     *
     * @return generated and filled sound object list
     */
    private List<SoundObject> getFilledSoundObjectsList() {
        List<SoundObject> soundObjectList = new ArrayList<>();
        List<String> soundItemNamesList = Arrays.asList(getResources().getStringArray(R.array.soundNames));
        SoundObject[] soundObjects = {
                new SoundObject(soundItemNamesList.get(0), R.raw.audio01),
                new SoundObject(soundItemNamesList.get(1), R.raw.audio02),
                new SoundObject(soundItemNamesList.get(2), R.raw.audio03)
        };
        soundObjectList.addAll(Arrays.asList(soundObjects));
        return soundObjectList;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventHandlerClass.releaseMediaPlayer();
    }
}

package wallpapers.cactustree.pc.ultimatesoundboard;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;

/**
 * Class hold mediaplayer methods which are used on sound item click to play
 * and on long click to show popup menu.
 */
public class EventHandlerClass {

    private static final String LOG_TAG = "SYSTEM_ERROR";

    private static MediaPlayer mp;

    protected static void startMediaPlayer(View view, Integer soundID) {
        try {
            if (soundID != null) {
                if (mp != null) {
                    mp.reset();
                }

                mp = MediaPlayer.create(view.getContext(), soundID);
                mp.start();
            }
        } catch (Exception ex) {
            Log.e(LOG_TAG, "Failed to initialize mediaplayer: " + ex.getMessage());
        }
    }

    protected static void releaseMediaPlayer() {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    /**
     * Shows intent for sharing selected sound item object.
     */
    private static void showShareIntent(Context context, Uri uri) {
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("audio/mp3");
        context.startActivity(Intent.createChooser(shareIntent, "Share selected sound..."));
    }
}

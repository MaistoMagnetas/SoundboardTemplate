package wallpapers.cactustree.pc.ultimatesoundboard;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Recycler view adapter for generating sound items.
 */
public class SoundboardRecyclerAdapter extends Adapter<SoundboardRecyclerAdapter.SoundboardViewHolder> {

    private List<SoundObject> soundObjectsList;

    SoundboardRecyclerAdapter(List<SoundObject> soundObjectsList) {
        this.soundObjectsList = soundObjectsList;
    }

    @Override
    public SoundboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item, null);
        return new SoundboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SoundboardViewHolder holder, int position) {
        final SoundObject soundObject = soundObjectsList.get(position);
        final Integer soundID = soundObject.getSoundItemID();
        holder.soundItemTextView.setText(soundObject.getSoundItemName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventHandlerClass.startMediaPlayer(view, soundID);
            }
        });
    }

    @Override
    public int getItemCount() {
        return soundObjectsList.size();
    }

    /**
     * Class for a view holder in recycler view. Customizes single sound items - text.
     */
    class SoundboardViewHolder extends RecyclerView.ViewHolder {
        private TextView soundItemTextView;

        SoundboardViewHolder(View itemView) {
            super(itemView);

            soundItemTextView = itemView.findViewById(R.id.sound_item_text);
        }
    }
}

package wallpapers.cactustree.pc.ultimatesoundboard;

/**
 * Class hold methods used by single sound object.
 */
class SoundObject {

    private String soundItemName;
    private int soundItemID;

    SoundObject(String soundItemName, int soundItemID)
    {
        this.soundItemName = soundItemName;
        this.soundItemID = soundItemID;
    }

    String getSoundItemName() {
        return soundItemName;
    }

    int getSoundItemID() {
        return soundItemID;
    }
}

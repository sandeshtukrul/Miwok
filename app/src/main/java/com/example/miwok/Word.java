package com.example.miwok;

public class Word {
    private int miwok;
    private  int english;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int imageid = NO_IMAGE_PROVIDED;
    private int audioid;

    public Word(int mEng, int mMiwok, int mImageid, int mAudio) {
        miwok = mMiwok;
        english = mEng;
        imageid = mImageid;
        audioid = mAudio;
    }

    public Word(int mEng, int mMiwok, int mAudio) {
        miwok = mMiwok;
        english = mEng;
        audioid = mAudio;
    }

    public int getMiwok(){
        return miwok;
    }

    public int getEnglish(){
        return english;
    }

    public int getImageid() {
        return imageid;
    }

    public boolean hasImage(){
        return imageid != NO_IMAGE_PROVIDED;
    }

    public int getAudioid(){
        return audioid;
    }

}

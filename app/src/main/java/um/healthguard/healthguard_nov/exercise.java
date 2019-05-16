package um.healthguard.healthguard_nov;

import android.os.Parcel;
import android.os.Parcelable;

public class exercise implements Parcelable {
    int img_path;
    String name;
    String videoPath;

    exercise(int a, String b,String c){
        img_path=a;
        name=b;
        videoPath=c;
    }

    protected exercise(Parcel in) {
        img_path = in.readInt();
        name = in.readString();
        videoPath = in.readString();
    }

    public static final Creator<exercise> CREATOR = new Creator<exercise>() {
        @Override
        public exercise createFromParcel(Parcel in) {
            return new exercise(in);
        }

        @Override
        public exercise[] newArray(int size) {
            return new exercise[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(img_path);
        parcel.writeString(name);
        parcel.writeString(videoPath);
    }
}

package ultimate.com.initernship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MHolder> {

    private final Context ct;
    private ArrayList<updatingClass> data;

    static class MHolder extends RecyclerView.ViewHolder {
        TextView titleR, contentR,authorR,timeR,typeR;
        ImageView imageR;

        MHolder(@NonNull View itemView) {
            super(itemView);
            titleR = (TextView) itemView.findViewById(R.id.title);
            typeR = (TextView) itemView.findViewById(R.id.type_of_content);
            contentR = (TextView) itemView.findViewById(R.id.content);
            authorR = (TextView)itemView.findViewById(R.id.author);
            timeR = (TextView)itemView.findViewById(R.id.time);
            imageR = (ImageView)itemView.findViewById(R.id.image);

        }
    }

    public MyOwnAdapter(Context ct ,ArrayList<updatingClass> info){
        this.ct = ct;
        data = info;
    }

    @NonNull
    @Override
    public MyOwnAdapter.MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(parent.getContext());
        View myView = myInflator.inflate(R.layout.card_view_for_posts,parent,false);
        return new MHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {

        updatingClass obj = data.get(position);
        long time = obj.getTimeOfPost();
        holder.titleR.setText(obj.getTitle());
        holder.typeR.setText(obj.getTopic());
        holder.authorR.setText(obj.getAuthor());
        holder.timeR.setText(String.valueOf(time));
        holder.contentR.setText(obj.getContent());
        holder.imageR.setImageBitmap( decodeImage((int) obj.getImage()));

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public Bitmap decodeImage(int resourceId) {
        try {
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(ct.getResources(), resourceId, o);
            // The new size we want to scale to
            final int REQUIRED_SIZE = 100; // you are free to modify size as your requirement

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE && o.outHeight / scale / 2 >= REQUIRED_SIZE)
                scale *= 2;

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeResource(ct.getResources(), resourceId, o2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;

    }

}

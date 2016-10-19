package soorajshingari.kietmessenger;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static soorajshingari.kietmessenger.R.layout.post_card;


/**
 * Created by Shrey on 04-10-2016.
 */

public class RecyclerView_Adapter extends  RecyclerView.Adapter<viewHolder> {
    private final LayoutInflater inflator;

    List<singlePostCard> card= Collections.emptyList();


    RecyclerView_Adapter(Context context,List<singlePostCard> card)
    {
        inflator = LayoutInflater.from(context);
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflator.inflate(post_card,parent,false);
        viewHolder myViewHolder=new viewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        singlePostCard currentobject=card.get(position);
        holder.personName.setText(currentobject.personName);
        holder.question.setText(currentobject.question);
        holder.answer.setOnClickListener((View.OnClickListener) currentobject.answer);
        holder.image.setImageResource(currentobject.image);

    }

    @Override
    public int getItemCount() {
        return card.size();
    }
}
class viewHolder extends RecyclerView.ViewHolder{

    TextView personName,question;
    ImageView image;
    Button answer;
    public viewHolder(View itemView) {
        super(itemView);
        personName=(TextView) itemView.findViewById(R.id.person);
        question=(TextView) itemView.findViewById(R.id.question);
        image=(ImageView)itemView.findViewById(R.id.image);
        answer=(Button) itemView.findViewById(R.id.answer);
    }
}

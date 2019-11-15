package ctis487.labguide7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewItemHolder> {
    private Context context;
    private ArrayList<House> recyclerItemValues;

    //Custom Dialog
    int selected;
    Dialog customDialog;
    Button btnDialogDone;
    TextView nameOfHouse;
    TextView houseWords;
    ImageView houseLogo;
    House currentSelectedHouse;

    public MyRecyclerViewAdapter(Context context, ArrayList<House> values) {
        this.context = context;
        this.recyclerItemValues = values;
    }

    @NonNull
    @Override
    public MyRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_layout, viewGroup, false);

        MyRecyclerViewItemHolder mViewHolder = new MyRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewItemHolder myRecyclerViewItemHolder, int i) {

        final House sm = recyclerItemValues.get(i);

        myRecyclerViewItemHolder.name.setText(sm.getName());
        myRecyclerViewItemHolder.words.setText(sm.getWords());
        myRecyclerViewItemHolder.img.setImageResource(sm.getLogo());


        myRecyclerViewItemHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked on item " + sm.getName(), Toast.LENGTH_LONG).show();
                makeAndShowDialogBox(sm.getName(),sm.getLogo(),sm.getWords());
            }
        });

        myRecyclerViewItemHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                               Toast.makeText(context, "Clicked on " + sm.getName() + " Image of item", Toast.LENGTH_LONG).show();
                makeAndShowDialogBox(sm.getName(),sm.getLogo(),sm.getWords());
            }
        });

        myRecyclerViewItemHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked on " + sm.getName() + " TextView of item", Toast.LENGTH_LONG).show();
                makeAndShowDialogBox(sm.getName(),sm.getLogo(),sm.getWords());
            }
        });


    }

    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    class MyRecyclerViewItemHolder extends RecyclerView.ViewHolder {
        TextView name, words;
        ImageView img;
        ConstraintLayout parentLayout;

        public MyRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rec_tv);
            words = itemView.findViewById(R.id.rec_exp);
            img = itemView.findViewById(R.id.rec_img);
            parentLayout = itemView.findViewById(R.id.constLayout);
        }
    }

    private void makeAndShowDialogBox(String hname,int logo,String hWords) {
        AlertDialog.Builder mDialogBox = new AlertDialog.Builder(context);
        // set message, title, and icon
        mDialogBox.setTitle(hname);
        mDialogBox.setMessage(hWords);
        mDialogBox.setIcon(logo);

        // Set three option buttons
        mDialogBox.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "YES" goes
                        // here
                    }
                });
        mDialogBox.create();
        mDialogBox.show();
    }


}

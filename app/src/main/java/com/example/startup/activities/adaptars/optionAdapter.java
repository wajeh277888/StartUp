package com.example.startup.activities.adaptars;

/*
public class optionAdapter extends RecyclerView.Adapter<optionAdapter.MyviewHolder> {
    public ArrayList<String> options = new ArrayList<>();
    question quest;



    public optionAdapter(question que) {
        this.options.add(que.option1);
        this.options.add(que.option2);
        this.options.add(que.option3);
        this.options.add(que.option4);
        this.quest = que;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.option_item, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        String opt = options.get(position);
        holder.optionView.setText(opt+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setUserAnswer(opt);
                notifyDataSetChanged();

            }


        });

        if(question.getUserAnswer() == opt){
            holder.itemView.setBackgroundResource(R.drawable.selected_bg);

        }
        else{
            holder.itemView.setBackgroundResource(R.drawable.item_bg);
        }
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public  static  class MyviewHolder extends  RecyclerView.ViewHolder{

        TextView optionView;

        public MyviewHolder(View itemView) {
            super(itemView);
            optionView = itemView.findViewById(R.id.quiz_option);

        }
    }


}*/

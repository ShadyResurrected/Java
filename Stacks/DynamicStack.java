package com.company.Stacks;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super(); // it is a constructor which will call CustomStack()
    }

    public DynamicStack(int size){
        super(size); // it will call CustomStack(int size)
    }

    @Override
    public boolean push(int item){
        // this takes care of it being full
        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all the previous items in new array
            for (int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }

            data = temp;
        }

        // at this point we know array is not full
        // insert item
        return super.push(item);
    }
}

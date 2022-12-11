package com.company.Miscellaneous;
import java.util.Scanner;
public class Practice_Problems6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //float user;
        //float sum=0;
        //float [] F;
        //F=new float[5];
        //for(int i=0;i<5;i++){
        //System.out.printf("Enter %dth element: ",i);
        //user=sc.nextFloat();
        //sum=sum+user;
        //}
        //System.out.println(sum);


        /*
        int [] number=new int[5];
        for(int i=0;i<5;i++){
            System.out.printf("Enter %dth element: ",i);
            int user=sc.nextInt();
            number[i]=user;
        }
        for(int i=0;i<5;i++){
            System.out.println(number[i]);
        }
        boolean isInArray=false;
        System.out.println("Enter the number you want to find in array: ");
        int find=sc.nextInt();
        for(int i=0;i<5;i++){
            if(find==number[i]){
                isInArray=true;
                break;
            }
        }
        if(isInArray){
            System.out.println("Element is present");
        }
        else{
            System.out.println("Element is not present");
        }

         */

        //float [] marks={45.7f,77.5f,13.5f,78.5f};
        //float avg=0;
        //System.out.println(marks.length);
        //for(int i=0;i<marks.length;i++){
        //  avg=avg+marks[i];
        //}
        //System.out.println(avg/4);


        //float [] marks={45.7f,77.5f,13.5f,78.5f};
        //float avg=0;
        //System.out.println(marks.length);
        //for(float mark:marks){
        //  avg=avg+mark;
        //}
        //System.out.println(avg/4);

        //Matrix addition of (2X3)


        /*
        int [][] number=new int[2][3];
        int i,j;
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                System.out.printf("Enter element for %d %d index: ",i,j);
                int user=sc.nextInt();
                number[i][j]=user;
            }
        }
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                System.out.printf("%d ",number[i][j]);

            }
            System.out.println("");
        }

        int [][] number2=new int[2][3];
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                System.out.printf("Enter element for %d %d index: ",i,j);
                int user=sc.nextInt();
                number2[i][j]=user;
            }
        }
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                System.out.printf("%d ",number2[i][j]);

            }
            System.out.println("");
        }

        int [][] number3=new int[2][3];
        System.out.println("Addition of matrix is: ");
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                number3[i][j]=number[i][j]+number2[i][j];
            }
        }
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                System.out.printf("%d ",number3[i][j]);
            }
            System.out.println("");
        }

         */


        /*
        int []marks=new int[5];
        for(int i=0;i<5;i++){
            System.out.printf("Enter %dth element: ",i);
            int user=sc.nextInt();
            marks[i]=user;
        }
        for(int i=0;i<5;i++){
            System.out.print(marks[i]);
            System.out.print("\t");
        }
        System.out.println("");
        System.out.println("Reversed array is: ");
        int n=marks.length;
        int l=Math.floorDiv(n,2);
        for(int i=0;i<l;i++){
            int a=marks[i];
            marks[i]=marks[n-1-i];
            marks[n-1-i]=a;

        }
        for(int i=0;i<n;i++){
            System.out.print(marks[i]);
            System.out.print("\t");
        }

         */



        /*
        //int [] marks={1,32,34,87,97};
        int [] marks=new int[5];
        int i,tmp,j,user;
        for(i=0;i<5;i++){
            System.out.printf("Enter element for %dth index: ",i);
            user=sc.nextInt();
            marks[i]=user;
        }
        for(i=0;i<5;i++){
            System.out.print(marks[i]);
            System.out.print("\t");
        }
        for(i=0;i<5;i++){
            for(j=i+1;j<5;j++){
                if(marks[i]<marks[j]){
                    tmp=marks[i];
                    marks[i]=marks[j];
                    marks[j]=tmp;
                }
            }
        }
        System.out.print("Largest element is: ");
        System.out.print(marks[0]);

         */

        /*

        int [] marks=new int[5];
        int i,tmp,j,user;
        int l=marks.length;
        for(i=0;i<5;i++){
            System.out.printf("Enter the element for %dth index: ",i);
            user=sc.nextInt();
            marks[i]=user;
        }
        for(i=0;i<5;i++){
            System.out.print(marks[i]);
            System.out.print("\t");
        }
        for(i=0;i<5;i++){
            for(j=i+1;j<5;j++){
                if(marks[i]<marks[j]){
                    tmp=marks[i];
                    marks[i]=marks[j];
                    marks[j]=tmp;
                }
            }
        }

        System.out.print("The smallest element is: ");
        System.out.print(marks[l-1]);


         */

        /*
        int[] marks = new int[5];
        int i, j, tmp, user;
        int length = marks.length;
        for (i = 0; i < 5; i++) {
            System.out.printf("enter the element for %dth index: ", i);
            user = sc.nextInt();
            marks[i] = user;
        }
        for (i = 0; i < 5; i++) {
            for (j = i + 1; j < 5; j++) {
                if (marks[i] < marks[j]) {
                    tmp = marks[i];
                    marks[i] = marks[j];
                    marks[j] = tmp;
                }
            }
        }
        for(i=0;i<5;i++){
            System.out.print(marks[i]);
            System.out.print("\t");
        }
        int check = 0;
        int l=marks.length;
        for (i = 0; i < 4; i++) {
            if (marks[i] > marks[i + 1]) {
                check++;
            }

        }
        if(check==l-1){
            System.out.printf("List is sorted %d");
        }
        else
            System.out.println("List is not sorted");

         */

        /*
        int [] arr={-1,23,54,65,76,87};
        int max=Integer.MIN_VALUE;               //It gives the minimum value i.e -2147483648 and stores it in variable max
        int min=Integer.MAX_VALUE;               //It gives maximum value and stores it in variable min
        for(int i=0;i<6;i++){
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        System.out.printf("The largest element is %d\n",max);
        System.out.printf("The Smallest element is %d\n",min);

         */

    }
}

package dataStructe;

public class sparseArray {

    //original array tO sparse array
    public int[][] originalTOSparse(int originalArray[][],int row,int column){
        //遍历原始数组
        int sum = 0;
        for(int i=0;i<11;i++){
            for(int j= 0;j<11;j++){
                if(originalArray[i][j]!=0){
                    sum++;
                }
            }
        }
        //根据结果创建稀疏数组
        int sparseArray[][] = new int[sum+1][3] ;
        sparseArray[0][0]=row;
        sparseArray[0][1]=column;
        sparseArray[0][2]=sum;

        int tempRow=1;

        for(int i=0;i<row;i++){
            for(int j= 0;j<column;j++){
                if(originalArray[i][j]!=0){
                    sparseArray[tempRow][0]=i;
                    sparseArray[tempRow][1]=j;
                    sparseArray[tempRow][2]=originalArray[i][j];
                    tempRow++;
                }
            }
        }

        return sparseArray;
    }


    //sparse array to original array
    public int[][] sparseToOriginal(int sparseArray[][]){
        int row=sparseArray[0][0];
        int colmun=sparseArray[0][1];
        int sum=sparseArray[0][2];

        int[][] orginalArrary = new int[row][colmun];


        for(int tempRow=1;tempRow<=sum;tempRow++){
            orginalArrary[sparseArray[tempRow][0]][sparseArray[tempRow][1]]=sparseArray[tempRow][2];

        }


        return orginalArrary;

    }
    public int[][] array_init(){
        int row=11;
        int column=11;
        int originalArray[][] = new int[row][column];
        originalArray[1][2]=1;
        originalArray[2][3]=2;
        return originalArray;
    }

    public void printArray(int Array[][]){
        for(int[] rows:Array) {
            for(int data:rows){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }




}

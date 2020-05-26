package game;

public class Field {
    private int[][] fields;
    private final int[][] standardFields = {
            {4,6,2,5,1},
            {5,2,1,0,5},
            {6,2,3,1,5},
            {6,4,6,3,6},
            {5,3,4,5,1},
            {3,6,0,3,3}
    };

    public Field(){
        fields=new int[6][5];
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++) {
                fields[i][j]=0;
            }
        }
    }

    public void randomizedFields(){
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++) {
                this.fields[i][j]=(int)(Math.random()*6);
            }
        }
    }

    public void loadStandardFields(){
        this.fields=standardFields;
    }

    public int[][] getFields() {
        return fields;
    }
}

package game;

public class Field {
    private final int[][] fields;
    public Field(){
        fields=new int[6][5];
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++) {
                fields[i][j]=(int)(Math.random()*6)+1;
            }
        }
    }

    public int[][] getFields() {
        return fields;
    }
}

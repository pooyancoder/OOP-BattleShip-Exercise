public class Ship{
    private int size;
    private boolean isHorizontal; 
    private String[size] place;
    {
        for(int i = 0 ; i<size ; i++){
            place[i] = new String();
        }
    }
    public void (int size){
        this.size = size;
    }
    public void polarization(boolean is){
        this.isHorizontal;
    }
    public void setPlace(String firstplace){
        char p1 = firstplace.charAt(0);
        char p2 = firstplace.charAt(1);
        if(isHorizontal){
            for(int i = 0 ; i<size ; i++){
                plase[i] = p1 + (char)(p2 + i);
            }
        }
        if(!isHorizontal){
            for(int i = 0 ; i<size ; i++){
                plase[i] = (char)(p1 + i) + p2;
            }
        }
    }
}
public class Ship {
    private int size;
    private boolean isHorizontal;
    public String[] places;

    public void setSize(int size) {
        this.size = size;
        this.places = new String[size];
    }

    public void polarization(boolean is) {
        this.isHorizontal = is;
    }

    public void setPlace(String firstplace) {
        char p1 = firstplace.charAt(0);
        char p2 = firstplace.charAt(1);
        if (isHorizontal) {
            for (int i = 0; i < size; i++) {
                places[i] = String.valueOf(p1) + String.valueOf((char) (p2 + i));
            }
        } else {
            for (int i = 0; i < size; i++) {
                places[i] = String.valueOf((char) (p1 + i)) + String.valueOf(p2);
            }
        }
    }
}
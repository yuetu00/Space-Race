public class Collection {
    Collectable[][] collection;

    public Collection(){
        Collectable[][] collection = new Collectable[3][3];

        for (int row = 0; row < collection.length; row++){
            for (int col = 0; col < collection[row].length; col++) {

                // Walking
                if (row == 0 && col == 0){
                    collection[row][col] = new Collectable(1,1);
                } else if (row == 0 && col == 1){
                    collection[row][col] = new Collectable(1,2);
                } else if (row == 0 && col == 2){
                    collection[row][col] = new Collectable(1,3);

                    // Yoga
                } else if (row == 1 && col == 0){
                    collection[row][col] = new Collectable(2,1);
                } else if (row == 1 && col == 1) {
                    collection[row][col] = new Collectable(2,2);
                } else if (row == 1 && col == 2){
                    collection[row][col] = new Collectable(2,3);

                    // Gym
                } else if (row == 2 && col == 0) {
                    collection[row][col] = new Collectable(3,1);
                } else if (row == 2 && col == 1) {
                    collection[row][col] = new Collectable(3,2);
                } else if (row == 2 && col == 2){
                    collection[row][col] = new Collectable(3,3);
                }
                System.out.println(collection[row][col]);
            }
        }
    }
}

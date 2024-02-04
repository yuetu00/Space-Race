public class Collectable{
    //Creature Features
    boolean isCollected = false;
    //For text output 
    String name;
    //To identify exact collectable
    int ID = 0; 

public createCollectable(int planet, int color){
    //Initialize Creatures with species type and planet (int codes)
        //color #s 1-3
    this.planet = planet;   

    switch(planet){

        //Walking
        case 1:
            if (color == 1){
                this.name = "creature1_P1";
                ID = 1;
            }
            if (color == 2){
                this.name = "creature2_P1";
                ID = 2;
            }
            //Object
            else{
                this.name = "creature3_P1";
                ID = 3;
            }
            break;

        //Yoga
        case 2:
            if (color == 1){
                this.name = "creature1_P2";
                ID = 3;
            }
            if (color == 2){
                this.name = "creature2_P2";
                ID = 4;
            }
            else{
                this.name = "creature3_P2";
                ID = 5;
            }
            break;

        //Gym
        case 3:
            if (color == 1){
                this.name = "creature1_P3";
                ID = 5;
            }
            if (color == 2){
                this.name = "creature2_P3";
                ID = 1;
            }
            else{
                this.name = "creature3_P3";
                ID = 6;
            }
            break;
        }  
    }
}

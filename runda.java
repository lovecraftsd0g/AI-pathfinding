import java.util.LinkedList;

public class runda{
    static int tilesize_x = 4;
    static int tilesize_y = 4;
    static int targetx =4, targety = 4;
    static int excX = 0,excY = 0;
    static LinkedList<tiles> tile_path = new LinkedList<>();
    static commanddd meth = new commanddd();
    public static void main(String[] args){

        tiles[][] tileset = new tiles[tilesize_y][tilesize_x];
        //instantiating tile set
        meth.add_effy(tileset,0,0,tilesize_y,tilesize_x);

        //
        tiles exc = tileset[excY][excX];
        exc.setstate(3);
        tile_path.add(exc);
        //while loop determining weather it reaches target
        meth.pathfind(tile_path,tileset,targety,targetx);

        for(tiles tilish: tile_path){
            if(tilish.returnx() == excX && tilish.returny() == excY){
            System.out.println(tilish.returndesignation() + "start");
            }else {
                System.out.println(tilish.returndesignation());
            }
        }

    }
/**
 *  if one path does not reach destination disable that path,
 * by adjust the starting tile state, than change it back after valid path has been found
 *
 */


}

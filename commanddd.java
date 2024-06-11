import java.util.ArrayList;
import java.util.LinkedList;


public class commanddd {
    public boolean add_effy(tiles[][] tileset, int y, int x, int tilesizey, int tilesizex){
        if (y < tilesizey){
            add_effx(tileset,y,x,tilesizex);
            return add_effy(tileset,y+1,x,tilesizey,tilesizex);
        }else {
            return true;
        }
    }

    public boolean pathfind(LinkedList<tiles> tile_path, tiles[][] tileset, int targety, int targetx){
        //if target is more than 0
        //make else if , if the size of the current list is 0
        if(tile_path.get(tile_path.size()-1).returnx() != targetx-1 || tile_path.get(tile_path.size()-1).returny() != targety-1){
            tile_path.getLast().detecting_adjacenttile(tileset[targety-1][targetx-1],tile_path,tileset);
            return pathfind(tile_path,tileset,targety,targetx);
        }else {
            return true;
        }
    }

    public boolean add_effx(tiles[][] tileset, int y, int x, int tilesize){
        if (x < tilesize){
            String desig = Integer.toString(x+1);
            desig += Integer.toString(y+1);
            tiles atile = new tiles(x,y,desig,tileset);
            tileset[y][x] = atile;
            return add_effx(tileset,y,x+1,tilesize);
        }else {
            return true;
        }
    }
    public Double distance(tiles target, tiles oth_tile){
        return Math.abs(Math.sqrt(Math.pow(target.returnx() - oth_tile.returnx(),2)+Math.pow(target.returny() - oth_tile.returny(),2)));
    }
    public tiles compare_dists(LinkedList<tiles> tiles, tiles currtile, int index, tiles target){
        if(currtile == null){
            currtile = tiles.get(index);
            return compare_dists(tiles, currtile, index+1, target);
        }else if(index == tiles.size() - 1){
            Double current_tile_dist = distance(target,currtile),//the distance between the current tile and place
                    new_tile_distance = distance(target, tiles.get(index));//the distance between the new tile and place
            if(new_tile_distance < current_tile_dist){
                currtile = tiles.get(index);
            }
            return currtile;

        }else{
            Double currdist =distance(target,currtile),//the distance between the current tile and place
                    newdist = distance(target, tiles.get(index));//the distance between the new tile and place
            if(newdist < currdist){
                currtile = tiles.get(index);
            }
            /*if(index == tiles.size() - 1) {
                return compare_dists(tiles, currtile, index, target);
            }else {*/
                return compare_dists(tiles, currtile, index+1, target);


        }
    }

}


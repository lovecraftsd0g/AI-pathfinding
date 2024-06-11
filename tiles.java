import java.util.LinkedList;

public class tiles {
    private String designation;
    public boolean leftstart,rightstart,upstart,downstart;
    private int state = 1;
    private int x;
    private int y;
    tiles uptile = null,
            downtile = null,
            righttile = null,
            leftile = null;
    LinkedList<tiles> potentialpathlist = new LinkedList<>();

    public tiles (int x,int y,String designation,tiles[][] tiles){
        setdesignation(designation);
        setx(x);
        sety(y);
        //checking adjacent tiles
    }

    public String returndesignation(){
        return this.designation;
    }
    public int returnstate(){
        return this.state;
    }
    public int returnx(){
        return this.x;
    }
    public int returny(){
        return this.y;
    }

    public void setstate(int i){
        this.state = i;
    }
    public void setx(int number){ this.x = number;}
    public void sety(int number){
        this.y = number;
    }
    public void setdesignation(String string){

        this.designation = string;
    }
    public void detecting_adjacenttile(tiles target, LinkedList<tiles> tilepath,tiles[][] tiles) {
        commanddd metho = new commanddd();
        tiles chosentile = null;
        if(potentialpathlist.isEmpty()){
            tilepath.remove(this);
            return;
        }
        if( this.returny() > 0 && tiles[this.returny()-1][this.returnx()].returnstate() < 2){//&& upstart){
            uptile = tiles[this.returny()-1][this.returnx()];
            System.out.println(uptile.returndesignation());
            potentialpathlist.add(uptile);
        }
        if(this.returny() < (tiles.length - 1) && tiles[this.returny()+1][this.returnx()].returnstate() < 2){//&&  downstart){
            downtile= tiles[this.returny()+1][this.returnx()];
            System.out.println(downtile.returndesignation());
            potentialpathlist.add(downtile);
        }
        if(this.returnx() < (tiles[this.returny()].length - 1) && tiles[this.returny()][this.returnx()+1].returnstate() < 2 ){//right
            righttile = tiles[this.returny()][this.returnx()+1];
            System.out.println(righttile.returndesignation());
            potentialpathlist.add(righttile);
        }
        if(this.returnx() > 0&& tiles[this.returny()][this.returnx()-1].returnstate() < 2  ){//&&  leftstart){
            leftile = tiles[this.returny()][this.returnx()-1];
            System.out.println(leftile.returndesignation());
            potentialpathlist.add(leftile);
        }
        chosentile = metho.compare_dists(potentialpathlist, null, 0, target);
        chosentile.setstate(3);
        tilepath.add(chosentile);

    }
}

